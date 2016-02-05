package serializers.cks.media;

public class Pod
{
	public final String message;
	public final cks.value.data.Maybe<Pod> pod;
	public Pod(String message, cks.value.data.Maybe<Pod> pod)
	{
		this.message = message;
		this.pod = pod;
	}
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append('{');
		b.append("Message = ");
		b.append(this.message.toString());
		b.append(", Pod = ");
		b.append(this.pod.toString());
		b.append('}');
		return b.toString();
	}
	public boolean equals(Object o) {
		return getClass().equals(o.getClass()) && equals((Pod) o);
	}
	public boolean equals(Pod o) {
		if (!this.message.equals(o.message)) return false;
		if (!this.pod.equals(o.pod)) return false;
		return true;
	}
	public int hashCode() {
		int h = 0;
		h ^= this.message.hashCode();
		h ^= this.pod.hashCode();
		return h;
	}
	public static final class _Builder
	{
		public String message;
		public _Builder setMessage(String value) { this.message = value; return this; }
		public cks.value.data.Maybe<Pod> pod = cks.value.data.Maybe.Nothing();
		public _Builder setPod(cks.value.data.Maybe<Pod> value) { this.pod = value; return this; }
		public boolean isInitialized()
		{
			if (message == null) return false;
			if (pod == null) return false;
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
			if (message == null) list.add("Message");
			if (pod == null) list.add("Pod");
		}
		public Pod build()
		{
			if (!isInitialized()) throw new RuntimeException("uninitialized fields: " + listUninitialized());
			return new Pod(message, pod);
		}
	}
	public static final cks.value.text.reader.TextReader<Pod> _TextReader = new cks.value.text.reader.TextReader<Pod>()
	{
		public Pod marshal(cks.value.text.reader.model.Value value)
			throws cks.common.model.ProblemException
		{
			cks.common.MInteger numFieldsUsed = new cks.common.MInteger(0);
			java.util.Map<String,cks.value.text.reader.model.VEntry> fields = cks.value.text.reader.TextReader.getFields(value);
			java.lang.String f1 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Message", cks.value.text.reader.TextReader.String);
			cks.value.data.Maybe<Pod> f2 = cks.value.text.reader.TextReader.getField(value, numFieldsUsed, fields, "Pod", Maybe.mk(Pod._TextReader));
			if (numFieldsUsed.value < fields.size()) cks.value.text.reader.TextReader.reportExtraFields(fields, new String[] {
				"Message",
				"Pod",
			});
			return new Pod(f1, f2);
		}
	};
	public static final cks.value.text.writer.TextWriter<Pod> _TextWriter = new cks.value.text.writer.TextWriter<Pod>()
	{
		public void write(java.io.Writer out, Pod value)
			throws java.io.IOException
		{
			out.write('{');
			out.write("Message = ");
			cks.value.text.writer.TextWriter.String.write(out, value.message);
			out.write(", Pod = ");
			Maybe.mk(Pod._TextWriter).write(out, value.pod);
			out.write('}');
		}
		public void writeIndented(cks.value.text.writer.IndentPrinter out, Pod value)
			throws java.io.IOException
		{
			out.println('{');
			out.indent();
			out.print("Message = ");cks.value.text.writer.TextWriter.String.writeIndented(out, value.message);
			out.print("Pod = ");
			Maybe.mk(Pod._TextWriter).writeIndented(out, value.pod);
			out.dedent();
			out.println('}');
		}
	};
	public static final cks.value.binary.reader.BinaryReader<Pod> _BinaryReader = new cks.value.binary.reader.BinaryReader<Pod>()
	{
		public Pod read(java.io.InputStream in)
			throws java.io.IOException, FormatException
		{
			return new Pod(
				  cks.value.binary.reader.BinaryReader.String.read(in)
				, Maybe.mk(Pod._BinaryReader).read(in)
				);
		}
	};
	public static final cks.value.binary.writer.BinaryWriter<Pod> _BinaryWriter = new cks.value.binary.writer.BinaryWriter<Pod>()
	{
		public void write(java.io.OutputStream out, Pod value)
			throws java.io.IOException
		{
			cks.value.binary.writer.BinaryWriter.String.write(out, value.message);
			Maybe.mk(Pod._BinaryWriter).write(out, value.pod);
		}
	};
}
