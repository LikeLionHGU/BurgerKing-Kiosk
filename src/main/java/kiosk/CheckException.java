package kiosk;

public class CheckException {
	public void checkInputRange(int selectInt){
		if(selectInt < FunctionAboutFirstInput.MinInputNum || FunctionAboutFirstInput.MaxInputNum < selectInt) throw new IllegalArgumentException("잘못된 메뉴를 선택하셨습니다.");
	}

}
