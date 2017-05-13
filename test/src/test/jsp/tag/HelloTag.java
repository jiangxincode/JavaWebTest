package test.jsp.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelloTag() {

	}

	public int doStartTag() throws JspException {
		try {
			this.pageContext.getOut().print("nihao");
		} catch (Exception ex) {
			throw new JspTagException(ex.getMessage());
		}
		return EVAL_BODY_INCLUDE;
	}

	// Method called when the closing hello tag is encountered
	public int doEndTag() throws JspException {
		try {
			// We use the pageContext to get a Writer
			// We then print the text string Hello
			this.pageContext.getOut().print("Hello");
		} catch (Exception e) {

			throw new JspTagException(e.getMessage());
		}
		return EVAL_PAGE;
	}

	public void release() {

		// Call the parent's release to release any resources
		// used by the parent tag.
		// This is just good practice for when you start creating
		// hierarchies of tags.
		super.release();
	}
}