package hibernate1.model;

public class Certificate {
	private String id;

	private String describe;

	private Student stu;

	/**
	 * @return 返回 stu。
	 */
	public Student getStu() {
		return stu;
	}

	/**
	 * @param stu
	 *            要设置的 stu。
	 */
	public void setStu(Student stu) {
		this.stu = stu;
	}

	/**
	 * @return 返回 describe。
	 */
	public String getDescribe() {
		return describe;
	}

	/**
	 * @param describe
	 *            要设置的 describe。
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}

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
}
