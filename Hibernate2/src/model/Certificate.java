package model;

public class Certificate {
	private String id;
	private String describe;

	private Student stu;

	/**
	 * @return ���� stu��
	 */
	public Student getStu() {
		return stu;
	}

	/**
	 * @param stu
	 *            Ҫ���õ� stu��
	 */
	public void setStu(Student stu) {
		this.stu = stu;
	}

	/**
	 * @return ���� describe��
	 */
	public String getDescribe() {
		return describe;
	}

	/**
	 * @param describe
	 *            Ҫ���õ� describe��
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}

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
}
