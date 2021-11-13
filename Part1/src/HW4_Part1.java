import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

public class HW4_Part1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// C:\\Users\\asz07\\Desktop\\test.txt
		FileParser fileParser = new FileParser();
		TreeMap<String, ArrayList<ArrayList<String>>> map = fileParser.parse("X:\\test.txt");
		String root = fileParser.getRoot();
		Generator generator = new Generator(map);
		System.out.println(generator.generate(root));
	}
}
