package lee.authority2;

public class TestActionImpl implements TestAction {
	
	private TestServiceImpl ts;
	
	

	public void setTs(TestServiceImpl ts) {
		this.ts = ts;
	}

	@Override
	public void modify() {
		ts.modify();

	}

	@Override
	public void view() {
		ts.view();

	}

}
