package test.jsp.tag;

import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class MessageTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key = null;

	public MessageTag() {
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	// Method called when the closing hello tag is encountered
	public int doEndTag() throws JspException {
		try {
			Properties ps = (Properties) pageContext.getAttribute("ps", PageContext.APPLICATION_SCOPE);
			String message = (String) ps.get(key);
			pageContext.getOut().print(message);
		} catch (Exception e) {
			throw new JspTagException(e.getMessage());
		}

		return EVAL_PAGE;
	}

	public void release() {
		super.release();
	}

}