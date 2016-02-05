/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package serializers.thrift.media;

import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * Some comment...
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-02-05")
public class Image implements org.apache.thrift.TBase<Image, Image._Fields>, java.io.Serializable, Cloneable, Comparable<Image> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Image");

  private static final org.apache.thrift.protocol.TField URI_FIELD_DESC = new org.apache.thrift.protocol.TField("uri", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField WIDTH_FIELD_DESC = new org.apache.thrift.protocol.TField("width", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField HEIGHT_FIELD_DESC = new org.apache.thrift.protocol.TField("height", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("size", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ImageStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ImageTupleSchemeFactory());
  }

  private String uri; // required
  private String title; // optional
  private int width; // required
  private int height; // required
  private Size size; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    URI((short)1, "uri"),
    TITLE((short)2, "title"),
    WIDTH((short)3, "width"),
    HEIGHT((short)4, "height"),
    /**
     * 
     * @see Size
     */
    SIZE((short)5, "size");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // URI
          return URI;
        case 2: // TITLE
          return TITLE;
        case 3: // WIDTH
          return WIDTH;
        case 4: // HEIGHT
          return HEIGHT;
        case 5: // SIZE
          return SIZE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __WIDTH_ISSET_ID = 0;
  private static final int __HEIGHT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TITLE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.URI, new org.apache.thrift.meta_data.FieldMetaData("uri", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.WIDTH, new org.apache.thrift.meta_data.FieldMetaData("width", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    tmpMap.put(_Fields.HEIGHT, new org.apache.thrift.meta_data.FieldMetaData("height", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    tmpMap.put(_Fields.SIZE, new org.apache.thrift.meta_data.FieldMetaData("size", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, Size.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Image.class, metaDataMap);
  }

  public Image() {
  }

  public Image(
    String uri,
    int width,
    int height,
    Size size)
  {
    this();
    this.uri = uri;
    this.width = width;
    setWidthIsSet(true);
    this.height = height;
    setHeightIsSet(true);
    this.size = size;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Image(Image other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetUri()) {
      this.uri = other.uri;
    }
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    this.width = other.width;
    this.height = other.height;
    if (other.isSetSize()) {
      this.size = other.size;
    }
  }

  public Image deepCopy() {
    return new Image(this);
  }

  @Override
  public void clear() {
    this.uri = null;
    this.title = null;
    setWidthIsSet(false);
    this.width = 0;
    setHeightIsSet(false);
    this.height = 0;
    this.size = null;
  }

  public String getUri() {
    return this.uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public void unsetUri() {
    this.uri = null;
  }

  /** Returns true if field uri is set (has been assigned a value) and false otherwise */
  public boolean isSetUri() {
    return this.uri != null;
  }

  public void setUriIsSet(boolean value) {
    if (!value) {
      this.uri = null;
    }
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void unsetTitle() {
    this.title = null;
  }

  /** Returns true if field title is set (has been assigned a value) and false otherwise */
  public boolean isSetTitle() {
    return this.title != null;
  }

  public void setTitleIsSet(boolean value) {
    if (!value) {
      this.title = null;
    }
  }

  public int getWidth() {
    return this.width;
  }

  public void setWidth(int width) {
    this.width = width;
    setWidthIsSet(true);
  }

  public void unsetWidth() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __WIDTH_ISSET_ID);
  }

  /** Returns true if field width is set (has been assigned a value) and false otherwise */
  public boolean isSetWidth() {
    return EncodingUtils.testBit(__isset_bitfield, __WIDTH_ISSET_ID);
  }

  public void setWidthIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __WIDTH_ISSET_ID, value);
  }

  public int getHeight() {
    return this.height;
  }

  public void setHeight(int height) {
    this.height = height;
    setHeightIsSet(true);
  }

  public void unsetHeight() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __HEIGHT_ISSET_ID);
  }

  /** Returns true if field height is set (has been assigned a value) and false otherwise */
  public boolean isSetHeight() {
    return EncodingUtils.testBit(__isset_bitfield, __HEIGHT_ISSET_ID);
  }

  public void setHeightIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __HEIGHT_ISSET_ID, value);
  }

  /**
   * 
   * @see Size
   */
  public Size getSize() {
    return this.size;
  }

  /**
   * 
   * @see Size
   */
  public void setSize(Size size) {
    this.size = size;
  }

  public void unsetSize() {
    this.size = null;
  }

  /** Returns true if field size is set (has been assigned a value) and false otherwise */
  public boolean isSetSize() {
    return this.size != null;
  }

  public void setSizeIsSet(boolean value) {
    if (!value) {
      this.size = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case URI:
      if (value == null) {
        unsetUri();
      } else {
        setUri((String)value);
      }
      break;

    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((String)value);
      }
      break;

    case WIDTH:
      if (value == null) {
        unsetWidth();
      } else {
        setWidth((Integer)value);
      }
      break;

    case HEIGHT:
      if (value == null) {
        unsetHeight();
      } else {
        setHeight((Integer)value);
      }
      break;

    case SIZE:
      if (value == null) {
        unsetSize();
      } else {
        setSize((Size)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case URI:
      return getUri();

    case TITLE:
      return getTitle();

    case WIDTH:
      return getWidth();

    case HEIGHT:
      return getHeight();

    case SIZE:
      return getSize();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case URI:
      return isSetUri();
    case TITLE:
      return isSetTitle();
    case WIDTH:
      return isSetWidth();
    case HEIGHT:
      return isSetHeight();
    case SIZE:
      return isSetSize();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Image)
      return this.equals((Image)that);
    return false;
  }

  public boolean equals(Image that) {
    if (that == null)
      return false;

    boolean this_present_uri = true && this.isSetUri();
    boolean that_present_uri = true && that.isSetUri();
    if (this_present_uri || that_present_uri) {
      if (!(this_present_uri && that_present_uri))
        return false;
      if (!this.uri.equals(that.uri))
        return false;
    }

    boolean this_present_title = true && this.isSetTitle();
    boolean that_present_title = true && that.isSetTitle();
    if (this_present_title || that_present_title) {
      if (!(this_present_title && that_present_title))
        return false;
      if (!this.title.equals(that.title))
        return false;
    }

    boolean this_present_width = true;
    boolean that_present_width = true;
    if (this_present_width || that_present_width) {
      if (!(this_present_width && that_present_width))
        return false;
      if (this.width != that.width)
        return false;
    }

    boolean this_present_height = true;
    boolean that_present_height = true;
    if (this_present_height || that_present_height) {
      if (!(this_present_height && that_present_height))
        return false;
      if (this.height != that.height)
        return false;
    }

    boolean this_present_size = true && this.isSetSize();
    boolean that_present_size = true && that.isSetSize();
    if (this_present_size || that_present_size) {
      if (!(this_present_size && that_present_size))
        return false;
      if (!this.size.equals(that.size))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_uri = true && (isSetUri());
    list.add(present_uri);
    if (present_uri)
      list.add(uri);

    boolean present_title = true && (isSetTitle());
    list.add(present_title);
    if (present_title)
      list.add(title);

    boolean present_width = true;
    list.add(present_width);
    if (present_width)
      list.add(width);

    boolean present_height = true;
    list.add(present_height);
    if (present_height)
      list.add(height);

    boolean present_size = true && (isSetSize());
    list.add(present_size);
    if (present_size)
      list.add(size.getValue());

    return list.hashCode();
  }

  @Override
  public int compareTo(Image other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetUri()).compareTo(other.isSetUri());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUri()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uri, other.uri);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTitle()).compareTo(other.isSetTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.title, other.title);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWidth()).compareTo(other.isSetWidth());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWidth()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.width, other.width);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHeight()).compareTo(other.isSetHeight());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHeight()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.height, other.height);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSize()).compareTo(other.isSetSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.size, other.size);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Image(");
    boolean first = true;

    sb.append("uri:");
    if (this.uri == null) {
      sb.append("null");
    } else {
      sb.append(this.uri);
    }
    first = false;
    if (isSetTitle()) {
      if (!first) sb.append(", ");
      sb.append("title:");
      if (this.title == null) {
        sb.append("null");
      } else {
        sb.append(this.title);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("width:");
    sb.append(this.width);
    first = false;
    if (!first) sb.append(", ");
    sb.append("height:");
    sb.append(this.height);
    first = false;
    if (!first) sb.append(", ");
    sb.append("size:");
    if (this.size == null) {
      sb.append("null");
    } else {
      sb.append(this.size);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    if (!isSetWidth()) {
      throw new TProtocolException("Required field 'width' is unset! Struct:" + toString());
    }

    if (!isSetHeight()) {
      throw new TProtocolException("Required field 'height' is unset! Struct:" + toString());
    }

    if (!isSetSize()) {
      throw new TProtocolException("Required field 'size' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ImageStandardSchemeFactory implements SchemeFactory {
    public ImageStandardScheme getScheme() {
      return new ImageStandardScheme();
    }
  }

  private static class ImageStandardScheme extends StandardScheme<Image> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Image struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // URI
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.uri = iprot.readString();
              struct.setUriIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TITLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.title = iprot.readString();
              struct.setTitleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // WIDTH
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.width = iprot.readI32();
              struct.setWidthIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // HEIGHT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.height = iprot.readI32();
              struct.setHeightIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.size = serializers.thrift.media.Size.findByValue(iprot.readI32());
              struct.setSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Image struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.uri != null) {
        oprot.writeFieldBegin(URI_FIELD_DESC);
        oprot.writeString(struct.uri);
        oprot.writeFieldEnd();
      }
      if (struct.title != null) {
        if (struct.isSetTitle()) {
          oprot.writeFieldBegin(TITLE_FIELD_DESC);
          oprot.writeString(struct.title);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldBegin(WIDTH_FIELD_DESC);
      oprot.writeI32(struct.width);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(HEIGHT_FIELD_DESC);
      oprot.writeI32(struct.height);
      oprot.writeFieldEnd();
      if (struct.size != null) {
        oprot.writeFieldBegin(SIZE_FIELD_DESC);
        oprot.writeI32(struct.size.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ImageTupleSchemeFactory implements SchemeFactory {
    public ImageTupleScheme getScheme() {
      return new ImageTupleScheme();
    }
  }

  private static class ImageTupleScheme extends TupleScheme<Image> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Image struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.width);
      oprot.writeI32(struct.height);
      oprot.writeI32(struct.size.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetUri()) {
        optionals.set(0);
      }
      if (struct.isSetTitle()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetUri()) {
        oprot.writeString(struct.uri);
      }
      if (struct.isSetTitle()) {
        oprot.writeString(struct.title);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Image struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.width = iprot.readI32();
      struct.setWidthIsSet(true);
      struct.height = iprot.readI32();
      struct.setHeightIsSet(true);
      struct.size = serializers.thrift.media.Size.findByValue(iprot.readI32());
      struct.setSizeIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.uri = iprot.readString();
        struct.setUriIsSet(true);
      }
      if (incoming.get(1)) {
        struct.title = iprot.readString();
        struct.setTitleIsSet(true);
      }
    }
  }

}

