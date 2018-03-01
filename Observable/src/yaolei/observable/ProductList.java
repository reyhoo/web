package yaolei.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {
	
	private List<String>productList = null;
	
	private static ProductList instance;
	
	private ProductList(){}
	
	public static ProductList getInstance(){
		if(instance == null){
			synchronized (ProductList.class) {
				if(instance == null){
					instance = new ProductList();
					instance.productList = new ArrayList<String>();
				}
			}
			
		}
		return instance;
	}
	
	public void addProductListObserver(Observer observer){
		this.addObserver(observer);
	}
	
	public void addProduct(String newProduct){
		productList.add(newProduct);
		System.out.println("list is changed added:"+newProduct);
		this.setChanged();
		this.notifyObservers(newProduct);
	}

}