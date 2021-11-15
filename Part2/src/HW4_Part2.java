import java.util.List;
import java.util.ArrayList;

public class HW4_Part2 {
	static final String base_url = "https://www-banner.aub.edu.lb/catalog/schd_";
	static final String html_files_path = "C:\\Users\\acer\\OneDrive\\Desktop\\Test\\";
	static final String csv_files_path = "C:\\Users\\acer\\OneDrive\\Desktop\\Test\\";
	static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) throws Exception {
		System.out.println("Hello");
		char[] arr = alphabet.toCharArray();
		Downloader d = new Downloader();
		HtmlToCsv htmlToCsv = new HtmlToCsv();
		CsvToDB csvToDB = new CsvToDB();
		List<ICourse> courses = new ArrayList<ICourse>();
		System.out.println("Before for");
		for (char c : arr) {
			System.out.println(c);
			d.downloadHtmlToFile(getUrl(c), getHtmlFilePath(c));
			htmlToCsv.htmlToCsv(getHtmlFilePath(c), getCsvFilePath(c));
			csvToDB.csvToDb(courses, getCsvFilePath(c));
		}
		System.out.println(courses.size());
		System.out.println("Done");
	}
	
	public static String getHtmlFilePath(char c) {
		return html_files_path + c + ".txt";
	}
	
	public static String getCsvFilePath(char c) {
		return csv_files_path + c + ".csv";
	}
	
	public static String getUrl(char c) {
		return base_url + c + ".htm";
	}
	
}