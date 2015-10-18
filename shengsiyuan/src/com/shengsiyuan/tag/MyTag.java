package com.shengsiyuan.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTag extends TagSupport
{
	@Override
	public int doStartTag() throws JspException
	{
		try
		{
			// ÏòÒ³ÃæÊä³ö×Ö·û´®
			this.pageContext.getOut().println("hello world");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException
	{
		try
		{
			this.pageContext.getOut().println("welcome");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}

}
