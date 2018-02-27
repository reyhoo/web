package yaolei.observable;

import yaolei.observer.JingDongObserver;
import yaolei.observer.TaobaoObserver;

public class Test {
	
	public static void main(String[] args) {
		ProductList.getInstance().addProductListObserver(new JingDongObserver());
		ProductList.getInstance().addProductListObserver(new TaobaoObserver());
		
		ProductList.getInstance().addProduct("Mac Book");
		
	}

}
