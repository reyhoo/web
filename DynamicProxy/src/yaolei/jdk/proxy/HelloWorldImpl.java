package yaolei.jdk.proxy;

/**
 * ��ʵ����
 * @author yaolei
 *
 */
public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHello() {	
		System.out.println("Hello World"+System.currentTimeMillis());
	}

}
