package model;

import java.util.Set;

public class Student {
	private String id; // ��ʶid

	private String cardId; // ѧ��
	private String name; // ѧ������
	private int age; // ����

	private Set Courses;// �γ�

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

	public Student() { // �޲εĹ��캯��
	}

	/**
	 * @return ���� courses��
	 */
	public Set getCourses() {
		return Courses;
	}

	/**
	 * @param courses
	 *            Ҫ���õ� courses��
	 */
	public void setCourses(Set courses) {
		Courses = courses;
	}
}
