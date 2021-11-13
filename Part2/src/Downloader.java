import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Downloader {
	public void downloadHtmlToFile(String url, String file) throws Exception {
		URL page = new URL(url); Files.copy(page.openStream(), Paths.get(file));
	}
}
