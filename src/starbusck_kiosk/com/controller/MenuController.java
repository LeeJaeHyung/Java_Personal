package starbusck_kiosk.com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.StringTokenizer;

import starbusck_kiosk.com.module.Drink;
import starbusck_kiosk.com.module.Menu;
import starbusck_kiosk.com.module.Order;

public class MenuController {

	private Order order = new Order();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void run() throws IOException {
		choiceOfCategory();
	}
	
	public void choiceOfCategory()throws IOException {
		File file = new File("data/drink");
		String[] list = file.list();
		System.out.println("Starbucks에 오신걸 환영합니다\n음료의 카테고리를 선택해주세요!");
		String dirKey = null;
		
		
		while(true) {
			System.out.println("\n[카테고리]");
			for(int i = 0; i < list.length; i++) {
				System.out.println((i+1)+"."+list[i]);
			}
			System.out.println((list.length+1)+".종료");
			System.out.print("\n입력 : ");
			try {
				int key = Integer.parseInt(br.readLine())-1;
				System.out.println(key);
				System.out.println((list.length));
				if(0<=key && key<15) {
					dirKey = list[key];
					break;
				}else if(key == list.length){
					//종료
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
		clearConsole();
		if(dirKey!=null) {
			choiceOfDrink(dirKey);
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
						System.out.println("\n"+((Drink)m).getTemperature());
						int size = ((Drink)m).getSize().length;
						String[] sizeName = ((Drink)m).getSize();
						int[] price = ((Drink)m).getPrice();
						for(int j = 0; j < size; j++) {
							System.out.print("\n"+(j+1)+"."+sizeName[j]+" ");
							System.out.print(price[j]);
							if(j!=size-1) {
								System.out.print(", ");
							}
						}
						System.out.println();
						
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
}
