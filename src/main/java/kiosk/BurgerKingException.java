package kiosk;

public class BurgerKingException {
  public static int checkValidationNumberAboutLength(int number, int length) {
    if (number > length) {
      throw new IllegalArgumentException("메뉴를 잘못 선택하셨습니다.");
    }
    return number;
  }
}
