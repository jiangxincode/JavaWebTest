package spring4;

public class Gundog implements Dog {

	private String name;

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String run() {
		return "����һֻ��" + getName() + "����Ȯ�������ٶ�...";
	}

}
