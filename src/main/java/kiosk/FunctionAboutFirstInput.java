package kiosk;

import java.util.ArrayList;

public class FunctionAboutFirstInput {
	public static final int MinInputNum = 0;
	public static final int MaxInputNum = 6;
	public void printHome(){
		System.out.println("=====홈=====");
		System.out.println("1. 햄버거");
		System.out.println("2. 사이드");
		System.out.println("3. 음료");
		System.out.println("4. 장바구니");
		System.out.println("5. 종료\n");
		System.out.print("메뉴선택:");
	}

	public static void printBurgerMenu(ArrayList<Item> burger) {
		System.out.println("=====햄버거 메뉴=====");
		System.out.println("1. 와퍼 (6900원)");
		System.out.println("2. 큐브 스테이크 와퍼 (8900원)");
		System.out.println("3. 콰트로 치즈 와퍼 (7900원)");
		System.out.println("4. 몬스터 와퍼 (9300원)");
		System.out.println("5. 통새우 와퍼 (7900원)");
		System.out.println("6. 블랙바베큐 와퍼 (9300원)\n");
		System.out.print("메뉴선택 (0을 선택 시 홈으로): ");

		int selectInt = ContactByUser.getIntByUser();
		CheckException.checkInputRange(selectInt);

		if(selectInt == MinInputNum)  return;

		boolean isBurgerExist = false;
		for(int i = 0 ; i < Application.shoppingBasket.size(); i++){
			if(burger.get(selectInt-1).itemName.equals(Application.shoppingBasket.get(i).itemName)){
				Application.shoppingBasket.get(i).count++;
				isBurgerExist = true;
				break;
			}
		}

		if(!isBurgerExist) {
			Item selectSide = new Item(burger.get(selectInt-1).itemName, burger.get(selectInt-1).price);
			MethodAboutShoppingBasket.addShoppingBasket(selectSide);
		}

		System.out.println("선택하신 메뉴가 정상적으로 추가되었습니다.\n");
	}

	public static void printSideMenu(ArrayList<Item> side) {
		System.out.println("=====사이드 메뉴=====");
		System.out.println("1. 너겟킹 (2500원)");
		System.out.println("2. 해쉬 브라운 (1800원)");
		System.out.println("3. 치즈스틱 (1200원)");
		System.out.println("4. 어니언링 (2400원)");
		System.out.println("5. 바삭킹 (3000원)");
		System.out.println("6. 감자튀김 (2000원)\n");
		System.out.print("메뉴선택 (0을 선택 시 홈으로):");

		int selectInt = ContactByUser.getIntByUser();
		CheckException.checkInputRange(selectInt);

		if(selectInt == MinInputNum)  return;

		boolean isSideExist = false;
		for(int i = 0 ; i < Application.shoppingBasket.size(); i++){
			if(side.get(selectInt-1).itemName.equals(Application.shoppingBasket.get(i).itemName)){
				Application.shoppingBasket.get(i).count++;
				isSideExist = true;
				break;
			}
		}

		if(!isSideExist) {
			Item selectSide = new Item(side.get(selectInt-1).itemName, side.get(selectInt-1).price);
			MethodAboutShoppingBasket.addShoppingBasket(selectSide);
		}

		System.out.println("선택하신 메뉴가 정상적으로 추가되었습니다.\n");
	}

	public static void printDrinkMenu(ArrayList<Item> drink) {
		System.out.println("=====음료 메뉴=====");
		System.out.println("1. 코카콜라 (2000원)");
		System.out.println("2. 코카콜라 제로 (2000원)");
		System.out.println("3. 펩시 (2000원)");
		System.out.println("4. 펩시 제로 (2000원)");
		System.out.println("5. 스프라이트 (2000원)");
		System.out.println("6. 스프라이트 제로 (2000원)");
		System.out.print("메뉴선택 (0을 선택 시 홈으로):");

		int selectInt = ContactByUser.getIntByUser();
		CheckException.checkInputRange(selectInt);

		if(selectInt == MinInputNum)  return;

		boolean isDrinkExist = false;
		for(int i = 0 ; i < Application.shoppingBasket.size(); i++){
			if(drink.get(selectInt-1).itemName.equals(Application.shoppingBasket.get(i).itemName)){
				Application.shoppingBasket.get(i).count++;
				isDrinkExist = true;
				break;
			}
		}

		if(!isDrinkExist) {
			Item selectSide = new Item(drink.get(selectInt-1).itemName, drink.get(selectInt-1).price);
			MethodAboutShoppingBasket.addShoppingBasket(selectSide);
		}

		System.out.println("선택하신 메뉴가 정상적으로 추가되었습니다.\n");
	}

	public static void shoppingBasketOption() {
		int total = 0;
		System.out.println("===== 장바구니 =====\n");
		for(Item it : Application.shoppingBasket){
			System.out.println("- " + it.itemName + " " + it.count + "개");
			total += (it.count * it.price);
		}
		System.out.println();
		System.out.println("====================");
		System.out.println("1. 주문하기");
		System.out.println("2. 수량 조절하기");
		System.out.println("3. 삭제하기\n");

		System.out.println("총 가격 :  " + total + "원\n");
		System.out.print("메뉴 선택 (0을 선택 시 홈으로): ");
		int selectInt = ContactByUser.getIntByUser();
		if(selectInt == MinInputNum)  return;

		switch(selectInt){
			case 1 -> MethodAboutShoppingBasket.order();
			case 2 -> MethodAboutShoppingBasket.controlCount();
			case 3 -> MethodAboutShoppingBasket.cancelOrder();
			default -> throw new IllegalArgumentException("장바구니 부분에서 잘못된 값을 입력하셨습니다.");
		}
	}

	public static void exitProgram() {
		System.out.println("프로그램을 종료하겠습니다.");
		System.exit(0);
	}
}
