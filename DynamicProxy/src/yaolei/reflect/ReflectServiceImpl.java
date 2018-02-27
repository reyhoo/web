package yaolei.reflect;

public class ReflectServiceImpl {

	private String msg;

	public ReflectServiceImpl() {

	}

	public ReflectServiceImpl(String msg) {
		this.msg = msg;
	}

	public void sayHello() {
		System.out.println("hello:" + (msg != null ? msg : "anybody"));
	}
}
