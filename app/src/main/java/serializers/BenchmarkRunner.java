package serializers;

import serializers.cks.CksText;
import serializers.flatbuffers.Flatbuffers;
import serializers.jackson.JacksonJsonDatabind;
import serializers.jackson.JacksonJsonManual;
import serializers.protobuf.Protobuf;

/**
 * Full test of various codecs, using a single <code>MediaItem</code>
 * as test data.
 */
public class BenchmarkRunner extends MediaItemBenchmark
{
    protected void addTests(TestGroups groups)
    {

        // Binary formats, generic: protobuf, thrift, avro, CKS, msgpack, CBOR
        Protobuf.register(groups);
        Thrift.register(groups);
        Flatbuffers.register(groups);
        //Capnproto.register(groups);

        // JSON
        JacksonJsonManual.register(groups);
        JacksonJsonDatabind.register(groups);


        //JacksonJrDatabind.register(groups);
        // 01-Oct-2014, tatu: not 100% sure this is still needed, but left just in case
//        JacksonJsonTree.register(groups);
        //JavaxJsonTreeGlassfish.register(groups);
        //JavaxJsonStreamGlassfish.register(groups);
        //JsonTwoLattes.register(groups);
        //ProtostuffJson.register(groups);

        //ProtobufJson.register(groups);
        //JsonGsonManual.register(groups);
        //JsonGsonTree.register(groups);
        //JsonGsonDatabind.register(groups);
        //JsonSvensonDatabind.register(groups);
        //FlexjsonDatabind.register(groups);

        ///JsonLibJsonDatabind.register(groups);
        //FastJSONDatabind.register(groups);
        //JsonSimpleWithContentHandler.register(groups);
//        JsonSimpleManualTree.register(groups);
        //JsonSmartManualTree.register(groups);
        //JsonDotOrgManualTree.register(groups);
        //JsonijJpath.register(groups);
// JsonijManualTree.register(groups);
        //JsonArgoTree.register(groups);
// 06-May-2013, tatu: Too slow (100x above fastest)
// JsonPathDeserializerOnly.register(groups);

        // Then JSON-like
        // CKS text is textual JSON-like format
        CksText.register(groups);
        // then binary variants
        // Smile is 1-to-1 binary JSON serialization
        //JacksonSmileManual.register(groups);
        //JacksonSmileDatabind.register(groups);

	// 06-May-2013, tatu: Unfortunately there is a version conflict
        //    here too -- commenting out, to let David fix it
//        ProtostuffSmile.register(groups);
        // BSON is JSON-like format with extended datatypes
        //JacksonBsonDatabind.register(groups);
        //MongoDB.register(groups);

        // YAML (using Jackson module built on SnakeYAML)
        //JacksonYAMLDatabind.register(groups);

        // XML-based formats; first textual XML
        //XmlStax.register(groups, true, true, false); // woodstox/aalto/-
        //XmlXStream.register(groups);
        //JacksonXmlDatabind.register(groups);
        //XmlJavolution.register(groups);

        // Then binary XML; Fast Infoset, EXI
        //XmlStax.register(groups, false, false, true); // -/-/fast-infoset
        //ExiExificient.register(groups);

        // Other things...

        // Jackson databind with Afterburner; add-on module that uses bytecode gen for speed
        //JacksonWithAfterburner.registerAll(groups);
        
        // Jackson's column-oriented variants for formats that usually use key/value notation
        //JacksonWithColumnsDatabind.registerAll(groups);

	    //DSLPlatform.register(groups);
    }
}
