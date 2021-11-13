import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Random;

public class Generator {
	TreeMap<String, ArrayList<ArrayList<String>>> list;
	Random rand = new Random();
	public Generator(TreeMap<String, ArrayList<ArrayList<String>>> list) {
		this.list = list;
	}
	public String generate(String word) {
		if (word.charAt(0) != '<') return word + " ";
		int n = list.get(word).size();
		int r = rand.nextInt(n);
		String ans = "";
		for (var val : list.get(word).get(r)) ans += generate(val);
		return ans;
	}
}
