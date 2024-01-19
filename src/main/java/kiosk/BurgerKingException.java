package kiosk;

public class BurgerKingException {
  public static int checkIsNumberBetween(int number, int min, int max) {
    if (number < min || number > max) {
      throw new IllegalArgumentException(min + " ~ " + max + " 사이의 숫자를 입력해야 합니다.");
    }
    return number;
  }
}
