
public class Room implements IRoom {
	String building, number;
	
	public Room() {}
	
	public Room(String building, String number) {
		this.building = building;
		this.number = number;
	}
	
	public void setBuilding(String building) {
		this.building = building;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String getBuilding() {
		return this.building;
	}

	@Override
	public String getRoomNumber() {
		return this.number;
	}
	
	public String toString() {
		return this.building + " " + this.number;
	}

	@Override
	public int compareTo(IRoom o) {
		return this.toString().compareTo((o.toString()));
	}
	
}
