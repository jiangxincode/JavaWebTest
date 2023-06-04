package lee.authority;

public class TestServiceImpl implements TestService {

	@Override
	public void view() {
		System.out.println("用户查看数据");

	}

	@Override
	public void modify() {
		System.out.println("用户修改数据");

	}

}
