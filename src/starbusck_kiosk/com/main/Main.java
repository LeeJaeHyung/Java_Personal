package starbusck_kiosk.com.main;

import java.io.IOException;

import starbusck_kiosk.com.controller.MenuController;

public class Main {
	public static void main(String[] args) throws IOException{
		new MenuController().run();
	}
}
