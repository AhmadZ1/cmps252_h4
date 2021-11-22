import java.time.LocalTime;


public class Schedule implements ISchedule {
	IRoom room;
	ICourse course;
	DayOfWeek day;
	LocalTime fromTime, toTime;
	IInstructor instructor;
	
	/***
	 * {@summary} default constructor for Schedule
	 */
	public Schedule() {}
	
	/***
	 * {@summary} constructor for Schedule that takes Course and DayOfWeek as arguments
	 * @param Course the course to be schedules
	 * @param day the day of week where the course is given
	 */
	public Schedule(ICourse Course, DayOfWeek day) {
		this.course = Course;
		this.room = new Room(course.getBldg(), course.getRoom());
		this.fromTime = course.getBegin_time();
		this.toTime = course.getEnd_time();
		this.instructor = new Instructor(course.getInstructor_first(), course.getInstructor_last());
		this.day = day;
	}
	
	/***
	 * {@summary} sets the room attribute to the given one
	 * @param room the room where the course is given
	 */
	public void setRoom(IRoom room) {
		this.room = room;
	}
	
	/***
	 * {@summary} sets the course attribute to the given one
	 * @param course the course that is given
	 */
	public void setCourse(ICourse course) {
		this.course = course;
	}
	
	/***
	 * {@summary} sets the beginning time attribute to the given one
	 * @param fromTime the beginning time of the course given
	 */
	public void setFromTime(LocalTime fromTime) {
		this.fromTime = fromTime;
	}
	
	/***
	 * {@summary} sets the end time attribute to the given one
	 * @param toTime the end time of the course given
	 */
	public void setToTime(LocalTime toTime) {
		this.toTime = toTime;
	}
	
	/***
	 * {@summary} sets the instructor attribute to the given one
	 * @param instructor the instructor that is giving the course
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	/***
	 * {@summary} sets the day of week attribute to the given one
	 * @param day the day on which the course is given
	 */
	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	/***
	 * @return the schedule's room
	 */
	@Override
	public IRoom getRoom() {
		return this.room;
	}

	/***
	 * @return the schedule's begin time
	 */
	@Override
	public LocalTime getFromTime() {
		return this.fromTime;
	}

	/***
	 * @return the schedule's end time
	 */
	@Override
	public LocalTime getToTime() {
		return this.toTime;
	}

	/***
	 * @return the schedule's instructor
	 */
	@Override
	public IInstructor getInstructor() {
		return this.instructor;
	}

	/***
	 * @return the schedule's course
	 */
	@Override
	public ICourse getCourse() {
		return this.course;
	}

	/***
	 * @return the schedule's day of week
	 */
	@Override
	public DayOfWeek getDay() {
		return this.day;
	}
	
	public String toString() {
		return (fromTime == null ? "NA" : fromTime) + "-" + (toTime == null ? "NA" : toTime) + " " + course + ", " + instructor;
	}

	@Override
	public int compareTo(ISchedule o) {
		return (getDayNum(this.getDay()) + " " + toString()).compareTo((getDayNum(o.getDay()) + " " + o.toString()));
	}
	
	private String getDayNum(DayOfWeek day) {
		switch (day) {
		case Monday: return "0";
		case Tuesday: return "1";
		case Wednesday: return "2";
		case Thursday: return "3";
		case Friday: return "4";
		case Saturday: return "5";
		default: return "6";
		}
	}

}
