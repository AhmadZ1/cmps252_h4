import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class DownloaderTest {

	@Test
	void test() throws Exception {
		Downloader downloader = new Downloader();
		downloader.downloadHtmlToFile("https://www-banner.aub.edu.lb/catalog/schd_A.html", "C:\\Users\\acer\\OneDrive\\Desktop\\cmps252_h4\\Files\\A.txt");
		assertTrue(new File("C:\\Users\\acer\\OneDrive\\cmps252_h4\\Files\\A.txt").exists());
	}

}
