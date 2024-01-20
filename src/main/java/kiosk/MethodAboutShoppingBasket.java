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

		int changeMenuIndex = selectIndexByUser("수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
		if(changeMenuIndex == 0) return;

		System.out.print("변경할 수량을 입력하세요:");

		// todo: 이거 최대가 50인 걸로 exception처리 -> 글귀 "장바구니에 담을 수 있는 단일품목의 최대 수량은 50개, 최소 수량은 1개입니다. 주문을 처음부터 다시 해주시길 바랍니다." 하고 exception띄우기
		int chageCount = contactByUser.getIntByUser();
		Application.shoppingBasket.get(changeMenuIndex-1).count = chageCount;
	}

	// todo: ShoppingBasket에 아무것도 없는데, 삭제하려고 하면 error 띄워 (이건 수량 조절하기도 마찬가지임. 주문하기도 마찬가지임.)
	public void cancelOrder(){
		ContactByUser contactByUser = new ContactByUser();
		FunctionAboutFirstInput functionAboutFirstInput = new FunctionAboutFirstInput();

		System.out.println("===== 삭제하기 =====\n");
		System.out.println("현재 장바구니\n");
		functionAboutFirstInput.printShoppingBasket();;

		// todo: 여기서 ShoppingBasket.size()-1 더 큰 수 입력 시 error
		int deleteMenuIndex = selectIndexByUser("삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
		if(deleteMenuIndex == 0) return;

		int decideByUser = reconfirmByUser();
		if(decideByUser == 1) Application.shoppingBasket.remove(deleteMenuIndex-1);
	}

	public int reconfirmByUser(){
		ContactByUser contactByUser = new ContactByUser();
		CheckException checkException = new CheckException();

		System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
		int input = contactByUser.getIntByUser();

		checkException.checkReconfirmInputByUser(input);
		return input;
	}



	public int selectIndexByUser(String temp){
		ContactByUser contactByUser = new ContactByUser();

		System.out.print(temp);
		return contactByUser.getIntByUser();
  }

	public void addShoppingBasket(Item food){
		Application.shoppingBasket.add(new Item(food.itemName, food.price));
	}


}
