import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;


public class Coursera {
	// base url of the page to be downloaded
	static final String base_url = "https://www-banner.aub.edu.lb/catalog/schd_";
	// path of the html and csv files, please change it to work on your machine
	static final String path = "C:\\Users\\acer\\OneDrive\\Desktop\\cmps252_h4\\Files\\";
	static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static char[] arr = alphabet.toCharArray();
	static ICourSeeraFactory courseeraFactory = new CourSeeraFactory();
	static Downloader downloader = new Downloader();
	static HtmlToCsv htmlToCsv = new HtmlToCsv();
	static CsvToDB csvToDB = new CsvToDB();
	static List<ICourse> courses = new ArrayList<ICourse>();
	static ICourSeera courseera = courseeraFactory.createInstance(courses);
	static TreeMap<IRoom, List<ISchedule>> roomMap;
	public static void main(String[] args) throws IOException  {
		processData();
		roomMap = courseera.roomSchedule();
		if (args.length == 0) {
			printModeMessage();
			return;
		}
		String command = args[0];
		if (command.equals("-help")) {
			printCommandLineHelpMessage();
			return;
		}
		if (command.equals("-interactive")) {
			runInteractiveApp();
			return;
		}
		String name = args[1].toUpperCase();
		String[] arr = name.split(" ");
		switch (command) {
		case "-room-schedule":
			roomSchedule(new Room(arr[0], arr[1]));
			break;
		case "-room-schedule-on-date":
			String date = args[2];
			roomSchedule(new Room(arr[0], arr[1]), LocalDate.parse(date));
			break;
		case "-room-schedule-on-day":
			String day = args[2].toUpperCase();
			roomSchedule(new Room(arr[0], arr[1]), getDay(day));
			break;
		case "-who-was-there-last":
			whoWasThereLast(new Room(arr[0], arr[1]));
			break;
		case "-who-is-there-now":
			whoIsThereNow(new Room(arr[0], arr[1]));
			break;
		case "-prof-schedule":
			profSchedule(new Instructor(arr[0], arr[1]));
			break;
		case "-where-is-prof":
			whereIsProf(new Instructor(arr[0], arr[1]));
			break;
		case "-where-will-prof-be":
			whereWillProfBe(new Instructor(arr[0], arr[1]));
			break;
		case "-update":
			update();
			break;
		default:
			printCommandLineHelpMessage();
			break;
		}
		
	}
	
	/***
	 * {@summary} runs an interactive app with the user
	 * @throws IOException
	 */
	public static void runInteractiveApp() throws IOException {
		Scanner input = new Scanner(System.in);
		while (true) {
			printInteractiveAppMessage();
			String choice = input.nextLine();
			switch (choice) {
			case "1":
				System.out.print("Enter the room building: ");
				String bldg = input.nextLine().toUpperCase();
				System.out.print("Enter the room number: ");
				String number = input.nextLine().toUpperCase();
				roomSchedule(new Room(bldg, number));
				break;
			case "2":
				System.out.print("Enter the room building: ");
				bldg = input.nextLine().toUpperCase();
				System.out.print("Enter the room number: ");
				number = input.nextLine().toUpperCase();
				System.out.print("Enter the date (yyyy-mm-dd): ");
				String date = input.nextLine();
				roomSchedule(new Room(bldg, number), LocalDate.parse(date));
				break;
			case "3":
				System.out.print("Enter the room building: ");
				bldg = input.nextLine().toUpperCase();
				System.out.print("Enter the room number: ");
				number = input.nextLine().toUpperCase();
				System.out.print("Enter the day: ");
				String day = input.nextLine().toUpperCase();
				roomSchedule(new Room(bldg, number), getDay(day));
				break;
			case "4":
				System.out.print("Enter the room building: ");
				bldg = input.nextLine().toUpperCase();
				System.out.print("Enter the room number: ");
				number = input.nextLine().toUpperCase();
				whoWasThereLast(new Room(bldg, number));
				break;
			case "5":
				System.out.print("Enter the room building: ");
				bldg = input.nextLine().toUpperCase();
				System.out.print("Enter the room number: ");
				number = input.nextLine().toUpperCase();
				whoIsThereNow(new Room(bldg, number));
				break;
			case "6":
				System.out.println("Enter instructor's first name: ");
				String firstName = input.nextLine();
				System.out.println("Enter instructor's last name: ");
				String lastName = input.nextLine();
				profSchedule(new Instructor(firstName, lastName));
				break;
			case "7":
				System.out.println("Enter instructor's first name: ");
				firstName = input.nextLine();
				System.out.println("Enter instructor's last name: ");
				lastName = input.nextLine();
				whereIsProf(new Instructor(firstName, lastName));
				break;
			case "8":
				System.out.println("Enter instructor's first name: ");
				firstName = input.nextLine();
				System.out.println("Enter instructor's last name: ");
				lastName = input.nextLine();
				whereWillProfBe(new Instructor(firstName, lastName));
				break;
			case "9":
				update();
				break;
			case "10":
				System.out.println("Have a good day!");
				return;
			default:
				System.out.println("Please enter a number between 1 and 10.");
				break;
			}
		}
	}
	
	/***
	 * {@summary} prints the schedule of the instructor today
	 * @param instructor the instructor to print their schedule
	 */
	public static void whereWillProfBe(IInstructor instructor) {
		List<ISchedule> list = courseera.whereWillProfBe(instructor);
		if (list.isEmpty()) {
			System.out.println(instructor + " has no classes to give today!");
			return;
		}
		for (ISchedule sched : list) {
			System.out.println(sched);
		}
	}
	
	/***
	 * {@summary} prints where is the professor currently (if any)
	 * @param instructor the instructor to print where they are
	 */
	public static void whereIsProf(IInstructor instructor) {
		ISchedule schedule = courseera.whereIsProf(instructor);
		if (schedule == null) {
			System.out.println("It seems like " + instructor + " is giving no classes right now!");
			return;
		}
		System.out.println(schedule);
	}
	
	/***
	 * {@summary} prints the weekly schedule of the instructor
	 * @param instructor the instructor to prints their weekly schedule
	 */
	public static void profSchedule(IInstructor instructor) {
		List<ISchedule> list = courseera.profSchedule(instructor);
		if (list.isEmpty()) {
			System.out.println(instructor + " does not exist");
			return;
		}
		DayOfWeek day = list.get(0).getDay();
		System.out.println(day);
		for (ISchedule sched : list) {
			if (sched.getDay() != day) {
				day = sched.getDay();
				System.out.println(day);
			}
			System.out.println(sched);
		}
	}
	
	/***
	 * {@summary} prints who is now at the given room
	 * @param room the room to check who is in it now
	 */
	public static void whoIsThereNow(IRoom room) {
		ISchedule schedule = courseera.whoIsThereNow(room);
		if (schedule == null) {
			System.out.println("It seems like there is nobody at " + room + " currently!");
			return;
		}
		System.out.println(schedule);
	}
	
	/***
	 * {@summary} prints who was at the room last
	 * @param room the room to check who was at it last
	 */
	public static void whoWasThereLast(IRoom room) {
		ISchedule schedule = courseera.whoWasThereLast(room);
		System.out.println(schedule);
	}
	
	/***
	 * {@summary} prints the schedule of the room at the given day
	 * @param room the room to print its schedule
	 * @param day the day to print the classes that are held at it
	 */
	public static void roomSchedule(IRoom room, DayOfWeek day) {
		List<ISchedule> list = courseera.roomSchedule(room, day);
		if (list.isEmpty()) {
			System.out.println("No classes are given in " + room + " on " + day);
		}
		System.out.println(day);
		for (ISchedule sched : list) {
			System.out.println(sched);
		}
	}
	
	/***
	 * {@summary} prints the schedule of the room at the given date
	 * @param room the room to print its schedule
	 * @param date the date to print classes that happened/are happening on it
	 */
	public static void roomSchedule(IRoom room, LocalDate date) {
		List<ISchedule> list = courseera.roomSchedule(room, date);
		if (list.isEmpty()) {
			System.out.println("No classes are given in " + room + " on " + date);
			return;
		}
		System.out.println(date);
		for (ISchedule sched : list) {
			System.out.println(sched);
		}
	}
	
	/***
	 * {@summary} prints the schedule of the room
	 * @param room the room to print its schedule
	 * @param courseera the courseera instance to get the room schedule
	 */
	public static void roomSchedule(IRoom room) {
		List<ISchedule> list = courseera.roomSchedule(room);
		if (list.size() == 0) {
			System.out.println("No classes are given in " + room);
			return;
		}
		DayOfWeek day = list.get(0).getDay();
		System.out.println(day);
		for (ISchedule sched : list) {
			if (sched.getDay() != day) {
				day = sched.getDay();
				System.out.println(day);
			}
			System.out.println(sched);
		}
	}
	
	/***
	 * {@summary} to be printed when the user doesn't use any of the supported commands
	 */
	public static void printModeMessage() {
		System.out.println("Please type \"java Coursera -help\" to get help to use commad line arguments.\n"
				+ "Or type \"java Coursera -interactive\" to use the interactive console app.");
	}
	
	/***
	 * {@summary} to be printed when the user needs help or enters a wrong command
	 */
	public static void printCommandLineHelpMessage() {
		System.out.println("Please use:\n1. \"java Coursera -room-schedule \"room-name\"\": to print the schedule of the room.\n"
				+ "2. \"java Coursera -room-schedule-on-date \"room-name\" \"date\"\": to print the schedule of the room at the given date.\n"
				+ "3. \"java Coursera -room-schedule-day \"room-name\" \"day\"\": to print the shcedule of the room at the given day.\n"
				+ "4. \"java Coursera -who-was-there-last \"room-name\"\": to print the schedule of the last class that had been held at the room.\n"
				+ "5. \"java Coursera -who-is-there-now \"room-name\"\": to print the schedule of the class that is being held at the room at the current moment (if any).\n"
				+ "6. \"java Coursera -prof-schedule \"professor-name\"\": to print the weekly schedule of the professor.\n"
				+ "7. \"java Coursera -where-is-prof \"professor-name\"\": to print where is the professor currently teaching (if any).\n"
				+ "8. \"java Coursera -where-will-prof-be \"professor-name\"\": to print the professor's schedule for today.\n"
				+ "9. \"java Coursera -update\": to update the files and courses in the database.");
	}
	
	/***
	 * {@summary} the message to be printed for the user to make choices in the interactive app
	 */
	public static void printInteractiveAppMessage() {
		System.out.println("Please choose:\n1. Print room's schedule.\n"
				+ "2. Print room's schedule at a certain date.\n"
				+ "3. Print room's schedule at a certain day.\n"
				+ "4. Print room's last class.\n"
				+ "5. Print room's current class (if any).\n"
				+ "6. Print instructor's weekly schedule.\n"
				+ "7. Print where is the instructor currently teaching (if any).\n"
				+ "8. Print instructor's today's schedule.\n"
				+ "9. Update the courses in the database.\n"
				+ "10. Exit.");
	}
	
	/***
	 * {@summary} updates the courses in the database
	 * @throws IOException
	 */
	public static void update() throws IOException {
		System.out.println("Updating...");
		downloadData();
		courses =  new ArrayList<ICourse>();
		processData();
		courseera = courseeraFactory.createInstance(courses);
		System.out.println("Database updated successfully.");
	}
	
	/***
	 * {@summary} downloads the html pages and parses them into csv files
	 * @param downloader a Downloader instance to download html pages
	 * @param htmlToCsv an HtmlToCsv instance to parse the html pages into csv files
	 * @throws IOException
	 */
	public static void downloadData() throws IOException {
		for (char c : arr) {
			downloader.downloadHtmlToFile(getUrl(c), getHtmlPath(c));
			htmlToCsv.htmlToCsv(getHtmlPath(c), getCsvPath(c));
		}
	}
	
	/***
	 * {@summary} puts the courses from csv files into the list of courses (database)
	 * @param csvToDB CsvToDB instance to parse the courses from csv into the list of courses
	 * @param courses the list of courses to add to it (database)
	 * @throws IOException
	 */
	public static void processData() throws IOException {
		for (char c : arr) {
			csvToDB.csvToDb(courses, getCsvPath(c));
		}
	}
	
	/***
	 * {@summary} gets the url of dynamic schedule page for the given letter
	 * @param c the letter of the dynamic schedule page
	 * @return the url of the dynamic schedule page of the given letter
	 */
	public static String getUrl(char c) {
		return base_url + c + ".htm";
	}
	
	/***
	 * {@summary} gets the path of the html file whose name is the given character
	 * @param c the name of the html file
	 * @return the path to that file
	 */
	public static String getHtmlPath(char c) {
		return path + c + ".html";
	}
	
	/***
	 * {@summary} gets the path of the csv file whose name is the given character
	 * @param c the name of the csv file
	 * @return the path to that file
	 */
	public static String getCsvPath(char c) {
		return path + c + ".csv";
	}
	
	/***
	 * {@summary} transforms a string representing a day into a DayOfWeek enum
	 * @param day the day to convert to enum as a string
	 * @return DayOfWeek enum corresponding for the given day
	 */
	private static DayOfWeek getDay(String day) {
		switch (day) {
		case "MONDAY": return DayOfWeek.Monday;
		case "TUESDAY": return DayOfWeek.Tuesday;
		case "WEDNESDAY": return DayOfWeek.Wednesday;
		case "THURSDAY": return DayOfWeek.Thursday;
		case "FRIDAY": return DayOfWeek.Friday;
		case "SATURDAY": return DayOfWeek.Saturday;
		default: return DayOfWeek.Sunday;
		}
	}
}