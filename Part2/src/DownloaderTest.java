import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class DownloaderTest {

	@Test
	void test() {
		Downloader downloader = new Downloader();
		downloader.downloadHtmlToFile("https://www-banner.aub.edu.lb/catalog/schd_A.html", "X:\\252\\cmps252_h4\\Html_Files\\A.txt");
		assertTrue(new File("X:\\252\\cmps252_h4\\Html_Files\\A.txt").exists());
	}

}
