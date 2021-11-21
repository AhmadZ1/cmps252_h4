import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
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
			if (!room.toString().equals(sched.getRoom().toString())) continue;
			listOfSchedule.add(sched);
		}
		Collections.sort(listOfSchedule);
		return listOfSchedule;
	}

	@Override
	public List<ISchedule> roomSchedule(IRoom room, LocalDate date) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		String dayOfWeek = date.getDayOfWeek().toString();
		for (ICourse course : this.courses) {
			ISchedule sched = new Schedule(course);
			if (!room.toString().equals(sched.getRoom().toString())) continue;
			if (dayOfWeek.equals("MONDAY")) if (course.getMonday()) listOfSchedule.add(sched);
			if (dayOfWeek.equals("TUESDAY")) if (course.getTuesday()) listOfSchedule.add(sched);
			if (dayOfWeek.equals("WEDNESDAY")) if (course.getWednesday()) listOfSchedule.add(sched);
			if (dayOfWeek.equals("THURSDAY")) if (course.getThursday()) listOfSchedule.add(sched);
			if (dayOfWeek.equals("FRIDAY")) if (course.getFriday()) listOfSchedule.add(sched);
			if (dayOfWeek.equals("SATURDAY")) if (course.getSaturday()) listOfSchedule.add(sched);
		}
		Collections.sort(listOfSchedule);
		return listOfSchedule;
	}

	@Override
	public List<ISchedule> roomSchedule(IRoom room, DayOfWeek day) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		for (ICourse course : this.courses) {
			ISchedule sched = new Schedule(course);
			if (!room.toString().equals(sched.getRoom().toString())) continue;
			if (day == DayOfWeek.Monday) if (course.getMonday()) listOfSchedule.add(sched);
			if (day == DayOfWeek.Tuesday) if (course.getTuesday()) listOfSchedule.add(sched);
			if (day == DayOfWeek.Wednesday) if (course.getWednesday()) listOfSchedule.add(sched);
			if (day == DayOfWeek.Thursday) if (course.getThursday()) listOfSchedule.add(sched);
			if (day == DayOfWeek.Friday) if (course.getFriday()) listOfSchedule.add(sched);
			if (day == DayOfWeek.Saturday) if (course.getSaturday()) listOfSchedule.add(sched);
		}
		Collections.sort(listOfSchedule);
		return listOfSchedule;
	}

	private ISchedule whoWasThereLast(IRoom room, DayOfWeek day, boolean notToday) {
		LocalTime now = LocalTime.now();
		List<ISchedule> listOfSchedule = this.roomSchedule(room, day);
		if (listOfSchedule.isEmpty() || now.toString().compareTo("08:00") < 0) return whoWasThereLast(room, this.getPreviousDay(day), true);
		if (notToday) return listOfSchedule.get(listOfSchedule.size() - 1);
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
	public ISchedule whoWasThereLast(IRoom room) {
		String today = LocalDate.now().getDayOfWeek().toString();
		if (today.equals("SUNDAY") || today.equals("SATURDAY")) {
			ISchedule lastOnSaturday = whoWasThereLast(room, DayOfWeek.Saturday, true), lastOnFriday = whoWasThereLast(room, DayOfWeek.Friday, true);
			return (lastOnSaturday == null ? lastOnFriday : lastOnSaturday);
		}
		return whoWasThereLast(room, this.getToday(LocalDate.now().getDayOfWeek().toString()), false);
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
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		for (ICourse course : this.courses) {
			ISchedule sched = new Schedule(course);
			if (!instructor.toString().equals(sched.getInstructor().toString())) continue;
			listOfSchedule.add(sched);
		}
		Collections.sort(listOfSchedule);
		return listOfSchedule;
	}

	@Override
	public ISchedule whereIsProf(IInstructor instructor) {
		List<ISchedule> todayProfSchedule = this.whereWillProfBe(instructor);
		LocalTime now = LocalTime.now();
		for (int i = 0; i < todayProfSchedule.size(); ++i) {
			if (now.toString().compareTo(todayProfSchedule.get(i).getFromTime().toString()) >= 0
					&& now.toString().compareTo(todayProfSchedule.get(i).getToTime().toString()) <= 0)
				return todayProfSchedule.get(i);
		}
		return null;
	}

	@Override
	public List<ISchedule> whereWillProfBe(IInstructor instructor) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		String day = LocalDate.now().getDayOfWeek().toString().charAt(0) + "";
		for (ICourse course : this.courses) {
			ISchedule sched = new Schedule(course);
			if (!instructor.toString().equals(sched.getInstructor().toString()) || !((Schedule) sched).getDays().contains(day)) continue;
			listOfSchedule.add(sched);
		}
		Collections.sort(listOfSchedule);
		return listOfSchedule;
	}
	
	private DayOfWeek getToday(String today) {
		switch (today) {
		case "MONDAY": return DayOfWeek.Monday;
		case "TUESDAY": return DayOfWeek.Tuesday;
		case "WEDNESDAY": return DayOfWeek.Wednesday;
		case "THURSDAY": return DayOfWeek.Thursday;
		case "FRIDAY": return DayOfWeek.Friday;
		case "SATURDAY": return DayOfWeek.Saturday;
		default: return DayOfWeek.Sunday;
		}
	}
	
	private DayOfWeek getPreviousDay(DayOfWeek today) {
		switch (today) {
		case Tuesday: return DayOfWeek.Monday;
		case Wednesday: return DayOfWeek.Tuesday;
		case Thursday: return DayOfWeek.Wednesday;
		case Friday: return DayOfWeek.Thursday;
		case Saturday: return DayOfWeek.Friday;
		case Sunday: return DayOfWeek.Saturday;
		default: return DayOfWeek.Saturday;
		}
	}

}
