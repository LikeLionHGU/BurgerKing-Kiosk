package kiosk;

public class MethodAboutShoppingBasket {
	public void order() {
		System.out.println("주문이 성공적으로 되었습니다.");
		System.exit(0);
	}

	public void controlCount(){
		ContactByUser contactByUser = new ContactByUser();

		System.out.println("===== 수량 조절하기 =====\n");
		System.out.println("현재 장바구니\n");
		for (Item it : Application.shoppingBasket) {
			System.out.println("- " + it.itemName + " " + it.count + "개");
		}
		System.out.println();
		System.out.print("수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
		int changeMenuIndex = contactByUser.getIntByUser();
		System.out.print("변경할 수량을 입력하세요:");
		int chageCount = contactByUser.getIntByUser();
		Application.shoppingBasket.get(changeMenuIndex-1).count = chageCount;
	}

	public void cancelOrder(){
		ContactByUser contactByUser = new ContactByUser();

		System.out.println("===== 삭제하기 =====\n");
		System.out.println("현재 장바구니\n");
		for (Item it : Application.shoppingBasket) {
			System.out.println("- " + it.itemName + " " + it.count + "개");
		}
		System.out.println();
		System.out.print("삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
		int deleteIndex = contactByUser.getIntByUser();
		System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
		int decideInputNum = contactByUser.getIntByUser();

		if(decideInputNum == 0) return;
		else if(decideInputNum == 1) Application.shoppingBasket.remove(deleteIndex-1);
	}

	public void addShoppingBasket(Item food){
		Application.shoppingBasket.add(new Item(food.itemName, food.price));
	}


}
