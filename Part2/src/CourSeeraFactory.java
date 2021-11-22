import java.util.List;

//NOT COMPLETED YET, TO BE SUBMITTED NEXT MONDAY

public class CourSeeraFactory implements ICourSeeraFactory {
	/***
	 * {@summary} creates a CourSeera instance
	 * @param courses a list of all courses given
	 * @return a new CourSeera instance
	 */
	@Override
	public ICourSeera createInstance(List<ICourse> courses) {
		// TODO Auto-generated method stub
		return new CourSeera(courses);
	}

}
