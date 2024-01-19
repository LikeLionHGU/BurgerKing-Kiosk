package kiosk;

public class BurgerKingException {
  public static int checkValidationNumberInMain(int number) {
    if (number != 1 && number != 2 && number != 3 && number != 4 && number != 5) {
      throw new IllegalArgumentException("메뉴를 잘못 선택하셨습니다.");
    }
    return number;
  }

  public static int checkValidationNumberInMenu(int number, int length) {
    if (number > length) {
      throw new IllegalArgumentException("메뉴를 잘못 선택하셨습니다.");
    }
    return number;
  }
}
