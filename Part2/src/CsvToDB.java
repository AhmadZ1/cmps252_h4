import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CsvToDB implements ICsvToDB {

	/***
	 * {@summary} reads the csv files and puts them in a list of courses representing the database
	 * @param courses the list of courses where the courses will be stored
	 * @param csvFile the path of the csv file to be read and processed
	 * @throws FileNotFoundException 
	 */
	@Override
	public void csvToDb(List<ICourse> courses, String csvFile) throws FileNotFoundException {
		if (!(new File(csvFile).exists())) return; 
		Scanner input = new Scanner(new File(csvFile));
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line.isBlank()) continue;
			if (line.contains("Spring")) continue;
			String[] list = line.split(",");
			if (list.length < 35) continue;
			Course course = new Course(list);
			courses.add(course);
		}
		input.close();
	}
}
