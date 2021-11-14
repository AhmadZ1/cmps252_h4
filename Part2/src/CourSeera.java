import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CourSeera implements ICourSeera {
	List<ICourse> courses;
	
	public CourSeera() {}
	
	public CourSeera(List<ICourse> courses) {
		this.courses = courses;
	}
	
	public void setCourses(List<ICourse> courses) {
		this.courses = courses;
	}
	
	@Override
	public TreeMap<IRoom, List<ISchedule>> roomSchedule() {
		TreeMap<IRoom, List<ISchedule>> map = new TreeMap<IRoom, List<ISchedule>>();
		for (ICourse course : this.courses) {
			Room room = new Room(course.getBldg(), course.getCourse_num());
			Instructor instructor = new Instructor(course.getInstructor_first(), course.getInstructor_last());
			ISchedule sched = new Schedule(course.getRoom(), course.getBegin_time(), course.getEnd_time(), instructor, course.getSubject());
			List<ISchedule> lst = (map.get(room) == null ? new ArrayList<ISchedule>() : map.get(room));
			lst.add(sched);
			map.put(room, lst);
		}
		return map;
	}

	@Override
	public List<ISchedule> roomSchedule(IRoom room) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		for (ICourse course : this.courses) {
			if (!room.toString().equals(course.getBldg() + course.getRoom())) continue;
			Instructor instructor = new Instructor(course.getInstructor_first(), course.getInstructor_last());
			ISchedule sched = new Schedule(course.getRoom(), course.getBegin_time(), course.getEnd_time(), instructor, course.getSubject());
			listOfSchedule.add(sched);
		}
		return listOfSchedule;
	}

	@Override
	public List<ISchedule> roomSchedule(IRoom room, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISchedule> roomSchedule(IRoom room, DayOfWeek day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISchedule whoWasThereLast(IRoom room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISchedule whoIsThereNow(IRoom room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISchedule> profSchedule(IInstructor instructor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISchedule whereIsProf(IInstructor instructor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISchedule> whereWillProfBe(IInstructor instructor) {
		// TODO Auto-generated method stub
		return null;
	}

}
