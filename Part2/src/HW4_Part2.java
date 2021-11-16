import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class HW4_Part2 {
	static final String base_url = "https://www-banner.aub.edu.lb/catalog/schd_";
	static final String html_files_path = "X:\\cmps252_h4\\Html_Files\\";
	static final String csv_files_path = "X:\\cmps252_h4\\Csv_Files\\";
	static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) throws Exception {
		System.out.println("Initialsing...");
		// initializng the "database"
		char[] arr = alphabet.toCharArray();
		//Downloader d = new Downloader();
		//HtmlToCsv htmlToCsv = new HtmlToCsv();
		CsvToDB csvToDB = new CsvToDB();
		List<ICourse> courses = new ArrayList<ICourse>();
		System.out.println("Before for");
		for (char c : arr) {
			System.out.println(c);
			//d.downloadHtmlToFile(getUrl(c), getHtmlFilePath(c));
			//htmlToCsv.htmlToCsv(getHtmlFilePath(c), getCsvFilePath(c));
			csvToDB.csvToDb(courses, getCsvFilePath(c));
		}
		System.out.println("Done initialising");
		//for (var course : courses) {
		//	ISchedule s = new Schedule(course);
		//	if (s.getCourse().equals("CMPS 252")) {
		//		System.out.println(s);
		//	}
		//}
		System.out.println(courses.size());
		ICourSeeraFactory courseeraFactory = new CourSeeraFactory();
		ICourSeera courseera = courseeraFactory.createInstance(courses);
		List<ISchedule> lst = courseera.roomSchedule(new Room("BLISS", "205"), LocalDate.parse("2021-11-16"));
		System.out.println(lst);
		ISchedule last = courseera.whoIsThereNow(new Room("BLISS", "205"));
		System.out.println(last);
		System.out.println(LocalTime.now());
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