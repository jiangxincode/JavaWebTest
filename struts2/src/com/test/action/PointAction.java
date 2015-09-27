package com.test.action;

import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.Point;

public class PointAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Point point;
	//
	// private Point point2;
	//

	// private List<Point> point;

	private String username;

	private int age;

	private Date birthday;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	//
	//
	// public Point getPoint2()
	// {
	// return point2;
	// }
	//
	// public void setPoint2(Point point2)
	// {
	// this.point2 = point2;
	// }

	// public List<Point> getPoint()
	// {
	// return point;
	// }
	//
	// public void setPoint(List<Point> point)
	// {
	// this.point = point;
	// }

	public String test() throws Exception {
		System.out.println("test invoked");

		System.out.println("x: " + point.getX());
		System.out.println("y: " + point.getY());

		return SUCCESS;
	}

	public String execute() throws Exception {
		System.out.println("x: " + point.getX());
		System.out.println("y: " + point.getY());

		return SUCCESS;
	}
}
