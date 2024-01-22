package kiosk;

import java.util.ArrayList;

public class MenuToArray {
	public static ArrayList<Item> addBurger(ArrayList<Item> burgerArrayList){
		burgerArrayList.add(new Item("와퍼", 6900));
		burgerArrayList.add(new Item("큐브 스테이크 와퍼", 8900));
		burgerArrayList.add(new Item("콰트로 치즈 와퍼", 7900));
		burgerArrayList.add(new Item("몬스터 와퍼", 9300));
		burgerArrayList.add(new Item("동새우 와퍼", 7900));
		burgerArrayList.add(new Item("블랙바베큐 와퍼", 9300));
		return burgerArrayList;
	}

	public static ArrayList<Item> addDrink(ArrayList<Item> drinkArrayList){
		drinkArrayList.add(new Item("코카콜라", 2000));
		drinkArrayList.add(new Item("코카콜라 제로", 2000));
		drinkArrayList.add(new Item("펩시", 2000));
		drinkArrayList.add(new Item("펩시 제로", 2000));
		drinkArrayList.add(new Item("스프라이트", 2000));
		drinkArrayList.add(new Item("스프라이트 제로", 2000));
		return drinkArrayList;
	}

	public static ArrayList<Item> addSide(ArrayList<Item> sideArrayList){
		sideArrayList.add(new Item("너겟킹", 2500));
		sideArrayList.add(new Item("해쉬 브라운", 1800));
		sideArrayList.add(new Item("치즈스틱", 1200));
		sideArrayList.add(new Item("어니언링", 2400));
		sideArrayList.add(new Item("바삭킹", 3000));
		sideArrayList.add(new Item("감자튀김", 2000));
		return sideArrayList;
	}
}
