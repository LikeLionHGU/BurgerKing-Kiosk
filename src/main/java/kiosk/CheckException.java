package kiosk;

public class CheckException {
	public void checkInputRange(int selectInt){
		if(selectInt < FunctionAboutFirstInput.MinInputNum || FunctionAboutFirstInput.MaxInputNum < selectInt) throw new IllegalArgumentException("잘못된 메뉴를 선택하셨습니다.");
	}

	public void checkReconfirmInputByUser(int input){
		if((input != 0) && (input != 1)) throw new IllegalArgumentException("삭제 재확인 부분에서 잘못된 입력을 하셨습니다.");
	}

	public void checkSelectIndexByUserRange(int index){
		if(index < 0 || Application.shoppingBasket.size() < index ) throw new IllegalArgumentException("메뉴 번호를 잘못 입력하셨습니다. 처음 주문창으로 돌아갑니다.");
	}

	public void checkCountByUserRange(int changeCount){
		if(changeCount < 1 || 50 < changeCount) throw new IllegalArgumentException("장바구니에 담을 수 있는 단일품목의 최대 수량은 50개, 최소 수량은 1개입니다. 주문을 처음부터 다시 해주시길 바랍니다.");
	}

}
