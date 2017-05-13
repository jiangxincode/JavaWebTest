package hibernate3.model;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private String id;
	private String name;

	private Set Students = new HashSet();

	/**
	 * @return ���� id��
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            Ҫ���õ� id��
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return ���� name��
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Ҫ���õ� name��
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return ���� students��
	 */
	public Set getStudents() {
		return Students;
	}

	/**
	 * @param students
	 *            Ҫ���õ� students��
	 */
	public void setStudents(Set students) {
		Students = students;
	}
}
