package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport{
	private String info;
	private int num;
	
	public void setInfo(String info) {
		System.out.println("setInfo..." + info);
		this.info = info;
	}

	public void setNum(int num) {
		System.out.println("setNum..." + num);
		this.num = num;
	}

	public HelloTag() {
		System.out.println("constructor...");
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag...");
		JspContext jc = getJspContext();
		PageContext pc = (PageContext)jc;
		JspWriter out = pc.getOut();
		for(int i=0;i<num;i++){
		out.println(info+"<br/>");
		}
	}
	
}
