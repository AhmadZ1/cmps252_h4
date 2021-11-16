import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class HtmlToCsv implements IHtmlToCsv {
	@Override
	public void htmlToCsv(String htmlFile, String csvFile) throws Exception {
		File f = new File(csvFile);
		if (f.exists()) f.delete();
		String html = Files.readString(Path.of(htmlFile));
		int indexOfFall = html.indexOf("Fall");
		if (indexOfFall < 0) return;
		html = html.substring(indexOfFall);
		html = html.substring(0, html.indexOf("</TABLE>"));
		PrintStream output = new PrintStream(new File(csvFile));
		String[] lines = html.split("</TR>");
		for (String line : lines) {
			String[] row = line.split("</TD>");
			String str = "";
			for (String s : row) {
				str += s.trim().replaceAll("<TD>", "").replaceAll("\n", "") + ",";
			}
			if (str.trim().equals("\n") || str.isBlank() || row.length < 35) continue;
			output.println(str);
		}
		
	}
}
