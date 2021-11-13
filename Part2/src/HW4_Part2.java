import java.time.LocalDate;
import java.time.LocalTime;
import java.io.File;

public class HW4_Part2 {
	static final String base_url = "https://www-banner.aub.edu.lb/catalog/schd_";
	static final String files_path = "X:\\252\\cmps252_h4\\Html_Files\\";
	public static void main(String[] args) {
		//var t1 = LocalTime.parse("14:52");
		//var d = LocalDate.parse("1999-01-22");
		System.out.println("Hello");
		Downloader d = new Downloader();
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] arr = letters.toCharArray();
		for (char c : arr) {
			if (new File(files_path + c + ".html").exists()) continue;
			d.downloadHtmlToFile(base_url + c + ".htm", files_path + c + ".html");
		}
		System.out.println("Done");
	}
}