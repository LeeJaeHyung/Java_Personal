package starbusck_kiosk.com.module;

public class Order {
	
	private String name;
	private String size;
	private int price;
	private int count;
	private String temp;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(String name,String size, int price, int count,String temp) {
		this.name = name;
		this.size = size;
		this.price = price;
		this.count = count;
		this.temp = temp;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "["+temp+"]"+ name +" "+ size + "사이즈 " + price + "원 " + count + "개";
	}
	
	
	
	
}
