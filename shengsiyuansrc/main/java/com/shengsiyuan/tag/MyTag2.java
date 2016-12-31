package com.shengsiyuan.tag;

import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTag2 extends TagSupport
{
	private String key;
	
	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	@Override
	public int doEndTag() throws JspException
	{
		try
		{
			Properties ps = (Properties)this.pageContext.getAttribute("ps", PageContext.APPLICATION_SCOPE);
			
			String message = ps.getProperty(key);
			
			this.pageContext.getOut().println(message);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return EVAL_PAGE;
	}
}
