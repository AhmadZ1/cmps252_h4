import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

public class HW4_Part1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// C:\\Users\\asz07\\Desktop\\test.txt
		TreeMap<String, ArrayList<ArrayList<Object>>> map = FileParser.parse("X:\\test.txt");
		FileParser.print(map);
	}

}
