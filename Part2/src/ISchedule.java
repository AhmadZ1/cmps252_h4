import java.time.LocalTime;

public interface ISchedule {
	String getRoom();
	LocalTime getFromTime();
	LocalTime getToTime();
	String getInstructor();
	String getCourse();
}