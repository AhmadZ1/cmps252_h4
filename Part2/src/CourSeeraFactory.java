import java.util.List;

public class CourSeeraFactory implements ICourSeeraFactory {

	@Override
	public ICourSeera createInstance(List<ICourse> courses) {
		// TODO Auto-generated method stub
		return new CourSeera(courses);
	}

}
