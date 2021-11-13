import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Downloader implements IDownloader {
	public void downloadHtmlToFile(String url, String file) {
		try { Files.copy(new URL(url).openStream(), Paths.get(file)); } catch(Exception ex) {}
	}
}
