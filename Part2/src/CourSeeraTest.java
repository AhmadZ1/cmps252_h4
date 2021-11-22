import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CourSeeraTest {

	ICourSeeraFactory courseeraFactory = new CourSeeraFactory();
	static CsvToDB csvToDB = new CsvToDB();
	static List<ICourse> courses = new ArrayList<ICourse>();
	ICourSeera courseera = courseeraFactory.createInstance(courses);
	static String path = "C:\\Users\\acer\\OneDrive\\Desktop\\Test\\";

	@BeforeAll
	static void getCourses()  {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] arr = alphabet.toCharArray();
		for (char c : arr) {
			try {
				csvToDB.csvToDb(courses, getCsvPath(c));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getCsvPath(char c) {
		return path + c + ".csv";
	}
	
	@Test
	void test1() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205")).get(0).getFromTime().toString(), "08:00");
	}
	
	@Test
	void test2() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205")).get(0).getToTime().toString(), "08:50");
	}
	
	@Test
	void test3() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205")).get(0).getInstructor().toString(), "Mahmoud Bdeir");
	}

	@Test
	void test4() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205")).get(0).getDay(), DayOfWeek.Monday);
	}
	
	@Test
	void test5() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205")).get(0).getCourse().getCrn(), "10941");
	}
	
	@Test
	void test6() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205")).get(0).getCourse().getCourse_num(), "252");
	}
	
	@Test
	void test7() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205")).get(1).getCourse().getSubject(), "CMPS");
	}
	
	@Test
	void test8() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205")).get(2).getCourse().getSubject(), "MATH");
	}
	
	@Test
	void test9() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205")).get(2).getInstructor().toString(), "Nabil Nassif");
	}
	
	@Test
	void test10() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "105")).get(8).getInstructor().toString(), "Amer Abdo Mouawad");
	}
	
	@Test
	void test11() {
		assertEquals(courseera.roomSchedule(new Room("NICELY", "214")).get(0).getCourse().getSubject(), "ENGL");
	}
	
	@Test
	void test12() {
		assertEquals(courseera.roomSchedule(new Room("NICELY", "212")).get(1).getInstructor().toString(), "Izzat El Hajj");
	}
	
	@Test
	void test13() {
		assertEquals(courseera.roomSchedule(new Room("NICELY", "212")).get(0).getFromTime().toString(), "08:00");
	}
	
	@Test
	void test14() {
		assertEquals(courseera.roomSchedule(new Room("NICELY", "212")).get(3).getCourse().getCourse_num(), "200");
	}
	
	@Test
	void test15() {
		assertEquals(courseera.profSchedule(new Instructor("Haidar", "Safa")).get(0).getFromTime(), LocalTime.parse("09:30"));
	}
	
	@Test
	void test16() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205"), DayOfWeek.Wednesday).get(2).getInstructor().toString(), "Nabil Nassif");
	}
	
	@Test
	void test17() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205"), DayOfWeek.Thursday).get(1).getInstructor().toString(), "Fatima Abu Salem");
	}
	
	@Test
	void test18() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205"), DayOfWeek.Thursday).get(3).getCourse().getSubject(), "MATH");
	}
	
	@Test
	void test19() {
		assertEquals(courseera.roomSchedule(new Room("BLISS", "205"), DayOfWeek.Thursday).get(2).getCourse().getSubject(), "PHIL");
	}
	
	@Test
	void test20() {
		assertEquals(courseera.roomSchedule(new Room("WEST", "BATHISH")).get(0).getCourse().getSubject(), "ECON");
	}
}
