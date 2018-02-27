package yaolei.observer;

import java.util.Observable;
import java.util.Observer;

public class TaobaoObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("淘宝收到消息:"+arg);
	}
}
