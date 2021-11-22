import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Downloader implements IDownloader {
	/***
	 * {@summary} downloads the html page of the given url into the given file
	 * @param url the url of the page to be downloaded
	 * @param file the path of the file where the content will be downloaded
	 */
	@Override
	public void downloadHtmlToFile(String url, String file) {
		try { File f = new File(file); if (f.exists()) f.delete(); f.createNewFile(); Files.copy(new URL(url).openStream(), Paths.get(file)); } catch(Exception ex) {System.out.println(ex);}
	}
}
