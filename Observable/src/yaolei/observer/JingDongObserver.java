package yaolei.observer;

import java.util.Observable;
import java.util.Observer;

public class JingDongObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("�����յ���Ϣ:"+arg);
	}

}
