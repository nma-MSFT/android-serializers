package serializers.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.media.MediaContent;
import serializers.JavaBuiltIn;
import serializers.SerClass;
import serializers.SerFeatures;
import serializers.SerFormat;
import serializers.SerGraph;
import serializers.TestGroups;

/**
 * This serializer uses Jackson in full automated data binding mode, which
 * can handle typical Java POJOs (esp. beans; otherwise may need to annotate
 * to configure)
 */
public class JacksonJsonDatabind
{
    public static void register(TestGroups groups)
    {
        ObjectMapper mapper = new ObjectMapper();
        // note: could also force static typing; left out to keep defaults
        groups.media.add(JavaBuiltIn.mediaTransformer,
                new StdJacksonDataBind<MediaContent>("json/jackson/databind", MediaContent.class, mapper),
                new SerFeatures(
                        SerFormat.JSON,
                        SerGraph.FLAT_TREE,
                        SerClass.ZERO_KNOWLEDGE,
                        ""
                )
        );
    }
}
