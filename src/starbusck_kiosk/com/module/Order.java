package starbusck_kiosk.com.module;

import java.util.ArrayList;

public class Order {
	private ArrayList<Menu> OrderList;

	public ArrayList<Menu> getOrderList() {
		return OrderList;
	}

	public void setOrder(Menu menu) {
		if(OrderList!=null) {
			OrderList = new ArrayList<Menu>();
		}
		OrderList.add(menu);
	}
	
	public void cancle() {
		OrderList = null;
	}
	
}
