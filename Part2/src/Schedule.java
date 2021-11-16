import java.time.LocalTime;

public class Schedule implements ISchedule {
	String room, course, days = "";
	LocalTime fromTime, toTime;
	Instructor instructor;
	
	public Schedule() {}
	
	public Schedule(ICourse Course) {
		this.room = Course.getBldg() + " " + Course.getRoom();
		this.fromTime = Course.getBegin_time();
		this.toTime = Course.getEnd_time();
		this.instructor = new Instructor(Course.getInstructor_first(), Course.getInstructor_last());
		this.course = Course.getSubject() + " " + Course.getCourse_num();
		if (Course.getMonday()) this.days += "M";
		if (Course.getTuesday()) this.days += "T";
		if (Course.getWednesday()) this.days += "W";
		if (Course.getThursday()) this.days += "R";
		if (Course.getFriday()) this.days += "F";
		if (Course.getSaturday()) this.days += "S";
	}
	
	public void setRoom(String room) {
		this.room = room;
	}
	
	public void setCourse(String course) {
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

	@Override
	public String getRoom() {
		// TODO Auto-generated method stub
		return this.room;
	}

	@Override
	public LocalTime getFromTime() {
		// TODO Auto-generated method stub
		return this.fromTime;
	}

	@Override
	public LocalTime getToTime() {
		// TODO Auto-generated method stub
		return this.toTime;
	}

	@Override
	public String getInstructor() {
		// TODO Auto-generated method stub
		return this.instructor.toString();
	}

	@Override
	public String getCourse() {
		// TODO Auto-generated method stub
		return this.course;
	}
	
	public String getDays() {
		return this.days;
	}
	
	public String toString() {
		return "<Course: " + course + "\n" 
				+ "Room: " + room + "\n"
				+ "Time: " + fromTime + " -> " + toTime + "\n"
				+ "Days: " + days + "\n"
				+ "Instructor: " + instructor.toString() + "/>\n";
	}

}
