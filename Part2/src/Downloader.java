import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Downloader implements IDownloader {
	@Override
	public void downloadHtmlToFile(String url, String file) {
		try { if (new File(file).exists()) return; Files.copy(new URL(url).openStream(), Paths.get(file)); } catch(Exception ex) {}
	}
}
