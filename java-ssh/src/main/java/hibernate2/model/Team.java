package hibernate2.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * 
 *         TODO 要更改此生成的类型注释的模板，请转至 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class Team {
	private String id;
	private Set students = new HashSet();
	private String teamName;

	/**
	 * @return 返回 tests。
	 */

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
	private void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 返回 groupName。
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param groupName
	 *            要设置的 groupName。
	 */
	public void setTeamName(String name) {
		this.teamName = name;
	}

	/**
	 * @return 返回 students。
	 */
	public Set getStudents() {
		return students;
	}

	/**
	 * @param students
	 *            要设置的 students。
	 */
	public void setStudents(Set students) {
		this.students = students;
	}
}
