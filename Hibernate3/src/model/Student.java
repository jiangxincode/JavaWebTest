package model;

import java.util.Set;

public class Student {
	private String id; // 标识id

	private String cardId; // 学号
	private String name; // 学生姓名
	private int age; // 岁数

	private Set Courses;// 课程

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getCardId() {
		return cardId;
	}

	private void setId(String id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String stuName) {
		this.name = stuName;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getId() {
		return id;
	}

	public Student() { // 无参的构造函数
	}

	/**
	 * @return 返回 courses。
	 */
	public Set getCourses() {
		return Courses;
	}

	/**
	 * @param courses
	 *            要设置的 courses。
	 */
	public void setCourses(Set courses) {
		Courses = courses;
	}
}
