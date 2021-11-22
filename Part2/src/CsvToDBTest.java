import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CsvToDBTest {

	static final String csv_files_path = "C:\\Users\\acer\\OneDrive\\Desktop\\cmps252_h4\\Files\\";

	String[] getArray(char C) throws Exception {
		String text = new String(Files.readAllBytes(Paths.get(csv_files_path + C + ".csv")), StandardCharsets.UTF_8);
		String[] arr = text.split("\n");
		return arr;
	}
	
	@Test
	void test1() throws Exception {
		String[] arr = getArray('A');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "A.csv");
		assertTrue(arr[0].contains(list.get(0).getCrn()));
	}
	
	@Test
	void test2() throws Exception {
		String[] arr = getArray('A');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "A.csv");
		assertTrue(arr[18].contains(list.get(18).getInstructor_first()));	}
	
	@Test
	void test3() throws Exception {
		String[] arr = getArray('A');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "A.csv");
		assertTrue(arr[105].contains(list.get(105).getInstructor_last()));	}
	
	@Test
	void test4() throws Exception {
		String[] arr = getArray('B');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "B.csv");
		assertTrue(arr[0].contains(list.get(0).getBldg())
				&& arr[0].contains(list.get(0).getRoom()));
	}
	
	@Test
	void test5() throws Exception {
		String[] arr = getArray('B');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "B.csv");
		assertTrue(arr[55].contains(list.get(55).getCollege())
				&& arr[55].contains(list.get(55).getSection()));
	}
	
	@Test
	void test6() throws Exception {
		String[] arr = getArray('B');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "B.csv");
		assertTrue(arr[101].contains(list.get(101).getTitle())
				&& arr[101].contains(list.get(101).getSubject()));
	}
	
	@Test
	void test7() throws Exception {
		String[] arr = getArray('C');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "C.csv");
		assertTrue(arr[0].contains(list.get(0).getInstructor_last()));
	}
	
	@Test
	void test8() throws Exception {
		String[] arr = getArray('C');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "C.csv");
		assertTrue(arr[11].contains(list.get(11).getRoom())
				&& arr[11].contains(list.get(11).getTitle()));
	}
	
	@Test
	void test9() throws Exception {
		String[] arr = getArray('C');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "C.csv");
		assertTrue(arr[5].contains(list.get(5).getSubject())
				&& arr[5].contains(list.get(5).getRoom()));
	}
	
	@Test
	void test10() throws Exception {
		String[] arr = getArray('D');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "D.csv");
		assertTrue(arr[7].contains(list.get(7).getCrn())
				&& arr[7].contains(list.get(7).getSubject()));
	}
	
	@Test
	void test11() throws Exception {
		String[] arr = getArray('D');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "D.csv");
		assertTrue(arr[12].contains(list.get(12).getTitle())
				&& arr[12].contains(list.get(12).getInstructor_first()));
	}
	
	@Test
	void test12() throws Exception {
		String[] arr = getArray('D');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "D.csv");
		assertTrue(arr[3].contains(list.get(3).getSubject())
				&& arr[3].contains(list.get(3).getRoom())
				&& arr[3].contains(list.get(3).getTitle()));
	}
	
	@Test
	void test13() throws Exception {
		String[] arr = getArray('E');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "E.csv");
		assertTrue(arr[0].contains(list.get(0).getCrn())
				&& arr[0].contains(list.get(0).getSubject()));
	}
	
	@Test
	void test14() throws Exception {
		String[] arr = getArray('E');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "E.csv");
		assertTrue(arr[3].contains(list.get(3).getBldg())
				&& arr[3].contains(list.get(3).getRoom()));
	}
	
	@Test
	void test15() throws Exception {
		String[] arr = getArray('E');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "E.csv");
		assertTrue(list.get(8).getWednesday()
				&& arr[8].contains(list.get(8).getInstructor_first())
				&& arr[8].contains(list.get(8).getInstructor_last()));
	}
	@Test
	void test16() throws Exception {
		String[] arr = getArray('F');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "F.csv");
		assertTrue(arr[0].contains(list.get(0).getSubject())
				&& arr[0].contains(list.get(0).getCrn()));
	}
	
	@Test
	void test17() throws Exception {
		String[] arr = getArray('F');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "F.csv");
		assertTrue(arr[6].contains(list.get(6).getSubject())
				&& arr[6].contains(list.get(6).getRoom()));
	}
	
	@Test
	void test18() throws Exception {
		String[] arr = getArray('F');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "F.csv");
		assertTrue(arr[13].contains(list.get(13).getTitle())
				&& arr[13].contains(list.get(13).getInstructor_last()));
	}
	
	@Test
	void test19() throws Exception {
		String[] arr = getArray('U');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "U.csv");
		assertTrue(arr[0].contains(list.get(0).getCrn())
				&& arr[0].contains(list.get(0).getSubject()));
	}
	
	@Test
	void test20() throws Exception {
		String[] arr = getArray('U');
		List<ICourse> list = new ArrayList<ICourse>();
		CsvToDB csvToDb = new CsvToDB();
		csvToDb.csvToDb(list, csv_files_path + "U.csv");
		assertTrue(arr[1].contains(list.get(1).getTitle())
				&& arr[1].contains(list.get(1).getBldg()));
	}


}
