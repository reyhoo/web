package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag2 extends SimpleTagSupport{
	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext();
		JspWriter out = pc.getOut();
		//JspFrament:由容器创建，封装了标签体的内容
		JspFragment jf = this.getJspBody();
		//invoke方法，可以接受输出流，如果为
		//null,表示输出到默认的输出流
		if(username.equals("zs")){
			out.println("hello");
			jf.invoke(null);
		}else{
			out.println("go out!" + username);
			//不再输出标签之后的内容
			throw new SkipPageException();
		}
		
		
	}
	
}
