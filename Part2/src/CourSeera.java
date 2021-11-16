import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// NOT COMPLETED YET, TO BE SUBMITTED NEXT MONDAY

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
			Room room = new Room(course.getBldg(), course.getRoom());
			ISchedule sched = new Schedule(course);
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
			ISchedule sched = new Schedule(course);
			if (!room.toString().equals(sched.getRoom())) continue;
			listOfSchedule.add(sched);
		}
		return listOfSchedule;
	}

	@Override
	public List<ISchedule> roomSchedule(IRoom room, LocalDate date) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		for (ICourse course : this.courses) {
			String dayOfWeek = date.getDayOfWeek().toString();
			ISchedule sched = new Schedule(course);
			if (!room.toString().equals(sched.getRoom())) continue;
			if (dayOfWeek.equals("MONDAY")) if (course.getMonday()) listOfSchedule.add(sched);
			if (dayOfWeek.equals("TUESDAY")) if (course.getTuesday()) listOfSchedule.add(sched);
			if (dayOfWeek.equals("WEDNESDAY")) if (course.getWednesday()) listOfSchedule.add(sched);
			if (dayOfWeek.equals("THURSDAY")) if (course.getThursday()) listOfSchedule.add(sched);
			if (dayOfWeek.equals("FRIDAY")) if (course.getFriday()) listOfSchedule.add(sched);
			if (dayOfWeek.equals("SATURDAY")) if (course.getSaturday()) listOfSchedule.add(sched);
		}
		return listOfSchedule;
	}

	@Override
	public List<ISchedule> roomSchedule(IRoom room, DayOfWeek day) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		for (ICourse course : this.courses) {
			ISchedule sched = new Schedule(course);
			if (!room.toString().equals(sched.getRoom())) continue;
			if (day == DayOfWeek.Monday) if (course.getMonday()) listOfSchedule.add(sched);
			if (day == DayOfWeek.Tuesday) if (course.getTuesday()) listOfSchedule.add(sched);
			if (day == DayOfWeek.Wednesday) if (course.getWednesday()) listOfSchedule.add(sched);
			if (day == DayOfWeek.Thursday) if (course.getThursday()) listOfSchedule.add(sched);
			if (day == DayOfWeek.Friday) if (course.getFriday()) listOfSchedule.add(sched);
			if (day == DayOfWeek.Saturday) if (course.getSaturday()) listOfSchedule.add(sched);
		}
		return listOfSchedule;
	}

	@Override
	public ISchedule whoWasThereLast(IRoom room) {
		// TODO Auto-generated method stub
		LocalTime now = LocalTime.now();
		List<ISchedule> listOfSchedule = this.roomSchedule(room, LocalDate.now());
		int i = 0;
		ISchedule ans = listOfSchedule.get(i);
		while (now.toString().compareTo(ans.getToTime().toString()) <= 0) { ++i; ans = listOfSchedule.get(i); }
		for (; i < listOfSchedule.size(); ++i) {
			if (now.toString().compareTo(listOfSchedule.get(i).getToTime().toString()) <= 0) continue;
			if (listOfSchedule.get(i).getToTime().toString().compareTo(ans.getToTime().toString()) <= 0) continue;
			ans = listOfSchedule.get(i);
		}
		return ans;
	}

	@Override
	public ISchedule whoIsThereNow(IRoom room) {
		LocalTime now = LocalTime.now();
		List<ISchedule> listOfSchedule = this.roomSchedule(room, LocalDate.now());
		for (int i = 0; i < listOfSchedule.size(); ++i) {
			if (now.toString().compareTo(listOfSchedule.get(i).getFromTime().toString()) >= 0
					&& now.toString().compareTo(listOfSchedule.get(i).getToTime().toString()) <= 0) return listOfSchedule.get(i);
		}
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
