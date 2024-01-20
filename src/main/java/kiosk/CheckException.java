package kiosk;

public class CheckException {
	public void checkInputRange(int selectInt){
		if(selectInt < FunctionAboutFirstInput.MinInputNum || FunctionAboutFirstInput.MaxInputNum < selectInt) throw new IllegalArgumentException("잘못된 메뉴를 선택하셨습니다.");
	}

	public void checkReconfirmInputByUser(int input){
		if((input != 0) && (input != 1)) throw new IllegalArgumentException("삭제 재확인 부분에서 잘못된 입력을 하셨습니다.");
	}
}
