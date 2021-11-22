
public class Instructor implements IInstructor {
	String firstName, lastName;
	
	/***
	 * {@summary} default constructor for Instructor class
	 */
	public Instructor() {}
	
	/***
	 * {@summary} constructor for Instructor class that takes first name and last name as arguments
	 * @param firstName the first name of the instructor
	 * @param lastName the last name of the instructor
	 */
	public Instructor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/***
	 * {@summary} sets the first name attribute to the given one
	 * @param firstName the first name of the instructor
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/***
	 * {@summary} sets the last name attribute to the given one
	 * @param lastName the last name of the instructor
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/***
	 * @return the instructor's first name
	 */
	@Override
	public String getFirstName() {
		return this.firstName;
	}

	/***
	 * @return the instructor's last name
	 */
	@Override
	public String getLastName() {
		return this.lastName;
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

}
