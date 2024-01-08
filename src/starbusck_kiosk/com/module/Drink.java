package starbusck_kiosk.com.module;

import java.io.Serializable;

public class Drink  extends Menu implements Serializable{
	
	private String category;
	private String type;
	private String[] size;
	private int[] price;
	private String temperature;
	
	public Drink() {
		// TODO Auto-generated constructor stub
	}
	
	public Drink(String name, String description, String type,String category, String[] size, int[] price, String temperature) {
		super.setName(name);
		super.setDescription(description);
		this.type = type;
		this.category = category;
		this.price = price;
		this.size = size;
		this.temperature =temperature;
	}
	
	public int[] getPrice() {
		return price;
	}

	public void setPrice(int[] price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getSize() {
		return size;
	}

	public void setSize(String[] size) {
		this.size = size;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
