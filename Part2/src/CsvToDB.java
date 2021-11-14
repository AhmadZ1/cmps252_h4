import java.io.File;
import java.util.List;
import java.util.Scanner;

public class CsvToDB implements ICsvToDB {

	@Override
	public void csvToDb(List<ICourse> courses, String csvFile) throws Exception {
		Scanner input = new Scanner(new File(csvFile));
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line.contains("Spring")) continue;
			String[] list = line.split(",");
			Course course = new Course(list);
			courses.add(course);
		}
		input.close();
	}
}
