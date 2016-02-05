package serializers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Intermediate base class for tests that use a single <code>MediaItem</code>
 * as data.
 * The only method missing is <code>addTests</code>, which defines codecs to use.
 */
public abstract class MediaItemBenchmark extends BenchmarkBase
{
    public MediaItemBenchmark() { }
    
    public void runBenchmark(InputStream testFile, int fileLength, String[] args) throws IOException {
        runBenchmark(args,
                testFile,
                fileLength,
                Create,
                Serialize,
                Deserialize);
    }
    
    @Override
    protected <J> byte[] serializeForSize(Transformer<J,Object> transformer, Serializer<Object> serializer, J value)
        throws Exception
    {
        return serializer.serialize(transformer.forward(value));
    }
    
    @Override
    protected <J> void checkCorrectness(PrintWriter errors, Transformer<J,Object> transformer,
            Serializer<Object> serializer, J value)
        throws Exception
    {
        checkSingleItem(errors, transformer, serializer, value);
    }
    
    @Override
    protected Object convertTestData(TestGroup.Entry<?,Object> loader, Params params, byte[] data)
            throws Exception
    {
        Object deserialized = loader.serializer.deserialize(data);
        return loader.transformer.reverse(deserialized);
    }

    // ------------------------------------------------------------------------------------
    // Test case objects
    // ------------------------------------------------------------------------------------
    
    protected final TestCase Create = new TestCase()
    {
            public <J> double run(Transformer<J,Object> transformer, Serializer<Object> serializer, J value, int iterations) throws Exception
            {
                    long start = System.nanoTime();
                    for (int i = 0; i < iterations; i++)
                    {
                            transformer.forward(value);
                    }
                    return iterationTime(System.nanoTime() - start, iterations);
            }
    };

    protected final TestCase Serialize = new TestCase()
    {
            public <J> double run(Transformer<J,Object> transformer, Serializer<Object> serializer, J value, int iterations) throws Exception
            {
                /* 16-Nov-2012, tatu: Time to serialize should consider time to
                 *   convert from POJO to intermediate representation, because
                 *   some format libs (Avro) do significant amount of pre-processing.
                 *   We could do this by adding Create time as well, but this should
                 *   model usual usage bit more accurately.
                 */
                Object[] objects = new Object[iterations];
                long start = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    Object input = transformer.forward(value);
                    objects[i] = serializer.serialize(input);
                }
                return iterationTime(System.nanoTime() - start, iterations);
            }
    };

    protected final TestCase Deserialize = new TestCase()
    {
            public <J> double run(Transformer<J,Object> transformer, Serializer<Object> serializer, J value, int iterations) throws Exception
            {
                    byte[] array = serializer.serialize(transformer.forward(value));
                    long start = System.nanoTime();
                    Object[] objects = new Object[iterations];
                    for (int i = 0; i < iterations; i++)
                    {
                        objects[i] = transformer.reverse(serializer.deserialize(array));
                    }
                    return iterationTime(System.nanoTime() - start, iterations);
            }
    };
}
