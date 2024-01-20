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

	public void printBurgerMenu(ArrayList<Item> burger) {
		ContactByUser contactByUser = new ContactByUser();
		CheckException checkException = new CheckException();

		System.out.println("=====햄버거 메뉴=====");
		System.out.println("1. 와퍼 (6900원)");
		System.out.println("2. 큐브 스테이크 와퍼 (8900원)");
		System.out.println("3. 콰트로 치즈 와퍼 (7900원)");
		System.out.println("4. 몬스터 와퍼 (9300원)");
		System.out.println("5. 통새우 와퍼 (7900원)");
		System.out.println("6. 블랙바베큐 와퍼 (9300원)\n");
		System.out.print("메뉴선택 (0을 선택 시 홈으로): ");

		int selectInt = contactByUser.getIntByUser();
		checkException.checkInputRange(selectInt);

		if(selectInt == MinInputNum)  return;

		editCountInShoppingBasket(burger, selectInt);

		System.out.println("선택하신 메뉴가 정상적으로 추가되었습니다.\n");
	}

	public void printSideMenu(ArrayList<Item> side) {
		ContactByUser contactByUser = new ContactByUser();
		CheckException checkException = new CheckException();
		MethodAboutShoppingBasket methodAboutShoppingBasket = new MethodAboutShoppingBasket();

		System.out.println("=====사이드 메뉴=====");
		System.out.println("1. 너겟킹 (2500원)");
		System.out.println("2. 해쉬 브라운 (1800원)");
		System.out.println("3. 치즈스틱 (1200원)");
		System.out.println("4. 어니언링 (2400원)");
		System.out.println("5. 바삭킹 (3000원)");
		System.out.println("6. 감자튀김 (2000원)\n");
		System.out.print("메뉴선택 (0을 선택 시 홈으로):");

		int selectInt = contactByUser.getIntByUser();
		checkException.checkInputRange(selectInt);

		if(selectInt == MinInputNum)  return;

		editCountInShoppingBasket(side, selectInt);

		System.out.println("선택하신 메뉴가 정상적으로 추가되었습니다.\n");
	}

	public void printDrinkMenu(ArrayList<Item> drink) {
		ContactByUser contactByUser = new ContactByUser();
		CheckException checkException = new CheckException();
		MethodAboutShoppingBasket methodAboutShoppingBasket = new MethodAboutShoppingBasket();

		System.out.println("=====음료 메뉴=====");
		System.out.println("1. 코카콜라 (2000원)");
		System.out.println("2. 코카콜라 제로 (2000원)");
		System.out.println("3. 펩시 (2000원)");
		System.out.println("4. 펩시 제로 (2000원)");
		System.out.println("5. 스프라이트 (2000원)");
		System.out.println("6. 스프라이트 제로 (2000원)");
		System.out.print("메뉴선택 (0을 선택 시 홈으로):");

		int selectInt = contactByUser.getIntByUser();
		checkException.checkInputRange(selectInt);

		if(selectInt == MinInputNum)  return;

		editCountInShoppingBasket(drink, selectInt);

		System.out.println("선택하신 메뉴가 정상적으로 추가되었습니다.\n");
	}

	public void shoppingBasketOption() {
		ContactByUser contactByUser = new ContactByUser();
		MethodAboutShoppingBasket methodAboutShoppingBasket = new MethodAboutShoppingBasket();

		System.out.println("===== 장바구니 =====");

		printShoppingBasket();
		int total = calculateTotal();


		System.out.println("1. 주문하기");
		System.out.println("2. 수량 조절하기");
		System.out.println("3. 삭제하기\n");
		System.out.println("총 가격 :  " + total + "원\n");
		System.out.print("메뉴 선택 (0을 선택 시 홈으로): ");

		int selectInt = contactByUser.getIntByUser();
		if(selectInt == MinInputNum)  return;

		switch(selectInt){
			case 1 -> methodAboutShoppingBasket.order();
			case 2 -> methodAboutShoppingBasket.controlCount();
			case 3 -> methodAboutShoppingBasket.cancelOrder();
			default -> throw new IllegalArgumentException("장바구니 옵션 선택 부분에서 잘못된 값을 입력하셨습니다.");
		}
	}

	public void printShoppingBasket(){
		int index = 1;
		for(Item FoodInShoppingBasket : Application.shoppingBasket){
			System.out.println(index + " - " + FoodInShoppingBasket.itemName + " " + FoodInShoppingBasket.count + "개");
			index++;
		}
		System.out.println();
		System.out.println("====================\n");
	}

	public int calculateTotal(){
		int total = 0;
		for (Item FoodInShoppingBasket : Application.shoppingBasket) {
			total += (FoodInShoppingBasket.count * FoodInShoppingBasket.price);
		}
		return total;
	}

	// ToDo: 물품이 선택되었으면, 해당 물품 count 확인. ->  개수가 50개가 넘어가면 "단일 물품의 최대 수량은 50개입니다. 처음부터 주문을 다시 해주세요." 라는 exception 처리 해주기
	public void editCountInShoppingBasket(ArrayList<Item> food, int selectInt){
		MethodAboutShoppingBasket methodAboutShoppingBasket = new MethodAboutShoppingBasket();

		boolean isFoodExist = false;
		for(int i = 0 ; i < Application.shoppingBasket.size(); i++){
			if(food.get(selectInt-1).itemName.equals(Application.shoppingBasket.get(i).itemName)){
				Application.shoppingBasket.get(i).count++;
				isFoodExist = true;
				break;
			}
		}

		if(!isFoodExist) {
			Item selectSide = new Item(food.get(selectInt-1).itemName, food.get(selectInt-1).price);
			methodAboutShoppingBasket.addShoppingBasket(selectSide);
		}
	}

	public void exitProgram() {
		System.out.println("프로그램을 종료하겠습니다.");
		System.exit(0);
	}
}
