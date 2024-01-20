package kiosk;

public class MethodAboutShoppingBasket {
	public void order() {
		System.out.println("주문이 성공적으로 되었습니다.");
		System.exit(0);
	}

	public void controlCount(){
		ContactByUser contactByUser = new ContactByUser();
		FunctionAboutFirstInput functionAboutFirstInput = new FunctionAboutFirstInput();

		System.out.println("===== 수량 조절하기 =====\n");
		System.out.println("현재 장바구니\n");
		functionAboutFirstInput.printShoppingBasket();;

		int changeMenuIndex = contactByUser.selectIndexByUser("수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
		if(changeMenuIndex == 0) return;

		getChangeMenuCountByUser(changeMenuIndex);
	}

	public void getChangeMenuCountByUser(int changeMenuIndex){
		ContactByUser contactByUser = new ContactByUser();
		CheckException checkException = new CheckException();

		System.out.print("변경할 수량을 입력하세요:");
		int chageCount = contactByUser.getIntByUser();

		checkException.checkCountByUserRangeMax(chageCount);
		checkException.checkCountByUserRangeMin(chageCount);

		Application.shoppingBasket.get(changeMenuIndex-1).count = chageCount;

	}


	public void cancelOrder(){
		ContactByUser contactByUser = new ContactByUser();
		FunctionAboutFirstInput functionAboutFirstInput = new FunctionAboutFirstInput();

		System.out.println("===== 삭제하기 =====\n");
		System.out.println("현재 장바구니\n");
		functionAboutFirstInput.printShoppingBasket();;

		int deleteMenuIndex = contactByUser.selectIndexByUser("삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
		if(deleteMenuIndex == 0) return;

		int decideByUser = contactByUser.reconfirmByUser();
		if(decideByUser == 1) Application.shoppingBasket.remove(deleteMenuIndex-1);
	}

	public void addShoppingBasket(Item food){
		Application.shoppingBasket.add(new Item(food.itemName, food.price));
	}

}
