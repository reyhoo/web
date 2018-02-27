package yaolei.jdk.proxy;

/**
 * 真实对象
 * @author yaolei
 *
 */
public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHello() {	
		System.out.println("Hello World"+System.currentTimeMillis());
	}

}
