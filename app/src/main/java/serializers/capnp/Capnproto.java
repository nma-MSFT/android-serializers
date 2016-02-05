package serializers.capnp;

import org.capnproto.MessageBuilder;
import org.capnproto.MessageReader;
import org.capnproto.Serialize;
import org.capnproto.SerializePacked;
import org.capnproto.StructList;
import org.capnproto.Text;
import org.capnproto.TextList;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import data.media.MediaTransformer;
import serializers.SerClass;
import serializers.SerFeatures;
import serializers.SerFormat;
import serializers.SerGraph;
import serializers.Serializer;
import serializers.TestGroups;
import serializers.capnp.media.MediaContentHolder;

/**
 * @author nickma
 * @version 1.0
 * @since 02/02/16
 */
public class Capnproto {
    public static void register(TestGroups groups) {
        groups.media.add(new Transformer(), new PBSerializer(),
                new SerFeatures(
                        SerFormat.BIN_CROSSLANG,
                        SerGraph.FLAT_TREE,
                        SerClass.MANUAL_OPT,
                        ""
                ));
    }

    static final class PBSerializer extends Serializer<MediaContentHolder.MediaContent.Reader>
    {
        public String getName() { return "capnp"; }

        @Override
        public MediaContentHolder.MediaContent.Reader deserialize (final byte[] array) throws Exception {
            final ByteBuffer byteBuffer = ByteBuffer.wrap(array);

            MessageReader message =  SerializePacked.readFromUnbuffered(new ReadableByteChannel() {
                @Override
                public int read(ByteBuffer dst) throws IOException {
                    dst.put(byteBuffer);
                    return array.length;
                }

                @Override
                public boolean isOpen() {
                    return false;
                }

                @Override
                public void close() throws IOException {

                }
            });
            return message.getRoot(MediaContentHolder.MediaContent.factory);
        }

        @Override
        public byte[] serialize(MediaContentHolder.MediaContent.Reader content) throws IOException {
            MessageBuilder message = new MessageBuilder();

            MediaContentHolder.MediaContent.Builder mediaContent = message.initRoot(MediaContentHolder.MediaContent.factory);
            mediaContent.setImage(content.getImage());
            mediaContent.setMedia(content.getMedia());

            final ByteBuffer byteBuffer = makeByteBuffer((int) Serialize.computeSerializedSizeInWords(message) * 8);
            SerializePacked.writeToUnbuffered(new WritableByteChannel() {
                @Override
                public int write(ByteBuffer src) throws IOException {
                    byteBuffer.put(src);
                    return 0;
                }

                @Override
                public boolean isOpen() {
                    return false;
                }

                @Override
                public void close() throws IOException {

                }
            }, message);
            return byteBuffer.array();
        }

        static ByteBuffer makeByteBuffer(int bytes) {
            ByteBuffer result = ByteBuffer.allocate(bytes);
            result.order(ByteOrder.LITTLE_ENDIAN);
            result.mark();
            return result;
        }

        @Override
        public final void serializeItems(MediaContentHolder.MediaContent.Reader[] items, OutputStream out0) throws IOException
        {
            DataOutputStream out = new DataOutputStream(out0);
            for (MediaContentHolder.MediaContent.Reader mc : items) {
                byte[] data = serialize(mc);
                out.writeInt(data.length);
                out.write(data);
            }

            // should we write end marker (length of 0) or not? For now, omit it
            out.flush();
        }

        @Override
        public MediaContentHolder.MediaContent.Reader[] deserializeItems(InputStream in0, int numberOfItems) throws Exception
        {
            DataInputStream in = new DataInputStream(in0);
            MediaContentHolder.MediaContent.Reader[] result = new  MediaContentHolder.MediaContent.Reader[numberOfItems];
            for (int i = 0; i < numberOfItems; ++i) {
                int len = in.readInt();
                byte[] data = new byte[len];
                in.readFully(data);
                result[i] = deserialize(data);
            }
            return result;
        }
    }

    public static final class Transformer extends MediaTransformer<MediaContentHolder.MediaContent.Reader> {

        @Override
        public MediaContentHolder.MediaContent.Reader forward( data.media.MediaContent mediaContent) {
            MessageBuilder message = new MessageBuilder();
            MediaContentHolder.MediaContent.Builder mediaContentBuilder = message.initRoot(MediaContentHolder.MediaContent.factory);


            MediaContentHolder.Media.Builder mediaBuilder = mediaContentBuilder.initMedia();
            forwardMedia(mediaContent.getMedia(), mediaBuilder);

            StructList.Builder<MediaContentHolder.Image.Builder> images = mediaContentBuilder.initImage(mediaContent.getImages().size());
            for (int i = 0; i < mediaContent.getImages().size(); i++) {
                MediaContentHolder.Image.Builder imageBuilder = images.get(i);
                forwardImage(mediaContent.getImages().get(i), imageBuilder);
            }

            MediaContentHolder.MediaContent.Reader reader = mediaContentBuilder.asReader();
            return reader;
        }

        private void forwardImage( data.media.Image image, MediaContentHolder.Image.Builder imageBuilder) {

            imageBuilder.setHeight(image.getHeight());
            imageBuilder.setWidth(image.getWidth());
            imageBuilder.setSize(forwardSize(image.getSize()));
            if (image.getTitle() != null) {
                imageBuilder.setTitle(image.getTitle());
            }
            if (image.getUri() != null) {
                imageBuilder.setUri(image.getUri());
            }

        }

        private void forwardMedia( data.media.Media media, MediaContentHolder.Media.Builder mediaBuilder) {

            TextList.Builder personBuilder = mediaBuilder.initPerson(media.getPersons().size());
            for (int i = 0; i < media.getPersons().size(); i++) {
                personBuilder.set(i, new Text.Reader(media.getPersons().get(i)));
            }

            StructList.Builder<MediaContentHolder.Pod.Builder> podListBuilder = mediaBuilder.initPods(media.getPods().size());
            for (int i = 0; i < media.getPods().size(); i ++) {
                MediaContentHolder.Pod.Builder podBuilder = podListBuilder.get(i);
                forwardPod(media.getPods().get(i), podBuilder);
            }

            mediaBuilder.setBitrate(media.getBitrate());
            mediaBuilder.setDuration(media.getDuration());
            if (media.getFormat() != null) {
                mediaBuilder.setFormat(media.getFormat());
            }

            mediaBuilder.setHeight(media.getHeight());
            mediaBuilder.setWidth(media.getWidth());
            mediaBuilder.setSize(media.getSize());
            if (media.getCopyright() != null) {
                mediaBuilder.setCopyright(media.getCopyright());
            }

            mediaBuilder.setPlayer(forwardPlayer(media.getPlayer()));

            if (media.getTitle() != null) {
                mediaBuilder.setTitle(media.getTitle());
            }

            if (media.getUri() != null) {
                mediaBuilder.setUri(media.getUri());
            }
        }

        private void forwardPod( data.media.Pod pod,  MediaContentHolder.Pod.Builder podBuilder) {
            data.media.Pod innerPod = pod.getPod();
            if (innerPod != null) {
                MediaContentHolder.Pod.Builder innerBuilder = podBuilder.initPod();
                forwardPod(innerPod, innerBuilder);
                podBuilder.setPod(innerBuilder.asReader());
            }
            podBuilder.setMessage(new Text.Reader(pod.getMessage()));
        }

        @Override
        public  data.media.MediaContent reverse(MediaContentHolder.MediaContent.Reader mc) {
            ArrayList<data.media.Image> imageList = new ArrayList<>();
            for (MediaContentHolder.Image.Reader reader : mc.getImage()) {
                imageList.add(reverseImage(reader));
            }

            return new data.media.MediaContent(
                    reverseMedia(mc.getMedia()),
                    imageList
            );
        }

        @Override
        public data.media.MediaContent shallowReverse(MediaContentHolder.MediaContent.Reader mc)
        {
            return new data.media.MediaContent(reverseMedia(mc.getMedia()), Collections.<data.media.Image>emptyList());
        }

        private data.media.Media reverseMedia(MediaContentHolder.Media.Reader media)
        {

            ArrayList<String> personsList = new ArrayList<>();
            Iterator<Text.Reader> personIt = media.getPerson().iterator();

            while (personIt.hasNext()) {
                personsList.add(personIt.next().toString());
            }

            ArrayList<data.media.Pod> podsList = new ArrayList<>();
            Iterator<MediaContentHolder.Pod.Reader> podIt = media.getPods().iterator();

            while (podIt.hasNext()) {
                podsList.add(reversePod(podIt.next()));
            }

            // Media
            return new data.media.Media(
                    media.hasUri()? media.getUri().toString() : null,
                    media.hasTitle() ? media.getTitle().toString() : null,
                    media.getWidth(),
                    media.getHeight(),
                    media.hasFormat()? media.getFormat().toString() : null,
                    media.getDuration(),
                    media.getSize(),
                    media.getBitrate(),
                    media.getBitrate() > 1 ? true:false,
                    personsList,
                    reversePlayer(media.getPlayer()),
                    media.hasCopyright() ? media.getCopyright().toString() : null,
                    podsList
            );
        }

        private data.media.Pod reversePod(MediaContentHolder.Pod.Reader pod) {

            return new data.media.Pod(
                    pod.getMessage().toString(),
                    pod.hasPod()  ? reversePod(pod.getPod()) : null
            );
        }

        public MediaContentHolder.Player forwardPlayer(data.media.Media.Player p)
        {
            switch (p) {
                case JAVA: return MediaContentHolder.Player.JAVA;
                case FLASH: return MediaContentHolder.Player.FLASH;
                default:
                    throw new AssertionError("invalid case: " + p);
            }
        }


        public MediaContentHolder.Size forwardSize(data.media.Image.Size s)
        {
            switch (s) {
                case SMALL: return MediaContentHolder.Size.SMALL;
                case LARGE: return MediaContentHolder.Size.LARGE;
                default:
                    throw new AssertionError("invalid case: " + s);
            }
        }

        public data.media.Media.Player reversePlayer(MediaContentHolder.Player p)
        {
            switch (p) {
                case JAVA:  return data.media.Media.Player.JAVA;
                case FLASH: return data.media.Media.Player.FLASH;
                default:
                    throw new AssertionError("invalid case: " + p);
            }
        }

        private data.media.Image reverseImage(MediaContentHolder.Image.Reader image)
        {
            return new data.media.Image(
                    image.hasUri() ? image.getUri().toString() : null,
                    image.hasTitle() ? image.getTitle().toString() : null,
                    image.getWidth(),
                    image.getHeight(),
                    reverseSize(image.getSize()));
        }

        public data.media.Image.Size reverseSize(MediaContentHolder.Size s)
        {
            switch (s) {
                case SMALL: return data.media.Image.Size.SMALL;
                case LARGE: return data.media.Image.Size.LARGE;
                default:
                    throw new AssertionError("invalid case: " + s);
            }
        }

        @Override
        public MediaContentHolder.MediaContent.Reader[] resultArray(int size) {
            return new MediaContentHolder.MediaContent.Reader[size];
        }
    }
}
