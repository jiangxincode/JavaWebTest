package lee.authority;

public class TestActionImpl implements TestAction {
	
	private TestService ts;
	
	

	public void setTs(TestService ts) {
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
