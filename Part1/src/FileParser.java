import java.util.ArrayList;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
	public static TreeMap<String, ArrayList<ArrayList<Object>>> parse(String filePath) throws FileNotFoundException {
		TreeMap<String, ArrayList<ArrayList<Object>>> map = new TreeMap<String, ArrayList<ArrayList<Object>>>();
		Scanner input = new Scanner(new File(filePath));
		while (input.hasNextLine()) {
			String rhs = "", curr = "", line = input.nextLine();
			boolean found = false;
			ArrayList<Object> value = new ArrayList<Object>();
			ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
			for (int i = 0; i < line.length(); ++i) {
				if (line.charAt(i) == '|') { list.add(value); value.clear(); }
				else if (line.charAt(i) == '<') continue;
				else if (line.charAt(i) == '>') {
					if (found) value.add(curr);
					else { rhs = curr; found = true; }
					curr = "";
				}
				else if (line.charAt(i) == ' ') {
					if (curr.length() == 0) continue;
					value.add(curr);
					curr = "";
				}
				else if (line.charAt(i) != ' ') curr += line.charAt(i);
			}
			map.put(rhs, list);
		}
		input.close();
		return map;
	}
	public static void print(TreeMap<String, ArrayList<ArrayList<Object>>> map) {
		for (var entry : map.entrySet()) {
			System.out.print(entry.getKey() + " : ");
			for (var val : entry.getValue()) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}
