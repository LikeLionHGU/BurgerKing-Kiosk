package kiosk;

import java.util.ArrayList;

public class Run {
	public void runProgram(ArrayList<Item> burgerArrayList, ArrayList<Item> sideArrayList, ArrayList<Item> drinkArrayList){
		FunctionAboutFirstInput functionAboutFirstInput = new FunctionAboutFirstInput();
		ContactByUser contactByUser = new ContactByUser();

		int input = contactByUser.getIntByUser();
		switch(input){
			case 1 -> functionAboutFirstInput.printBurgerMenu(burgerArrayList);
			case 2 -> functionAboutFirstInput.printSideMenu(sideArrayList);
			case 3 -> functionAboutFirstInput.printDrinkMenu(drinkArrayList);
			case 4 -> functionAboutFirstInput.shoppingBasketOption();
			case 5 -> functionAboutFirstInput.exitProgram();
			default -> throw new IllegalArgumentException("잘못된 입력으로 인해 프로그램을 종료합니다.");
		}
	}
}
