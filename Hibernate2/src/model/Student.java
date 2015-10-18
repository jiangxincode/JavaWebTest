package model;

public class Student {
	private String id; // 标识id
	private String cardId; // 学号
	private String name; // 学生姓名
	private int age; // 岁数

	private Certificate cer;// 身分证

	private Team team;// 班级

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

	public Certificate getCer() {
		return cer;
	}

	public void setCer(Certificate pass) {
		this.cer = pass;
	}

	/**
	 * @return 返回 team。
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * @param team
	 *            要设置的 team。
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
}
