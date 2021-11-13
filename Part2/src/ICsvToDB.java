import java.util.List;

public interface ICsvToDB {
	void csvToDb(List<ICourse> courses, String csvFile);
}
