package model;

public class Student {
	private String id; // ��ʶid
	private String cardId; // ѧ��
	private String name; // ѧ������
	private int age; // ����

	private Certificate cer;// ���֤

	private Team team;// �༶

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

	public Certificate getCer() {
		return cer;
	}

	public void setCer(Certificate pass) {
		this.cer = pass;
	}

	/**
	 * @return ���� team��
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * @param team
	 *            Ҫ���õ� team��
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
}
