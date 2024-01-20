package kiosk;

public class MethodAboutShoppingBasket {
	public static void order() {
		System.out.println("주문이 성공적으로 되었습니다.");
		System.exit(0);
	}

	public static void controlCount(){
		System.out.println("===== 수량 조절하기 =====\n");
		System.out.println("현재 장바구니\n");
		for (Item it : Application.shoppingBasket) {
			System.out.println("- " + it.itemName + " " + it.count + "개");
		}
		System.out.println();
		System.out.print("수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
		int changeMenuIndex = ContactByUser.getIntByUser();
		System.out.print("변경할 수량을 입력하세요:");
		int chageCount = ContactByUser.getIntByUser();
		Application.shoppingBasket.get(changeMenuIndex-1).count = chageCount;
	}

	public static void cancelOrder(){
		System.out.println("===== 삭제하기 =====\n");
		System.out.println("현재 장바구니\n");
		for (Item it : Application.shoppingBasket) {
			System.out.println("- " + it.itemName + " " + it.count + "개");
		}
		System.out.println();
		System.out.print("삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
		int deleteIndex = ContactByUser.getIntByUser();
		System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
		int decideInputNum = ContactByUser.getIntByUser();

		if(decideInputNum == 0) return;
		else if(decideInputNum == 1) Application.shoppingBasket.remove(deleteIndex-1);
	}

	public static void addShoppingBasket(Item food){
		Application.shoppingBasket.add(new Item(food.itemName, food.price));
	}


}
