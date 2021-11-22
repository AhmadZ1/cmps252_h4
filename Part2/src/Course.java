import java.time.LocalTime;

public class Course implements ICourse {
	String[] arr;
	
	/***
	 * {@summary} constructor for Course, takes an array of strings that contains all data of a course
	 * @param arr
	 */
	public Course(String[] arr) {
		this.arr = arr;
	}
	
	/***
	 * @return the crn of the course
	 */
	@Override
	public String getCrn() {
		return arr[1];
	}
	
	/***
	 * @return the subject of the course
	 */
	@Override
	public String getSubject() {
		return arr[2];
	}

	/***
	 * @return the course number
	 */
	@Override
	public String getCourse_num() {
		return arr[3];
	}

	/***
	 * @return the course section
	 */
	@Override
	public String getSection() {
		return arr[4];
	}

	/***
	 * @return the course title
	 */
	@Override
	public String getTitle() {
		return arr[5];
	}

	/***
	 * @return the course credit hours
	 */
	@Override
	public float getCredithrs() {
		return Float.parseFloat(arr[6]);
	}

	/***
	 * @return the course college
	 */
	@Override
	public String getCollege() {
		return arr[8];
	}

	/***
	 * @return the number of actual enrollment in the course
	 */
	@Override
	public int getActual_enrol() {
		return Integer.parseInt(arr[9]);
	}

	/***
	 * @return the number of available seats in the course
	 */
	@Override
	public int getSeats_available() {
		return Integer.parseInt(arr[10]);
	}

	/***
	 * @return the beginning time of the course section
	 */
	@Override
	public LocalTime getBegin_time() {
		if (arr[11].length() < 4) return null;
		return LocalTime.parse(arr[11].substring(0, 2) + ":" + arr[11].substring(2));
	}

	/***
	 * @return the end time of the course section
	 */
	@Override
	public LocalTime getEnd_time() {
		if (arr[12].length() < 4) return null;
		return LocalTime.parse(arr[12].substring(0, 2) + ":" + arr[12].substring(2));
	}

	/***
	 * @return the building where the course is given
	 */
	@Override
	public String getBldg() {
		return arr[13];
	}

	/***
	 * @return the room where the course is given
	 */
	@Override
	public String getRoom() {
		return this.getBldg() + " " + arr[14];
	}

	/***
	 * @return true if the course is given on Mondays
	 */
	@Override
	public boolean getMonday() {
		return arr[15].equals("M");
	}

	/***
	 * @return true if the course is given on Tuesdays
	 */
	@Override
	public boolean getTuesday() {
		return arr[16].equals("T");
	}

	/***
	 * @return true if the course is given on Wednesdays
	 */
	@Override
	public boolean getWednesday() {
		return arr[17].equals("W");
	}

	/***
	 * @return true if the course is given on Thursdays
	 */
	@Override
	public boolean getThursday() {
		return arr[18].equals("R");
	}

	/***
	 * @return true if the course is given on Fridays
	 */
	@Override
	public boolean getFriday() {
		return arr[19].equals("F");
	}

	/***
	 * @return true if the course is given on Saturdays
	 */
	@Override
	public boolean getSaturday() {
		return arr[20].equals("S");
	}

	/***
	 * @return the instructor's first name
	 */
	@Override
	public String getInstructor_first() {
		return arr[33];
	}

	/***
	 * @return the instructor's last name
	 */
	@Override
	public String getInstructor_last() {
		return arr[34];
	}
	
	public String toString() {
		return this.getSubject() + " " + this.getCourse_num();
	}

}
