package kiosk;

import java.util.Scanner;

public class ContactByUser {
	public int getIntByUser(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public int selectIndexByUser(String message){
		ContactByUser contactByUser = new ContactByUser();
		CheckException checkException = new CheckException();

		System.out.print(message);

		int index = contactByUser.getIntByUser();
		checkException.checkSelectIndexByUserRange(index);

		return index;
	}

	public int reconfirmByUser(){
		ContactByUser contactByUser = new ContactByUser();
		CheckException checkException = new CheckException();

		System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
		int input = contactByUser.getIntByUser();
		checkException.checkReconfirmInputByUser(input);

		return input;
	}
}
