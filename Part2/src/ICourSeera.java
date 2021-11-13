import java.util.List;
import java.util.TreeMap;

public interface ICourSeera {
	TreeMap<IRoom, List<ISchedule>> roomSchedule();//lists the schedule for every room in alphabetical room number order
	List<ISchedule> roomSchedule(IRoom room);//lists the schedule for a specific room
	List<ISchedule> roomSchedule(IRoom room, java.time.LocalDate date);//lists the schedule for a specific room for a specific date
	List<ISchedule> roomSchedule(IRoom room, DayOfWeek day);//lists the schedule for a specific room for a specific day of week
	ISchedule whoWasThereLast(IRoom room);//lists the course and instructor name for the last time this room was occupied
	ISchedule whoIsThereNow(IRoom room);//lists the course and instructor name currently occupying a specific room
	List<ISchedule> profSchedule(IInstructor instructor); //lists the instructor’s weekly schedule (day, time, room)
	ISchedule whereIsProf(IInstructor instructor); //lists the room where a prof is currently teaching (if any)
	List<ISchedule> whereWillProfBe(IInstructor instructor); //lists the instructor’s schedule for today
}
