package lee.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Chinese implements Person {

	private List schools = new ArrayList<>();
	private Map score = new HashMap<>();
	private Properties health = new Properties();

	private Set axes = new HashSet<>();

	public Chinese() {
		System.out.println("Spring实例化主调bean：Chinese实例...");
	}

	public void setSchools(List l) {
		this.schools = l;
	}

	public void setHealth(Properties p) {
		this.health = p;
	}

	public void setScore(Map m) {
		this.score = m;
	}

	public void setAxes(Set s) {
		this.axes = s;
	}

	public void test() {
		System.out.println(schools);
		System.out.println(score);
		System.out.println(health);
		System.out.println(axes);
	}
}