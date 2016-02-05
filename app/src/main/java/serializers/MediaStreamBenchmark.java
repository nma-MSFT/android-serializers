package serializers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import serializers.jackson.JacksonJsonDatabind;
import serializers.jackson.JacksonJsonManual;
import serializers.protobuf.Protobuf;

/**
 * Alternative benchmark which uses a sequence of data items for testing,
 * instead of a single item that main test uses.
 */
public class MediaStreamBenchmark extends BenchmarkBase
{
    private void runBenchmark(InputStream testFile, int fileLength, String[] args) throws IOException {
        runBenchmark(args,
                testFile,
                fileLength,
                Create,
                Serialize, 
                Deserialize);
    }
    
    @Override
    protected void addTests(TestGroups groups)
    {        
        // Binary Formats; language-specific ones

        // Binary formats, generic: protobuf, thrift, avro, CKS, msgpack
        Protobuf.register(groups);
        Thrift.register(groups);

        // JSON
        JacksonJsonManual.register(groups);
        JacksonJsonDatabind.register(groups);
        //JacksonWithAfterburner.registerJSON(groups); // databind with bytecode generation (faster)

    }

    @Override
    protected Object convertTestData(TestGroup.Entry<?,Object> loader, Params params, byte[] data)
        throws Exception
    {
        String extra = params.dataExtra;
        int count = 0;
        try {
            count = Integer.parseInt(extra);
        } catch (Exception e) {
            throw new IllegalArgumentException("Non-integer extra part ('"+extra+"') of data file: must be count");
        }
        Object[] deserialized = loader.serializer.deserializeItems(new ByteArrayInputStream(data), count);
        return loader.transformer.reverseAll(deserialized);
    }

    @Override
    protected <J> byte[] serializeForSize(Transformer<J,Object> transformer, Serializer<Object> serializer, J value)
        throws Exception
    {
        @SuppressWarnings("unchecked")
        Object[] result = transformer.forwardAll((J[]) value);
        return serializer.serializeAsBytes(result);
    }
    
    @Override
    protected <J> void checkCorrectness(PrintWriter errors, Transformer<J,Object> transformer,
            Serializer<Object> serializer, J input)
        throws Exception
    {
        // nasty cast, but works (and has to be used) here:
        @SuppressWarnings("unchecked")
        J[] items = (J[]) input;
        for (J item : items) {
            checkSingleItem(errors, transformer, serializer, item);
        }
    }

    // ------------------------------------------------------------------------------------
    // Test case objects
    // ------------------------------------------------------------------------------------
    
    protected final TestCase Create = new TestCase()
    {
        public <J> double run(Transformer<J,Object> transformer, Serializer<Object> serializer, J value, int iterations) throws Exception
        {
            @SuppressWarnings("unchecked")
            J[] src = (J[]) value;
            Object[] result = new Object[src.length];
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                transformer.forward(src, result);
            }
            return iterationTime(System.nanoTime() - start, iterations);
        }
    };

    protected final TestCase Serialize = new TestCase()
    {
        public <J> double run(Transformer<J,Object> transformer, Serializer<Object> serializer, J value, int iterations) throws Exception
        {
            @SuppressWarnings("unchecked")
            J[] src = (J[]) value;
            Object[][] objects = new Object[iterations][];
            for (int i = 0; i < iterations; i++) {
            	objects[i] = transformer.forwardAll(src);
            }
            ByteArrayOutputStream out = serializer.outputStreamForList(src);
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                serializer.serializeItems(objects[i], out);
                out.reset();
            }
            return iterationTime(System.nanoTime() - start, iterations);
        }
    };

    protected final TestCase Deserialize = new TestCase()
    {
        public <J> double run(Transformer<J,Object> transformer, Serializer<Object> serializer, J value, int iterations) throws Exception
        {
            @SuppressWarnings("unchecked")
            J[] src = (J[]) value;
            byte[] bytes = serializer.serializeAsBytes(transformer.forwardAll(src));
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                serializer.deserializeItems(new ByteArrayInputStream(bytes), src.length);
            }
            return iterationTime(System.nanoTime() - start, iterations);
        }
    };
}
