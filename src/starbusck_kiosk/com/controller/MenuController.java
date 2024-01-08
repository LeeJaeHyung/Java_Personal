package starbusck_kiosk.com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.StringTokenizer;

import starbusck_kiosk.com.module.Cart;
import starbusck_kiosk.com.module.Drink;
import starbusck_kiosk.com.module.Menu;
import starbusck_kiosk.com.module.Order;

public class MenuController {

	private Cart cart = new Cart();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void run() throws IOException {
		choiceOfCategory();
	}
	
	public void choiceOfCategory()throws IOException {
		File file = new File("data/drink");
		String[] list = file.list();
		
		while(true) {
			String dirKey = null;
			System.out.println("Starbucks에 오신걸 환영합니다\n음료의 카테고리를 선택해주세요!");
			System.out.println("\n[카테고리]");
			for(int i = 0; i < list.length; i++) {
				System.out.println((i+1)+"."+list[i]);
			}
			System.out.println("\n"+(list.length+1)+".Order");
			System.out.println((list.length+2)+".Cancel");
			System.out.println("");
			System.out.print("\n입력 : ");
			try {
				int key = Integer.parseInt(br.readLine())-1;
				if(0<=key && key<15) {
					dirKey = list[key];
					clearConsole();
					choiceOfDrink(dirKey);
					clearConsole();
					continue;
				}else if(key == list.length){
					if(cart.getOrderList().size()==0) {
						System.out.println("주문 내역이 없습니다.");
					}else {
						cart.printOrder();
					}
				}else if(key == list.length+1 ) {
					System.out.println("주문내역이 초기화 되었습니다.");
					cart.clearOrder();
				}else if(key == list.length+2){
					System.out.println("==================== 종료합니다.================================");
					break;
				}else {
					clearConsole();
					System.out.print("!!!!!!! 입력을 확인해주세요.!!!!!!!");
					continue;
				}
			}catch(Exception e) {
				clearConsole();
				System.out.print("!!!!!!!숫자만 입력해주세요.!!!!!!!");
				continue;
			}
		}
	}
	
	public void choiceOfDrink(String dirKey) {
		File file = new File("data/drink/"+dirKey);
		String[] list = file.list();
		
		while(true) {
			System.out.println("["+dirKey+"]");
			for(int i = 0; i < list.length; i++) {
				System.out.println((i+1)+"."+list[i].replace(".obj", ""));
			}
			System.out.print("\n"+(list.length+1)+".뒤로가기 \n입력 : ");
			try {
				int key = Integer.parseInt(br.readLine())-1;
				if(0<=key && key<list.length) {
					clearConsole();
					File[] fileList = file.listFiles();
					FileInputStream fis = new FileInputStream(fileList[key]);
					ObjectInputStream ois = new ObjectInputStream(fis);
					Menu m;
					try {
						m = (Drink) ois.readObject();
						if (m == null) {
							System.out.println("파일의 정보가 잘못되었습니다.");
						}
						System.out.println("["+m.getName()+"]\n");
						StringTokenizer st = new StringTokenizer(m.getDescription(),"\\n"); 
						int loopSize = st.countTokens();
						for(int j = 0; j<loopSize; j++) {
							System.out.println(st.nextToken());
						}
						System.out.println("\n"+((Drink)m).getTemperature()+"\n\n<사이즈>");
						int size = ((Drink)m).getSize().length;
						String[] sizeName = ((Drink)m).getSize();
						int[] price = ((Drink)m).getPrice();
						for(int j = 0; j < size; j++) {
							if(j!=0) {
								System.out.print("\n");
							}
							System.out.print(sizeName[j]+"\t");
							System.out.print(price[j]+"원");
						}
						System.out.print("\n\n1.선택\n2.뒤로가기\n3.장바구니 확인 \n입력: ");
						int choose = Integer.parseInt(br.readLine());
						switch(choose){
						case 1: 
							clearConsole(); ois.close(); fis.close(); 
							Order order = choiceOfSize(m,choiceOfTemp(m));
							System.out.println("\n[주문상품]"+order);
							System.out.println("");
							System.out.println("추가 주문을 하시겠습니까?");
							System.out.print("입력 [y/n]:");
							String answer = br.readLine();
							if(answer.equals("y")) {
								cart.addOrder(order);
							}
							clearConsole();
							break;
						case 2: 
							clearConsole(); ois.close(); fis.close(); 
							choiceOfDrink(dirKey); break;
						case 3: 
							clearConsole(); ois.close(); fis.close(); break;
						}
		
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}else if(key == list.length){
					// 다른 기능 키
					clearConsole();
					choiceOfCategory();
					break;
				}else{
					clearConsole();
					System.out.print("!!!!!!! 입력을 확인해주세요.!!!!!!!");
					continue;
				}
			} catch (Exception e) {
				System.out.println("!!!!!!!숫자만 입력해주세요.!!!!!!!");
				continue;
			}
			
			
		}
		
		
	}
	
	public void clearConsole() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public Order choiceOfSize(Menu m, String temp) throws NumberFormatException, IOException {
		Drink menu = (Drink)m;
		System.out.println("사이즈 선택");
		int sizeCount = (menu.getSize().length);
		for(int i = 0; i < sizeCount; i++) {
			System.out.print((i+1)+"."+menu.getSize()[i]);
			System.out.println(menu.getPrice()[i]+"원");
		}
		System.out.print("입력 : ");
		int key = Integer.parseInt(br.readLine());
		
		System.out.println("수량을 입력해 주세요");
		System.out.print("입력 : ");
		int count = Integer.parseInt(br.readLine());
		return new Order(menu.getName(), menu.getSize()[key-1],menu.getPrice()[key-1], count, temp);
		
	}
	
	public String choiceOfTemp(Menu m) throws NumberFormatException, IOException {
		Drink menu = (Drink)m;
		String temp = menu.getTemperature();
		if(temp.equals("ICED HOT")||temp.equals("ICED/HOT")) {
			System.out.println("온도를 선택해 주세요.");
			System.out.println("1.ICED 2.HOT");
			System.out.print("입력 : ");
			int key = Integer.parseInt(br.readLine());
			switch(key) {
			case 1: return "ICED";
			case 2: return "HOT";
			}
		}else {
			if(temp.equals("ICED ONLY")) {
				return "ICED";
			}else if(temp.equals("HOT ONLY")) {
				return "HOT";
			}else {
				return "보틀";
			}
		}
		return temp;
	}
}
