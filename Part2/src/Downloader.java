import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Downloader implements IDownloader {
	@Override
	public void downloadHtmlToFile(String url, String file) {
		try { File f = new File(file); if (f.exists()) f.delete(); Files.copy(new URL(url).openStream(), Paths.get(file)); } catch(Exception ex) {}
	}
}
