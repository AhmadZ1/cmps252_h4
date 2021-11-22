
public class Room implements IRoom {
	String building, number;
	
	/***
	 * {@summary} default constructor for Room class
	 */
	public Room() {}
	
	/***
	 * {@summary} constructor for Room class that takes the building and room number as arguments
	 * @param building the building name where the room is located
	 * @param number the room number
	 */
	public Room(String building, String number) {
		this.building = building;
		this.number = number;
	}
	
	/***
	 * {@summary} sets the building attribute to the given one
	 * @param building the building name where the room is located
	 */
	public void setBuilding(String building) {
		this.building = building;
	}
	
	/***
	 * {@summary} sets the room number attribute to the given one
	 * @param number the room number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/***
	 * @return the room building
	 */
	@Override
	public String getBuilding() {
		return this.building;
	}

	/***
	 * @return the room number
	 */
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
