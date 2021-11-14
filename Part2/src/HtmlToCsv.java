import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class HtmlToCsv implements IHtmlToCsv {
	@Override
	public void htmlToCsv(String htmlFile, String csvFile) throws Exception {
		if (new File(csvFile).exists()) return;
		String html = Files.readString(Path.of(htmlFile));
		int length = html.length();
		int indexOfFall = html.indexOf("Fall");
		PrintStream output = new PrintStream(new File(csvFile));
		if (indexOfFall < 0) return;
		String curr = "";
		for (int i = indexOfFall; i < length; ++i) {
			if (html.charAt(i) == ' ') continue;
			if (html.charAt(i) == '>') {
				if (curr.equals("/TR")) output.println();
				curr = "";
			}
			else if (html.charAt(i) == '<') {
				curr = curr.replaceFirst("\n", "");
				if (!curr.isEmpty() && !curr.equals("\n")) output.print(curr + ",");
				curr = "";
			}
			else curr += html.charAt(i);
		}
	}
}
