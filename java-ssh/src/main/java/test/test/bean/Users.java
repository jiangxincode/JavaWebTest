package test.test.bean;

import java.sql.Date;

public class Users
{
	private int id;
	
	private String username;
	
	private String password;
	
	private String truename;
	
	private Date birthday;
	
	private Date registerdate;
	
	private String sex;
	
	private String interest;
	
	private String remark;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getTruename()
	{
		return truename;
	}

	public void setTruename(String truename)
	{
		this.truename = truename;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public Date getRegisterdate()
	{
		return registerdate;
	}

	public void setRegisterdate(Date registerdate)
	{
		this.registerdate = registerdate;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getInterest()
	{
		return interest;
	}

	public void setInterest(String interest)
	{
		this.interest = interest;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	
}
