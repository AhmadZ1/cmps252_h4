import java.time.LocalTime;

public interface ISchedule extends Comparable<ISchedule> {
	IRoom getRoom();
	LocalTime getFromTime();
	LocalTime getToTime();
	IInstructor getInstructor();
	ICourse getCourse();
}