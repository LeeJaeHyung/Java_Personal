package starbusck_kiosk.com.module;

import java.io.Serializable;

public class Product extends Menu implements Serializable{
	
	private int price;
	private String type;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, String description, int price, String type) {
		super.setName(name);
		super.setDescription(description);
		this.price = price;
		this.type = type;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
