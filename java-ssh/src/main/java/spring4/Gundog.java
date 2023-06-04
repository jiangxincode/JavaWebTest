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
		return "我是一只叫" + getName() + "的猎犬，奔跑速度...";
	}

}
