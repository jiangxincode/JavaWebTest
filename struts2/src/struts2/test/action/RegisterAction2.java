package struts2.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import struts2.test.bean.User;

public class RegisterAction2 extends ActionSupport implements ModelDriven<User>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();

	public User getModel() {
		return user;
	}

	public void prepare() throws Exception {
		System.out.println("prepare");
	}

	@Override
	public String execute() throws Exception {
		System.out.println("execute");
		return SUCCESS;
	}
}
