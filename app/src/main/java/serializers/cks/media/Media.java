package serializers.cks.media;

public class Media
{
	public final String uri;
	public final cks.value.data.Maybe<String> title;
	public final Integer width;
	public final Integer height;
	public final String format;
	public final Long duration;
	public final Long size;
	public final cks.value.data.Maybe<Integer> bitrate;
	public final java.util.List<String> persons;
	public final Player player;
	public final cks.value.data.Maybe<String> copyright;
	public final java.util.List<serializers.cks.media.Pod> pods;
	public Media(String uri, cks.value.data.Maybe<String> title, Integer width, Integer height, String format, Long duration, Long size, cks.value.data.Maybe<Integer> bitrate, java.util.List<String> persons, Player player, cks.value.data.Maybe<String> copyright, java.util.List<serializers.cks.media.Pod> pods)
	{
		this.uri = uri;
		this.title = title;
		this.width = width;
		this.height = height;
		this.format = format;
		this.duration = duration;
		this.size = size;
		this.bitrate = bitrate;
		this.persons = persons;
		this.player = player;
		this.copyright = copyright;
		this.pods = pods;
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
		b.append(", Format = ");
		b.append(this.format.toString());
		b.append(", Duration = ");
		b.append(this.duration.toString());
		b.append(", Size = ");
		b.append(this.size.toString());
		b.append(", Bitrate = ");
		b.append(this.bitrate.toString());
		b.append(", Persons = ");
		b.append(this.persons.toString());
		b.append(", Player = ");
		b.append(this.player.toString());
		b.append(", Copyright = ");
		b.append(this.copyright.toString());
		b.append(", Pods = ");
		b.append(this.pods.toString());
		b.append('}');
		return b.toString();
	}
	public boolean equals(Object o) {
		return getClass().equals(o.getClass()) && equals((Media) o);
	}
	public boolean equals(Media o) {
		if (!this.uri.equals(o.uri)) return false;
		if (!this.title.equals(o.title)) return false;
		if (!this.width.equals(o.width)) return false;
		if (!this.height.equals(o.height)) return false;
		if (!this.format.equals(o.format)) return false;
		if (!this.duration.equals(o.duration)) return false;
		if (!this.size.equals(o.size)) return false;
		if (!this.bitrate.equals(o.bitrate)) return false;
		if (!this.persons.equals(o.persons)) return false;
		if (!this.player.equals(o.player)) return false;
		if (!this.copyright.equals(o.copyright)) return false;
		if (!this.pods.equals(o.pods)) return false;
		return true;
	}
	public int hashCode() {
		int h = 0;
		h ^= this.uri.hashCode();
		h ^= this.title.hashCode();
		h ^= this.width.hashCode();
		h ^= this.height.hashCode();
		h ^= this.format.hashCode();
		h ^= this.duration.hashCode();
		h ^= this.size.hashCode();
		h ^= this.bitrate.hashCode();
		h ^= this.persons.hashCode();
		h ^= this.player.hashCode();
		h ^= this.copyright.hashCode();
		h ^= this.pods.hashCode();
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
		public String format;
		public _Builder setFormat(String value) { this.format = value; return this; }
		public Long duration;
		public _Builder setDuration(Long value) { this.duration = value; return this; }
		public Long size;
		public _Builder setSize(Long value) { this.size = value; return this; }
		public cks.value.data.Maybe<Integer> bitrate = cks.value.data.Maybe.Nothing();
		public _Builder setBitrate(cks.value.data.Maybe<Integer> value) { this.bitrate = value; return this; }
		public java.util.List<String> persons;
		public _Builder setPersons(java.util.List<String> value) { this.persons = value; return this; }
		public Player player;
		public _Builder setPlayer(Player value) { this.player = value; return this; }
		public cks.value.data.Maybe<String> copyright = cks.value.data.Maybe.Nothing();
		public _Builder setCopyright(cks.value.data.Maybe<String> value) { this.copyright = value; return this; }
		public java.util.List<serializers.cks.media.Pod> pods;
		public _Builder setPods(java.util.List<serializers.cks.media.Pod> value) { this.pods = value; return this; }
		public boolean isInitialized()
		{
			if (uri == null) return false;
			if (title == null) return false;
			if (width == null) return false;
			if (height == null) return false;
			if (format == null) return false;
			if (duration == null) return false;
			if (size == null) return false;
			if (bitrate == null) return false;
			if (persons == null) return false;
			if (player == null) return false;
			if (copyright == null) return false;
			if (pods == null) return false;
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
			if (format == null) list.add("Format");
			if (duration == null) list.add("Duration");
			if (size == null) list.add("Size");
			if (bitrate == null) list.add("Bitrate");
			if (persons == null) list.add("Persons");
			if (player == null) list.add("Player");
			if (copyright == null) list.add("Copyright");
			if (pods == null) list.add("Pods");
		}
		public Media build()
		{
			if (!isInitialized()) throw new RuntimeException("uninitialized fields: " + listUninitialized());
			return new Media(uri, title, width, height, format, duration, size, bitrate, persons, player, copyright, pods);
		}
	}
	public static final cks.value.text.reader.TextReader<Media> _TextReader = new cks.value.text.reader.TextReader<Media>()
	{
		public Media marshal(cks.value.text.reader.model.Value value)
			throws cks.common.model.ProblemException
		{
			cks.common.MInteger numFieldsUsed = new cks.common.MInteger(0);
			java.util.Map<String,cks.value.text.reader.model.VEntry> fields = cks.value.text.reader.TextReader.getFields(value);
			java.lang.String f1 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Uri", cks.value.text.reader.TextReader.String);
			cks.value.data.Maybe<java.lang.String> f2 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Title", Maybe.mk(cks.value.text.reader.TextReader.String));
			Integer f3 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Width", cks.value.text.reader.TextReader.Int32);
			Integer f4 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Height", cks.value.text.reader.TextReader.Int32);
			java.lang.String f5 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Format", cks.value.text.reader.TextReader.String);
			Long f6 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Duration", cks.value.text.reader.TextReader.Int64);
			Long f7 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Size", cks.value.text.reader.TextReader.Int64);
			cks.value.data.Maybe<Integer> f8 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Bitrate", Maybe.mk(cks.value.text.reader.TextReader.Int32));
			java.util.List<java.lang.String> f9 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Persons", List.mk(cks.value.text.reader.TextReader.String));
			Player f10 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Player", Player._TextReader);
			cks.value.data.Maybe<java.lang.String> f11 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Copyright", Maybe.mk(cks.value.text.reader.TextReader.String));
			java.util.List<serializers.cks.media.Pod> f12 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Pods", List.mk(serializers.cks.media.Pod._TextReader));
			if (numFieldsUsed.value < fields.size()) cks.value.text.reader.TextReader.reportExtraFields(fields, new String[] {
				"Uri",
				"Title",
				"Width",
				"Height",
				"Format",
				"Duration",
				"Size",
				"Bitrate",
				"Persons",
				"Player",
				"Copyright",
				"Pods",
			});
			return new Media(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12);
		}
	};
	public static final cks.value.text.writer.TextWriter<Media> _TextWriter = new cks.value.text.writer.TextWriter<Media>()
	{
		public void write(java.io.Writer out, Media value)
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
			out.write(", Format = ");
			cks.value.text.writer.TextWriter.String.write(out, value.format);
			out.write(", Duration = ");
			cks.value.text.writer.TextWriter.Int64.write(out, value.duration);
			out.write(", Size = ");
			cks.value.text.writer.TextWriter.Int64.write(out, value.size);
			out.write(", Bitrate = ");
			Maybe.mk(cks.value.text.writer.TextWriter.Int32).write(out, value.bitrate);
			out.write(", Persons = ");
			List.mk(cks.value.text.writer.TextWriter.String).write(out, value.persons);
			out.write(", Player = ");
			Player._TextWriter.write(out, value.player);
			out.write(", Copyright = ");
			Maybe.mk(cks.value.text.writer.TextWriter.String).write(out, value.copyright);
			out.write(", Pods = ");
			List.mk(serializers.cks.media.Pod._TextWriter).write(out, value.pods);
			out.write('}');
		}
		public void writeIndented(cks.value.text.writer.IndentPrinter out, Media value)
			throws java.io.IOException
		{
			out.println('{');
			out.indent();
			out.print("Uri = ");cks.value.text.writer.TextWriter.String.writeIndented(out, value.uri);
			out.print("Title = ");
			Maybe.mk(cks.value.text.writer.TextWriter.String).writeIndented(out, value.title);
			out.print("Width = ");cks.value.text.writer.TextWriter.Int32.writeIndented(out, value.width);
			out.print("Height = ");cks.value.text.writer.TextWriter.Int32.writeIndented(out, value.height);
			out.print("Format = ");cks.value.text.writer.TextWriter.String.writeIndented(out, value.format);
			out.print("Duration = ");cks.value.text.writer.TextWriter.Int64.writeIndented(out, value.duration);
			out.print("Size = ");cks.value.text.writer.TextWriter.Int64.writeIndented(out, value.size);
			out.print("Bitrate = ");
			Maybe.mk(cks.value.text.writer.TextWriter.Int32).writeIndented(out, value.bitrate);
			out.print("Persons = ");
			List.mk(cks.value.text.writer.TextWriter.String).writeIndented(out, value.persons);
			out.print("Player = ");
			Player._TextWriter.writeIndented(out, value.player);
			out.print("Copyright = ");
			Maybe.mk(cks.value.text.writer.TextWriter.String).writeIndented(out, value.copyright);
			out.print("Pods = ");
			List.mk(serializers.cks.media.Pod._TextWriter).writeIndented(out, value.pods);
			out.dedent();
			out.println('}');
		}
	};
	public static final cks.value.binary.reader.BinaryReader<Media> _BinaryReader = new cks.value.binary.reader.BinaryReader<Media>()
	{
		public Media read(java.io.InputStream in)
			throws java.io.IOException, FormatException
		{
			return new Media(
				  cks.value.binary.reader.BinaryReader.String.read(in)
				, Maybe.mk(cks.value.binary.reader.BinaryReader.String).read(in)
				, cks.value.binary.reader.BinaryReader.Int32.read(in)
				, cks.value.binary.reader.BinaryReader.Int32.read(in)
				, cks.value.binary.reader.BinaryReader.String.read(in)
				, cks.value.binary.reader.BinaryReader.Int64.read(in)
				, cks.value.binary.reader.BinaryReader.Int64.read(in)
				, Maybe.mk(cks.value.binary.reader.BinaryReader.Int32).read(in)
				, List.mk(cks.value.binary.reader.BinaryReader.String).read(in)
				, Player._BinaryReader.read(in)
				, Maybe.mk(cks.value.binary.reader.BinaryReader.String).read(in)
				, List.mk(serializers.cks.media.Pod._BinaryReader).read(in)
				);
		}
	};
	public static final cks.value.binary.writer.BinaryWriter<Media> _BinaryWriter = new cks.value.binary.writer.BinaryWriter<Media>()
	{
		public void write(java.io.OutputStream out, Media value)
			throws java.io.IOException
		{
			cks.value.binary.writer.BinaryWriter.String.write(out, value.uri);
			Maybe.mk(cks.value.binary.writer.BinaryWriter.String).write(out, value.title);
			cks.value.binary.writer.BinaryWriter.Int32.write(out, value.width);
			cks.value.binary.writer.BinaryWriter.Int32.write(out, value.height);
			cks.value.binary.writer.BinaryWriter.String.write(out, value.format);
			cks.value.binary.writer.BinaryWriter.Int64.write(out, value.duration);
			cks.value.binary.writer.BinaryWriter.Int64.write(out, value.size);
			Maybe.mk(cks.value.binary.writer.BinaryWriter.Int32).write(out, value.bitrate);
			List.mk(cks.value.binary.writer.BinaryWriter.String).write(out, value.persons);
			Player._BinaryWriter.write(out, value.player);
			Maybe.mk(cks.value.binary.writer.BinaryWriter.String).write(out, value.copyright);
			List.mk(serializers.cks.media.Pod._BinaryWriter).write(out, value.pods);
		}
	};
	public static abstract class Player
	{
		public abstract String _name();
		public abstract int _index();
		public abstract void _writeBinary(java.io.OutputStream out) throws java.io.IOException;
		public abstract void _writeText(java.io.Writer out) throws java.io.IOException;
		public abstract void _writeTextIndented(cks.value.text.writer.IndentPrinter out) throws java.io.IOException;
		public static abstract class _BinaryReaderDelegate
		{
			public abstract  Player read(java.io.InputStream in) throws java.io.IOException, cks.value.binary.reader.BinaryReader.FormatException;
		}
		public static abstract class _TextReaderDelegate
		{
			public abstract  Player marshal(cks.value.text.reader.model.Value value) throws cks.common.model.ProblemException;
		}
		public static final class Java_ extends Player
		{
			private Java_() {}
			private static final Java_ Instance = new Java_();
			public static  Java_ mk()
			{
				@SuppressWarnings("unchecked")
				Java_ i = (Java_) Instance;
				return i;
			}
			public int hashCode() {
				return 0;
			}
			public String _name() { return "Java"; }
			public int _index() { return 0; }
			public void _writeBinary(java.io.OutputStream out) throws java.io.IOException {}
			public void _writeText(java.io.Writer out) throws java.io.IOException {}
			public final String toString() { return "Java"; }
			public void _writeTextIndented(cks.value.text.writer.IndentPrinter out) throws java.io.IOException { out.println(); }
		}
		public static final class Flash_ extends Player
		{
			private Flash_() {}
			private static final Flash_ Instance = new Flash_();
			public static  Flash_ mk()
			{
				@SuppressWarnings("unchecked")
				Flash_ i = (Flash_) Instance;
				return i;
			}
			public int hashCode() {
				return 1;
			}
			public String _name() { return "Flash"; }
			public int _index() { return 1; }
			public void _writeBinary(java.io.OutputStream out) throws java.io.IOException {}
			public void _writeText(java.io.Writer out) throws java.io.IOException {}
			public final String toString() { return "Flash"; }
			public void _writeTextIndented(cks.value.text.writer.IndentPrinter out) throws java.io.IOException { out.println(); }
		}
		public static final _BinaryReaderDelegate[] _BinaryReaderDelegates = new _BinaryReaderDelegate[] 
		{
			new _BinaryReaderDelegate()
			{
				public  Player read(java.io.InputStream in) throws java.io.IOException, cks.value.binary.reader.BinaryReader.FormatException {
					return Java_.mk();
				}
			},
			new _BinaryReaderDelegate()
			{
				public  Player read(java.io.InputStream in) throws java.io.IOException, cks.value.binary.reader.BinaryReader.FormatException {
					return Flash_.mk();
				}
			},
		};
		public static final java.util.Map<String,_TextReaderDelegate> _TextReaderDelegates = new java.util.HashMap<String,_TextReaderDelegate>();
		static {
			java.util.Map<String,_TextReaderDelegate> m = _TextReaderDelegates;
			m.put("Java", new _TextReaderDelegate()
			{
				public  Player marshal(cks.value.text.reader.model.Value value) throws cks.common.model.ProblemException {
					return Java_.mk();
				}
			});
			m.put("Flash", new _TextReaderDelegate()
			{
				public  Player marshal(cks.value.text.reader.model.Value value) throws cks.common.model.ProblemException {
					return Flash_.mk();
				}
			});
		};
		public static final cks.value.text.reader.TextReader<Player> _TextReader = new cks.value.text.reader.TextReader<Player>()
		{
			public Player marshal(cks.value.text.reader.model.Value value)
				throws cks.common.model.ProblemException
			{
				cks.value.text.reader.model.VEntry e = cks.value.text.reader.TextReader.getVariant(value);
				_TextReaderDelegate d = _TextReaderDelegates.get(e.name);
				if (d == null) throw cks.common.model.ProblemException.pex(e.loc, "variant type has no option named \"" + e.name + "\"");
				return d.marshal(e.value);
			}
		};
		public static final cks.value.text.writer.TextWriter<Player> _TextWriter = new cks.value.text.writer.TextWriter<Player>()
		{
			public void write(java.io.Writer out, Player value)
				throws java.io.IOException
			{
				out.write(value._name());
				value._writeText(out);
			}
			public void writeIndented(cks.value.text.writer.IndentPrinter out, Player value)
				throws java.io.IOException
			{
				out.write(value._name());
				value._writeTextIndented(out);
			}
		};
		public static final cks.value.binary.reader.BinaryReader<Player> _BinaryReader = new cks.value.binary.reader.BinaryReader<Player>()
		{
			public Player read(java.io.InputStream in)
				throws java.io.IOException, FormatException
			{
				int optionIndex = cks.value.binary.reader.BinaryReader.readOptionIndex1(in);
				if (optionIndex > 1) throw new FormatException("option index out of range: " + optionIndex);
				return _BinaryReaderDelegates[optionIndex].read(in);
			}
		};
		public static final cks.value.binary.writer.BinaryWriter<Player> _BinaryWriter = new cks.value.binary.writer.BinaryWriter<Player>()
		{
			public void write(java.io.OutputStream out, Player value)
				throws java.io.IOException
			{
				cks.value.binary.writer.BinaryWriter.writeOptionIndex1(out, value._index());
				value._writeBinary(out);
			}
		};
	}
}
