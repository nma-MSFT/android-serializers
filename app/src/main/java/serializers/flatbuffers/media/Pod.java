// automatically generated, do not modify

package serializers.flatbuffers.media;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Pod extends Table {
  public static Pod getRootAsPod(ByteBuffer _bb) { return getRootAsPod(_bb, new Pod()); }
  public static Pod getRootAsPod(ByteBuffer _bb, Pod obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public Pod __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public String message() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer messageAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public Pod pod() { return pod(new Pod()); }
  public Pod pod(Pod obj) { int o = __offset(6); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }

  public static int createPod(FlatBufferBuilder builder,
      int message,
      int pod) {
    builder.startObject(2);
    Pod.addPod(builder, pod);
    Pod.addMessage(builder, message);
    return Pod.endPod(builder);
  }

  public static void startPod(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addMessage(FlatBufferBuilder builder, int messageOffset) { builder.addOffset(0, messageOffset, 0); }
  public static void addPod(FlatBufferBuilder builder, int podOffset) { builder.addOffset(1, podOffset, 0); }
  public static int endPod(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

