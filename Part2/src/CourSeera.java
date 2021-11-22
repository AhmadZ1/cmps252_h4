import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;


public class CourSeera implements ICourSeera {
	List<ICourse> courses;
	
	/***
	 * {@summary} default constructor for CourSeera
	 */
	public CourSeera() {}
	
	/***
	 * {@summary} constructor for CourSeera that accepts list of courses (database) as an argument
	 * @param courses list of courses (database)
	 */
	public CourSeera(List<ICourse> courses) {
		this.courses = courses;
	}
	
	/***
	 * {@summary} sets the list of courses to the given one
	 * @param courses list of courses (database)
	 */
	public void setCourses(List<ICourse> courses) {
		this.courses = courses;
	}
	
	/***
	 * {@summary} lists the schedule for every room in alphabetical order
	 * @return map where the keys are rooms and values are schedules for each room
	 */
	@Override
	public TreeMap<IRoom, List<ISchedule>> roomSchedule() {
		TreeMap<IRoom, List<ISchedule>> map = new TreeMap<IRoom, List<ISchedule>>();
		for (ICourse course : this.courses) {
			Room room = new Room(course.getBldg(), course.getRoom());
			if (map.containsKey(room)) continue;
			List<ISchedule> lst = this.roomSchedule(room);
			map.put(room, lst);
		}
		return map;
	}

	/***
	 * {@summary} lists the schedule for the given room
	 * @param room the room to get its schedule
	 * @return schedule of the given room
	 */
	@Override
	public List<ISchedule> roomSchedule(IRoom room) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		for (ICourse course : this.courses) {
			if (!room.toString().equals(course.getRoom())) continue;
			if (course.getMonday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Monday));
			if (course.getTuesday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Tuesday));
			if (course.getWednesday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Wednesday));
			if (course.getThursday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Thursday));
			if (course.getFriday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Friday));
			if (course.getSaturday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Saturday));
		}
		Collections.sort(listOfSchedule);
		return listOfSchedule;
	}

	/***
	 * {@summary} lists the schedule for the given room at the given date
	 * @param room the room to get its schedule
	 * @param date the required date for the schedule
	 * @return schedule list for the given room at the given date
	 */
	@Override
	public List<ISchedule> roomSchedule(IRoom room, LocalDate date) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		String dayOfWeek = date.getDayOfWeek().toString();
		for (ICourse course : this.courses) {
			if (!room.toString().equals(course.getRoom())) continue;
			if (dayOfWeek.equals("MONDAY")) if (course.getMonday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Monday));
			if (dayOfWeek.equals("TUESDAY")) if (course.getTuesday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Tuesday));
			if (dayOfWeek.equals("WEDNESDAY")) if (course.getWednesday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Wednesday));
			if (dayOfWeek.equals("THURSDAY")) if (course.getThursday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Thursday));
			if (dayOfWeek.equals("FRIDAY")) if (course.getFriday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Friday));
			if (dayOfWeek.equals("SATURDAY")) if (course.getSaturday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Saturday));
		}
		Collections.sort(listOfSchedule);
		return listOfSchedule;
	}

	/***
	 * {@summary} lists the schedule for the given room at the given day
	 * @param room the room to get its schedule
	 * @param day the required day for the schedule
	 * @return schedule list for the given room at the given day
	 */
	@Override
	public List<ISchedule> roomSchedule(IRoom room, DayOfWeek day) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		for (ICourse course : this.courses) {
			if (!room.toString().equals(course.getRoom())) continue;
			if (day == DayOfWeek.Monday) if (course.getMonday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Monday));
			if (day == DayOfWeek.Tuesday) if (course.getTuesday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Tuesday));
			if (day == DayOfWeek.Wednesday) if (course.getWednesday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Wednesday));
			if (day == DayOfWeek.Thursday) if (course.getThursday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Thursday));
			if (day == DayOfWeek.Friday) if (course.getFriday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Friday));
			if (day == DayOfWeek.Saturday) if (course.getSaturday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Saturday));
		}
		Collections.sort(listOfSchedule);
		return listOfSchedule;
	}

	/***
	 * {@summary} gets the class that was held last at the given room
	 * @param room the room we want to search for
	 * @param day the day we want to search in
	 * @param notToday to determine if we are searching in today's or yesterday's classes
	 * @return the last schedule of the given room at the given day before the time the function was called
	 */
	private ISchedule whoWasThereLast(IRoom room, DayOfWeek day, boolean notToday) {
		LocalTime now = LocalTime.now();
		List<ISchedule> listOfSchedule = this.roomSchedule(room, day);
		if (listOfSchedule.isEmpty() || (now.toString().compareTo("08:00") < 0 && !notToday)) return whoWasThereLast(room, this.getPreviousDay(day), true);
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
	
	/***
	 * {@summary} gets what class was held last at the given room
	 * @param room the room to be searched in its schedule
	 * @return the last class schedule that was held in the given room
	 */
	@Override
	public ISchedule whoWasThereLast(IRoom room) {
		String today = LocalDate.now().getDayOfWeek().toString();
		if (today.equals("SUNDAY") || today.equals("SATURDAY")) {
			ISchedule lastOnSaturday = whoWasThereLast(room, DayOfWeek.Saturday, true), lastOnFriday = whoWasThereLast(room, DayOfWeek.Friday, true);
			return (lastOnSaturday == null ? lastOnFriday : lastOnSaturday);
		}
		return whoWasThereLast(room, this.getToday(LocalDate.now().getDayOfWeek().toString()), false);
	}

	/***
	 * {@summary} gets who is there now at the given room (if any)
	 * @param room the room to be searched in its schedule
	 * @return who is there at the given room (if any)
	 */
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

	/***
	 * {@summary} gets the schedule of an instructor
	 * @param instructor the instructor to get its schedule
	 * @return the schedule for the given instructor
	 */
	@Override
	public List<ISchedule> profSchedule(IInstructor instructor) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		for (ICourse course : this.courses) {
			if (!instructor.toString().toLowerCase().equals((course.getInstructor_first() + " " + course.getInstructor_last()).toLowerCase())) continue;
			if (course.getMonday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Monday));
			if (course.getTuesday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Tuesday));
			if (course.getWednesday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Wednesday));
			if (course.getThursday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Thursday));
			if (course.getFriday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Friday));
			if (course.getSaturday()) listOfSchedule.add(new Schedule(course, DayOfWeek.Saturday));
		}
		Collections.sort(listOfSchedule);
		return listOfSchedule;
	}

	/***
	 * {@summary} gets where is the given instructor now (if any)
	 * @param instructor the instructor to check where they are now
	 * @return where is the instructor now (if any)
	 */
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

	/***
	 * {@summary} lists the schedule of the given instructor at the day the method is called
	 * @param instructor the instructor to get their schedule
	 * @return schedule of the given instructor at the day of calling the method
	 */
	@Override
	public List<ISchedule> whereWillProfBe(IInstructor instructor) {
		List<ISchedule> listOfSchedule = new ArrayList<ISchedule>();
		DayOfWeek today = this.getToday(LocalDate.now().getDayOfWeek().toString());
		for (ICourse course : this.courses) {
			if (!instructor.toString().toLowerCase().equals((course.getInstructor_first() + " " + course.getInstructor_last()).toLowerCase())) continue;
			if (course.getMonday() && today == DayOfWeek.Monday) listOfSchedule.add(new Schedule(course, DayOfWeek.Monday));
			if (course.getTuesday() && today == DayOfWeek.Tuesday) listOfSchedule.add(new Schedule(course, DayOfWeek.Tuesday));
			if (course.getWednesday() && today == DayOfWeek.Wednesday) listOfSchedule.add(new Schedule(course, DayOfWeek.Wednesday));
			if (course.getThursday() && today == DayOfWeek.Thursday) listOfSchedule.add(new Schedule(course, DayOfWeek.Thursday));
			if (course.getFriday() && today == DayOfWeek.Friday) listOfSchedule.add(new Schedule(course, DayOfWeek.Friday));
			if (course.getSaturday() && today == DayOfWeek.Saturday) listOfSchedule.add(new Schedule(course, DayOfWeek.Saturday));
		}
		Collections.sort(listOfSchedule);
		return listOfSchedule;
	}
	
	/***
	 * {@summary} transforms a string representing a day into a DayOfWeek enum
	 * @param day the day to convert to enum as a string
	 * @return DayOfWeek enum corresponding for the given day
	 */
	private DayOfWeek getToday(String day) {
		switch (day) {
		case "MONDAY": return DayOfWeek.Monday;
		case "TUESDAY": return DayOfWeek.Tuesday;
		case "WEDNESDAY": return DayOfWeek.Wednesday;
		case "THURSDAY": return DayOfWeek.Thursday;
		case "FRIDAY": return DayOfWeek.Friday;
		case "SATURDAY": return DayOfWeek.Saturday;
		default: return DayOfWeek.Sunday;
		}
	}
	
	/***
	 * {@summary} gets the day immediately before the given day
	 * @param day the day to get its previous day
	 * @return the day immediately before the given day
	 */
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
