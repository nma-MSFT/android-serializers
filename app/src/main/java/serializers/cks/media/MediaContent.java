package serializers.cks.media;

public class MediaContent
{
	public final java.util.List<Image> images;
	public final Media media;
	public MediaContent(java.util.List<Image> images, Media media)
	{
		this.images = images;
		this.media = media;
	}
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append('{');
		b.append("Images = ");
		b.append(this.images.toString());
		b.append(", Media = ");
		b.append(this.media.toString());
		b.append('}');
		return b.toString();
	}
	public boolean equals(Object o) {
		return getClass().equals(o.getClass()) && equals((MediaContent) o);
	}
	public boolean equals(MediaContent o) {
		if (!this.images.equals(o.images)) return false;
		if (!this.media.equals(o.media)) return false;
		return true;
	}
	public int hashCode() {
		int h = 0;
		h ^= this.images.hashCode();
		h ^= this.media.hashCode();
		return h;
	}
	public static final class _Builder
	{
		public java.util.List<Image> images;
		public _Builder setImages(java.util.List<Image> value) { this.images = value; return this; }
		public Media media;
		public _Builder setMedia(Media value) { this.media = value; return this; }
		public boolean isInitialized()
		{
			if (images == null) return false;
			if (media == null) return false;
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
			if (images == null) list.add("Images");
			if (media == null) list.add("Media");
		}
		public MediaContent build()
		{
			if (!isInitialized()) throw new RuntimeException("uninitialized fields: " + listUninitialized());
			return new MediaContent(images, media);
		}
	}
	public static final cks.value.text.reader.TextReader<MediaContent> _TextReader = new cks.value.text.reader.TextReader<MediaContent>()
	{
		public MediaContent marshal(cks.value.text.reader.model.Value value)
			throws cks.common.model.ProblemException
		{
			cks.common.MInteger numFieldsUsed = new cks.common.MInteger(0);
			java.util.Map<String,cks.value.text.reader.model.VEntry> fields = cks.value.text.reader.TextReader.getFields(value);
			java.util.List<Image> f1 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Images", List.mk(Image._TextReader));
			Media f2 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Media", Media._TextReader);
			if (numFieldsUsed.value < fields.size()) cks.value.text.reader.TextReader.reportExtraFields(fields, new String[] {
				"Images",
				"Media",
			});
			return new MediaContent(f1, f2);
		}
	};
	public static final cks.value.text.writer.TextWriter<MediaContent> _TextWriter = new cks.value.text.writer.TextWriter<MediaContent>()
	{
		public void write(java.io.Writer out, MediaContent value)
			throws java.io.IOException
		{
			out.write('{');
			out.write("Images = ");
			List.mk(Image._TextWriter).write(out, value.images);
			out.write(", Media = ");
			Media._TextWriter.write(out, value.media);
			out.write('}');
		}
		public void writeIndented(cks.value.text.writer.IndentPrinter out, MediaContent value)
			throws java.io.IOException
		{
			out.println('{');
			out.indent();
			out.print("Images = ");
			List.mk(Image._TextWriter).writeIndented(out, value.images);
			out.print("Media = ");
			Media._TextWriter.writeIndented(out, value.media);
			out.dedent();
			out.println('}');
		}
	};
	public static final cks.value.binary.reader.BinaryReader<MediaContent> _BinaryReader = new cks.value.binary.reader.BinaryReader<MediaContent>()
	{
		public MediaContent read(java.io.InputStream in)
			throws java.io.IOException, FormatException
		{
			return new MediaContent(
				  List.mk(Image._BinaryReader).read(in)
				, Media._BinaryReader.read(in)
				);
		}
	};
	public static final cks.value.binary.writer.BinaryWriter<MediaContent> _BinaryWriter = new cks.value.binary.writer.BinaryWriter<MediaContent>()
	{
		public void write(java.io.OutputStream out, MediaContent value)
			throws java.io.IOException
		{
			List.mk(Image._BinaryWriter).write(out, value.images);
			Media._BinaryWriter.write(out, value.media);
		}
	};
}
