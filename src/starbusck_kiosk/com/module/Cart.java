package starbusck_kiosk.com.module;

import java.util.ArrayList;

public class Cart {

	private ArrayList<Order> orderList;

	public Cart() {
		orderList = new ArrayList<Order>();
	}
	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void addOrder(Order order) {
		orderList.add(order);
	}
	
	public void clearOrder() {
		orderList = new ArrayList<Order>();
	}
	
	public int printOrder() {
		int price = 0;
		for(Order order : orderList) {
			System.out.println(order);
			price += order.getPrice()*order.getCount();
		}
		System.out.println("총금액 = "+price+"원");
		
		return price;
	}
	
	
}
