import static org.junit.jupiter.api.Assertions.*;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class HtmlToCsvTest {
	static final String csv_files_path = "C:\\Users\\acer\\OneDrive\\Desktop\\cmps252_h4\\Files\\";

	String[] getArray(char C) throws Exception {
		String text = new String(Files.readAllBytes(Paths.get(csv_files_path + C + ".csv")), StandardCharsets.UTF_8);
		String[] arr = text.split("\n");
		return arr;
	}
	
	@Test
	void test1() throws Exception {
		String[] arr = getArray('A');
		assertTrue(arr[0].contains("Fall 2021-2022(202210)"));
	}
	
	@Test
	void test2() throws Exception {
		String[] arr = getArray('A');
		assertTrue(arr[9].contains("Sana")
				&& arr[9].contains("El Hajj"));
	}
	
	@Test
	void test3() throws Exception {
		String[] arr = getArray('A');
		assertTrue(arr[18].contains("OSB")
				&& arr[18].contains("230"));
	}
	
	@Test
	void test4() throws Exception {
		String[] arr = getArray('B');
		assertTrue(arr[0].contains("Biochemistry for Nursing"));
	}
	
	@Test
	void test5() throws Exception {
		String[] arr = getArray('B');
		assertTrue(arr[1].contains("Biochemistry Research Seminar")
				&& arr[1].contains("305A"));
	}
	
	@Test
	void test6() throws Exception {
		String[] arr = getArray('B');
		assertTrue(arr[9].contains("10220")
				&& arr[9].contains("FM"));
	}
	
	@Test
	void test7() throws Exception {
		String[] arr = getArray('C');
		assertTrue(arr[2].contains("STAFF"));
	}
	
	@Test
	void test8() throws Exception {
		String[] arr = getArray('C');
		assertTrue(arr[3].contains("0900")
				&& arr[3].contains("0950"));
	}
	
	@Test
	void test9() throws Exception {
		String[] arr = getArray('C');
		assertTrue(arr[5].contains("CHEM")
				&& arr[5].contains("101")
				&& arr[5].contains("E6"));
	}
	
	@Test
	void test10() throws Exception {
		String[] arr = getArray('D');
		assertTrue(arr[7].contains("11046")
				&& arr[7].contains("DCSN"));
	}
	
	@Test
	void test11() throws Exception {
		String[] arr = getArray('D');
		assertTrue(arr[15].contains("Operations Management")
				&& arr[15].contains("Ibrahim"));
	}
	
	@Test
	void test12() throws Exception {
		String[] arr = getArray('D');
		assertTrue(arr[27].contains("DGRG")
				&& arr[27].contains("240")
				&& arr[27].contains("Clinical Practicum III"));
	}
	
	@Test
	void test13() throws Exception {
		String[] arr = getArray('E');
		assertTrue(arr[0].contains("11052")
				&& arr[0].contains("ECON"));
	}
	
	@Test
	void test14() throws Exception {
		String[] arr = getArray('E');
		assertTrue(arr[3].contains("WEST")
				&& arr[3].contains("BATHISH"));
	}
	
	@Test
	void test15() throws Exception {
		String[] arr = getArray('E');
		assertTrue(arr[8].contains("W")
				&& arr[8].contains("Malak")
				&& arr[8].contains("Makki"));
	}
	@Test
	void test16() throws Exception {
		String[] arr = getArray('F');
		assertTrue(arr[0].contains("FEAA")
				&& arr[0].contains("11663"));
	}
	
	@Test
	void test17() throws Exception {
		String[] arr = getArray('F');
		assertTrue(arr[6].contains("MAMC")
				&& arr[6].contains("ELH"));
	}
	
	@Test
	void test18() throws Exception {
		String[] arr = getArray('F');
		assertTrue(arr[13].contains("Intr.to Engineer.& Architectu.")
				&& arr[13].contains("Khaddaj"));
	}
	
	@Test
	void test19() throws Exception {
		String[] arr = getArray('U');
		assertTrue(arr[0].contains("13395")
				&& arr[0].contains("UPEN"));
	}
	
	@Test
	void test20() throws Exception {
		String[] arr = getArray('U');
		assertTrue(arr[1].contains("Univ.Preparatory Progr.English")
				&& arr[1].contains("REYNOL"));
	}

}
