import java.time.LocalTime;


public class Schedule implements ISchedule {
	IRoom room;
	ICourse course;
	String days = "";
	LocalTime fromTime, toTime;
	IInstructor instructor;
	
	public Schedule() {}
	
	public Schedule(ICourse Course) {
		this.course = Course;
		this.room = new Room(course.getBldg(), course.getRoom());
		this.fromTime = course.getBegin_time();
		this.toTime = course.getEnd_time();
		this.instructor = new Instructor(course.getInstructor_first(), course.getInstructor_last());
		if (course.getMonday()) this.days += "M";
		if (course.getTuesday()) this.days += "T";
		if (course.getWednesday()) this.days += "W";
		if (course.getThursday()) this.days += "R";
		if (course.getFriday()) this.days += "F";
		if (course.getSaturday()) this.days += "S";
	}
	
	public void setRoom(IRoom room) {
		this.room = room;
	}
	
	public void setCourse(ICourse course) {
		this.course = course;
	}
	
	public void setFromTime(LocalTime fromTime) {
		this.fromTime = fromTime;
	}
	
	public void setToTime(LocalTime toTime) {
		this.toTime = toTime;
	}
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public void setDays(String days) {
		this.days = days;
	}

	@Override
	public IRoom getRoom() {
		return this.room;
	}

	@Override
	public LocalTime getFromTime() {
		return this.fromTime;
	}

	@Override
	public LocalTime getToTime() {
		return this.toTime;
	}

	@Override
	public IInstructor getInstructor() {
		return this.instructor;
	}

	@Override
	public ICourse getCourse() {
		return this.course;
	}
	
	public String getDays() {
		return this.days;
	}
	
	public String toString() {
		return (fromTime == null ? "NA" : fromTime) + "-" + (toTime == null ? "NA" : toTime) + " " + course + ", " + days + ", " + instructor;
	}

	@Override
	public int compareTo(ISchedule o) {
		return toString().compareTo(o.toString());
	}

}
