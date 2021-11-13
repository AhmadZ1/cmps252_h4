import java.util.ArrayList;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
	String root;
	public TreeMap<String, ArrayList<ArrayList<String>>> parse(String filePath) throws FileNotFoundException {
		TreeMap<String, ArrayList<ArrayList<String>>> map = new TreeMap<String, ArrayList<ArrayList<String>>>();
		Scanner input = new Scanner(new File(filePath));
		boolean isRoot = false;
		while (input.hasNextLine()) {
			String rhs = "", curr = "", line = input.nextLine(); // rhs is the key, curr is the current
			boolean found = false; // if we found the key or not yet
			ArrayList<String> value = new ArrayList<String>(); // list of strings
			ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>(); // list of lists of strings
			for (int i = 0; i < line.length(); ++i) {
				if (line.charAt(i) == '|') {
					if (!curr.isEmpty()) value.add(curr);
					list.add(value);
					value = new ArrayList<String>();
					curr = "";
					continue;
				}
				// skip =, :, and white characters 
				if (line.charAt(i) == ' ' || line.charAt(i) == '=' || line.charAt(i) == ':') continue;
				curr += line.charAt(i);
				if (line.charAt(i) == '>') {
					if (!isRoot) { this.root = curr; isRoot = true; }
					if (found) value.add(curr);
					else { rhs = curr; found = true; }
					curr = "";
				}
			}
			if (!curr.isEmpty()) value.add(curr);
			if (!value.isEmpty()) list.add(value);
			map.put(rhs, list);
		}
		input.close();
		return map;
	}
	
	public String getRoot() {
		return this.root;
	}
	
	public void print(TreeMap<String, ArrayList<ArrayList<String>>> map) {
		for (var entry : map.entrySet()) {
			System.out.print(entry.getKey() + " : " + entry.getValue());
			System.out.println();
		}
	}
}
