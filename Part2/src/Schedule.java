import java.time.LocalTime;

public class Schedule implements ISchedule {
	String room, course;
	LocalTime fromTime, toTime;
	Instructor instructor;
	
	public Schedule() {}
	
	public Schedule(String room, LocalTime fromTime, LocalTime toTime, Instructor instructor, String course) {
		this.room = room;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.instructor = instructor;
		this.course = course;
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
		return null;
	}

	@Override
	public LocalTime getFromTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTime getToTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstructor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCourse() {
		// TODO Auto-generated method stub
		return null;
	}

}
