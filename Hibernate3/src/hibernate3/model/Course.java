package hibernate3.model;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private String id;
	private String name;

	private Set Students = new HashSet();

	/**
	 * @return 返回 id。
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            要设置的 id。
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 返回 name。
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name。
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 返回 students。
	 */
	public Set getStudents() {
		return Students;
	}

	/**
	 * @param students
	 *            要设置的 students。
	 */
	public void setStudents(Set students) {
		Students = students;
	}
}
