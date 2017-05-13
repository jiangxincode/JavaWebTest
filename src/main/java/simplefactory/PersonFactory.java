package simplefactory;

public class PersonFactory {
	public Person getPerson(String ethnic) {
		if (ethnic.equalsIgnoreCase("chinese")) {
			return new Chinese();
		} else {
			return new American();
		}

	}
}
