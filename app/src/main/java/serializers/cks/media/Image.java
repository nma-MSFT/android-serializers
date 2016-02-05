package serializers.cks.media;

public class Image
{
	public final String uri;
	public final cks.value.data.Maybe<String> title;
	public final Integer width;
	public final Integer height;
	public final Size size;
	public Image(String uri, cks.value.data.Maybe<String> title, Integer width, Integer height, Size size)
	{
		this.uri = uri;
		this.title = title;
		this.width = width;
		this.height = height;
		this.size = size;
	}
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append('{');
		b.append("Uri = ");
		b.append(this.uri.toString());
		b.append(", Title = ");
		b.append(this.title.toString());
		b.append(", Width = ");
		b.append(this.width.toString());
		b.append(", Height = ");
		b.append(this.height.toString());
		b.append(", Size = ");
		b.append(this.size.toString());
		b.append('}');
		return b.toString();
	}
	public boolean equals(Object o) {
		return getClass().equals(o.getClass()) && equals((Image) o);
	}
	public boolean equals(Image o) {
		if (!this.uri.equals(o.uri)) return false;
		if (!this.title.equals(o.title)) return false;
		if (!this.width.equals(o.width)) return false;
		if (!this.height.equals(o.height)) return false;
		if (!this.size.equals(o.size)) return false;
		return true;
	}
	public int hashCode() {
		int h = 0;
		h ^= this.uri.hashCode();
		h ^= this.title.hashCode();
		h ^= this.width.hashCode();
		h ^= this.height.hashCode();
		h ^= this.size.hashCode();
		return h;
	}
	public static final class _Builder
	{
		public String uri;
		public _Builder setUri(String value) { this.uri = value; return this; }
		public cks.value.data.Maybe<String> title = cks.value.data.Maybe.Nothing();
		public _Builder setTitle(cks.value.data.Maybe<String> value) { this.title = value; return this; }
		public Integer width;
		public _Builder setWidth(Integer value) { this.width = value; return this; }
		public Integer height;
		public _Builder setHeight(Integer value) { this.height = value; return this; }
		public Size size;
		public _Builder setSize(Size value) { this.size = value; return this; }
		public boolean isInitialized()
		{
			if (uri == null) return false;
			if (title == null) return false;
			if (width == null) return false;
			if (height == null) return false;
			if (size == null) return false;
			return true;
		}
		public final java.util.ArrayList<String> listUninitialized()
		{
			java.util.ArrayList<String> l = new java.util.ArrayList<String>();
			listUninitialized(l);
			return l;
		}
		protected void listUninitialized(java.util.ArrayList<String> list)
		{
			if (uri == null) list.add("Uri");
			if (title == null) list.add("Title");
			if (width == null) list.add("Width");
			if (height == null) list.add("Height");
			if (size == null) list.add("Size");
		}
		public Image build()
		{
			if (!isInitialized()) throw new RuntimeException("uninitialized fields: " + listUninitialized());
			return new Image(uri, title, width, height, size);
		}
	}
	public static final cks.value.text.reader.TextReader<Image> _TextReader = new cks.value.text.reader.TextReader<Image>()
	{
		public Image marshal(cks.value.text.reader.model.Value value)
			throws cks.common.model.ProblemException
		{
			cks.common.MInteger numFieldsUsed = new cks.common.MInteger(0);
			java.util.Map<String,cks.value.text.reader.model.VEntry> fields = cks.value.text.reader.TextReader.getFields(value);
			java.lang.String f1 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Uri", cks.value.text.reader.TextReader.String);
			cks.value.data.Maybe<java.lang.String> f2 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Title", Maybe.mk(cks.value.text.reader.TextReader.String));
			Integer f3 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Width", cks.value.text.reader.TextReader.Int32);
			Integer f4 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Height", cks.value.text.reader.TextReader.Int32);
			Size f5 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Size", Size._TextReader);
			if (numFieldsUsed.value < fields.size()) cks.value.text.reader.TextReader.reportExtraFields(fields, new String[] {
				"Uri",
				"Title",
				"Width",
				"Height",
				"Size",
			});
			return new Image(f1, f2, f3, f4, f5);
		}
	};
	public static final cks.value.text.writer.TextWriter<Image> _TextWriter = new cks.value.text.writer.TextWriter<Image>()
	{
		public void write(java.io.Writer out, Image value)
			throws java.io.IOException
		{
			out.write('{');
			out.write("Uri = ");
			cks.value.text.writer.TextWriter.String.write(out, value.uri);
			out.write(", Title = ");
			Maybe.mk(cks.value.text.writer.TextWriter.String).write(out, value.title);
			out.write(", Width = ");
			cks.value.text.writer.TextWriter.Int32.write(out, value.width);
			out.write(", Height = ");
			cks.value.text.writer.TextWriter.Int32.write(out, value.height);
			out.write(", Size = ");
			Size._TextWriter.write(out, value.size);
			out.write('}');
		}
		public void writeIndented(cks.value.text.writer.IndentPrinter out, Image value)
			throws java.io.IOException
		{
			out.println('{');
			out.indent();
			out.print("Uri = ");cks.value.text.writer.TextWriter.String.writeIndented(out, value.uri);
			out.print("Title = ");
			Maybe.mk(cks.value.text.writer.TextWriter.String).writeIndented(out, value.title);
			out.print("Width = ");cks.value.text.writer.TextWriter.Int32.writeIndented(out, value.width);
			out.print("Height = ");cks.value.text.writer.TextWriter.Int32.writeIndented(out, value.height);
			out.print("Size = ");
			Size._TextWriter.writeIndented(out, value.size);
			out.dedent();
			out.println('}');
		}
	};
	public static final cks.value.binary.reader.BinaryReader<Image> _BinaryReader = new cks.value.binary.reader.BinaryReader<Image>()
	{
		public Image read(java.io.InputStream in)
			throws java.io.IOException, FormatException
		{
			return new Image(
				  cks.value.binary.reader.BinaryReader.String.read(in)
				, Maybe.mk(cks.value.binary.reader.BinaryReader.String).read(in)
				, cks.value.binary.reader.BinaryReader.Int32.read(in)
				, cks.value.binary.reader.BinaryReader.Int32.read(in)
				, Size._BinaryReader.read(in)
				);
		}
	};
	public static final cks.value.binary.writer.BinaryWriter<Image> _BinaryWriter = new cks.value.binary.writer.BinaryWriter<Image>()
	{
		public void write(java.io.OutputStream out, Image value)
			throws java.io.IOException
		{
			cks.value.binary.writer.BinaryWriter.String.write(out, value.uri);
			Maybe.mk(cks.value.binary.writer.BinaryWriter.String).write(out, value.title);
			cks.value.binary.writer.BinaryWriter.Int32.write(out, value.width);
			cks.value.binary.writer.BinaryWriter.Int32.write(out, value.height);
			Size._BinaryWriter.write(out, value.size);
		}
	};
	public static abstract class Size
	{
		public abstract String _name();
		public abstract int _index();
		public abstract void _writeBinary(java.io.OutputStream out) throws java.io.IOException;
		public abstract void _writeText(java.io.Writer out) throws java.io.IOException;
		public abstract void _writeTextIndented(cks.value.text.writer.IndentPrinter out) throws java.io.IOException;
		public static abstract class _BinaryReaderDelegate
		{
			public abstract  Size read(java.io.InputStream in) throws java.io.IOException, cks.value.binary.reader.BinaryReader.FormatException;
		}
		public static abstract class _TextReaderDelegate
		{
			public abstract  Size marshal(cks.value.text.reader.model.Value value) throws cks.common.model.ProblemException;
		}
		public static final class Small_ extends Size
		{
			private Small_() {}
			private static final Small_ Instance = new Small_();
			public static  Small_ mk()
			{
				@SuppressWarnings("unchecked")
				Small_ i = (Small_) Instance;
				return i;
			}
			public int hashCode() {
				return 0;
			}
			public String _name() { return "Small"; }
			public int _index() { return 0; }
			public void _writeBinary(java.io.OutputStream out) throws java.io.IOException {}
			public void _writeText(java.io.Writer out) throws java.io.IOException {}
			public final String toString() { return "Small"; }
			public void _writeTextIndented(cks.value.text.writer.IndentPrinter out) throws java.io.IOException { out.println(); }
		}
		public static final class Large_ extends Size
		{
			private Large_() {}
			private static final Large_ Instance = new Large_();
			public static  Large_ mk()
			{
				@SuppressWarnings("unchecked")
				Large_ i = (Large_) Instance;
				return i;
			}
			public int hashCode() {
				return 1;
			}
			public String _name() { return "Large"; }
			public int _index() { return 1; }
			public void _writeBinary(java.io.OutputStream out) throws java.io.IOException {}
			public void _writeText(java.io.Writer out) throws java.io.IOException {}
			public final String toString() { return "Large"; }
			public void _writeTextIndented(cks.value.text.writer.IndentPrinter out) throws java.io.IOException { out.println(); }
		}
		public static final _BinaryReaderDelegate[] _BinaryReaderDelegates = new _BinaryReaderDelegate[] 
		{
			new _BinaryReaderDelegate()
			{
				public  Size read(java.io.InputStream in) throws java.io.IOException, cks.value.binary.reader.BinaryReader.FormatException {
					return Small_.mk();
				}
			},
			new _BinaryReaderDelegate()
			{
				public  Size read(java.io.InputStream in) throws java.io.IOException, cks.value.binary.reader.BinaryReader.FormatException {
					return Large_.mk();
				}
			},
		};
		public static final java.util.Map<String,_TextReaderDelegate> _TextReaderDelegates = new java.util.HashMap<String,_TextReaderDelegate>();
		static {
			java.util.Map<String,_TextReaderDelegate> m = _TextReaderDelegates;
			m.put("Small", new _TextReaderDelegate()
			{
				public  Size marshal(cks.value.text.reader.model.Value value) throws cks.common.model.ProblemException {
					return Small_.mk();
				}
			});
			m.put("Large", new _TextReaderDelegate()
			{
				public  Size marshal(cks.value.text.reader.model.Value value) throws cks.common.model.ProblemException {
					return Large_.mk();
				}
			});
		};
		public static final cks.value.text.reader.TextReader<Size> _TextReader = new cks.value.text.reader.TextReader<Size>()
		{
			public Size marshal(cks.value.text.reader.model.Value value)
				throws cks.common.model.ProblemException
			{
				cks.value.text.reader.model.VEntry e = cks.value.text.reader.TextReader.getVariant(value);
				_TextReaderDelegate d = _TextReaderDelegates.get(e.name);
				if (d == null) throw cks.common.model.ProblemException.pex(e.loc, "variant type has no option named \"" + e.name + "\"");
				return d.marshal(e.value);
			}
		};
		public static final cks.value.text.writer.TextWriter<Size> _TextWriter = new cks.value.text.writer.TextWriter<Size>()
		{
			public void write(java.io.Writer out, Size value)
				throws java.io.IOException
			{
				out.write(value._name());
				value._writeText(out);
			}
			public void writeIndented(cks.value.text.writer.IndentPrinter out, Size value)
				throws java.io.IOException
			{
				out.write(value._name());
				value._writeTextIndented(out);
			}
		};
		public static final cks.value.binary.reader.BinaryReader<Size> _BinaryReader = new cks.value.binary.reader.BinaryReader<Size>()
		{
			public Size read(java.io.InputStream in)
				throws java.io.IOException, FormatException
			{
				int optionIndex = cks.value.binary.reader.BinaryReader.readOptionIndex1(in);
				if (optionIndex > 1) throw new FormatException("option index out of range: " + optionIndex);
				return _BinaryReaderDelegates[optionIndex].read(in);
			}
		};
		public static final cks.value.binary.writer.BinaryWriter<Size> _BinaryWriter = new cks.value.binary.writer.BinaryWriter<Size>()
		{
			public void write(java.io.OutputStream out, Size value)
				throws java.io.IOException
			{
				cks.value.binary.writer.BinaryWriter.writeOptionIndex1(out, value._index());
				value._writeBinary(out);
			}
		};
	}
}
