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
		//JspFrament:��������������װ�˱�ǩ�������
		JspFragment jf = this.getJspBody();
		//invoke���������Խ�������������Ϊ
		//null,��ʾ�����Ĭ�ϵ������
		if(username.equals("zs")){
			out.println("hello");
			jf.invoke(null);
		}else{
			out.println("go out!" + username);
			//���������ǩ֮�������
			throw new SkipPageException();
		}
		
		
	}
	
}
