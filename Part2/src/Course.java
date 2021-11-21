import java.time.LocalTime;

public class Course implements ICourse {
	String[] arr;
	
	public Course(String[] arr) {
		this.arr = arr;
	}
	
	@Override
	public String getCrn() {
		return arr[1];
	}

	@Override
	public String getSubject() {
		return arr[2];
	}

	@Override
	public String getCourse_num() {
		return arr[3];
	}

	@Override
	public String getSection() {
		return arr[4];
	}

	@Override
	public String getTitle() {
		return arr[5];
	}

	@Override
	public float getCredithrs() {
		return Float.parseFloat(arr[6]);
	}

	@Override
	public String getCollege() {
		return arr[8];
	}

	@Override
	public int getActual_enrol() {
		return Integer.parseInt(arr[9]);
	}

	@Override
	public int getSeats_available() {
		return Integer.parseInt(arr[10]);
	}

	@Override
	public LocalTime getBegin_time() {
		if (arr[11].length() < 4) return null;
		return LocalTime.parse(arr[11].substring(0, 2) + ":" + arr[11].substring(2));
	}

	@Override
	public LocalTime getEnd_time() {
		if (arr[12].length() < 4) return null;
		return LocalTime.parse(arr[12].substring(0, 2) + ":" + arr[12].substring(2));
	}

	@Override
	public String getBldg() {
		return arr[13];
	}

	@Override
	public String getRoom() {
		return arr[14];
	}

	@Override
	public boolean getMonday() {
		return arr[15].equals("M");
	}

	@Override
	public boolean getTuesday() {
		return arr[16].equals("T");
	}

	@Override
	public boolean getWednesday() {
		return arr[17].equals("W");
	}

	@Override
	public boolean getThursday() {
		return arr[18].equals("R");
	}

	@Override
	public boolean getFriday() {
		return arr[19].equals("F");
	}

	@Override
	public boolean getSaturday() {
		return arr[20].equals("S");
	}

	@Override
	public String getInstructor_first() {
		return arr[33];
	}

	@Override
	public String getInstructor_last() {
		return arr[34];
	}
	
	public String toString() {
		return this.getSubject() + " " + this.getCourse_num();
	}

}
