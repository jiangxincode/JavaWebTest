package model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * 
 *         TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת�� ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class Team {
	private String id;
	private Set students = new HashSet();
	private String teamName;

	/**
	 * @return ���� tests��
	 */

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
	private void setId(String id) {
		this.id = id;
	}

	/**
	 * @return ���� groupName��
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param groupName
	 *            Ҫ���õ� groupName��
	 */
	public void setTeamName(String name) {
		this.teamName = name;
	}

	/**
	 * @return ���� students��
	 */
	public Set getStudents() {
		return students;
	}

	/**
	 * @param students
	 *            Ҫ���õ� students��
	 */
	public void setStudents(Set students) {
		this.students = students;
	}
}
