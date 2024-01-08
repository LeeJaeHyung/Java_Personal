package starbusck_kiosk.com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import starbusck_kiosk.com.module.Drink;
import starbusck_kiosk.com.module.Menu;
import starbusck_kiosk.com.module.Product;

public class ModuleMaker {

	public void make() throws IOException {
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("이름: ");
			String name = br.readLine();
			if (name.equals("그만")) {
				break;
			}
			System.out.println("");
			System.out.print("설명: ");
			String description = br.readLine();
			System.out.println("");
			String type = "drink";
			System.out.println("");
			String category = "병음료";
			FileOutputStream fos = new FileOutputStream("data/" + type + "/" + category + "/" + name + ".obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			if (type.equals("drink")) {
				System.out.print("사이즈 갯수 : ");
				int sizeCount = Integer.parseInt(br.readLine());
				System.out.println("");
				System.out.println("사이즈 명 : ");
				String[] size = new String[sizeCount];
				size = br.readLine().split("/");
				int[] price = new int[sizeCount];
				System.out.println("가격 : ");
				String[] priceStr = br.readLine().split(" ");
				for (int i = 0; i < sizeCount; i++) {
					price[i] = Integer.parseInt(priceStr[i]);
				}
				System.out.println("온도 :");
				String temperature = br.readLine();
				Menu d = new Drink(name, description, type, category, size, price,temperature);
				System.out.println(d.toString());
				try {
					oos.writeObject(d);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("가격 : ");
				int price = Integer.parseInt(br.readLine());
				Product p = new Product(name, description, price, type);
				System.out.println(p.toString());
				oos.writeObject(p);
			}
			oos.flush();
			oos.close();
			fos.close();

			System.out.println("=================================================");
			File f = new File("data/" + type + "/" + category + "/" + name + ".obj");
			if (f.exists()) {
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Menu m;
				try {
					m = (Menu) ois.readObject();
					if (m == null) {
						System.out.println("이거 널인데?");
					}
					System.out.println(m.getName());
					System.out.println(m.getDescription());
					System.out.println(((Drink)m).getType());
					System.out.println(((Drink)m).getCategory());
					System.out.println(((Drink)m).getSize().length);
					int size = ((Drink)m).getSize().length;
					String[] sizeName = ((Drink)m).getSize();
					int[] price = ((Drink)m).getPrice();
					for(int j = 0; j < size; j++) {
						System.out.print(sizeName[j]+" ");
						System.out.print(price[j]);
						System.out.print(", ");
					}
					System.out.println();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ois.close();
				fis.close();
			} else {
				System.out.println("파일 없음");
			}
		}
	}

}
