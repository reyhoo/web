package yaolei.observer;

import java.util.Observable;
import java.util.Observer;

public class TaobaoObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("�Ա��յ���Ϣ:"+arg);
	}
}
