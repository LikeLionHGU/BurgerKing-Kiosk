package kiosk;

import java.util.Scanner;

public class Input {

  Scanner scanner = new Scanner(System.in);

  private int decision;
  private int hamburgerOrder;

  private int sidemeunOrder;

  private int drinkOrder;
  private int shoppingOption;
  private final int MAX_ORDER_NUMBER = 6;
  private final int MAX_SHOPPING_ORDER_NUMBER = 3;
  private final int MAX_NUMBER_OF_ORDER = 50;

  public int getInputOfHomeMenu() {
    decision = scanner.nextInt();

    return decision;
  }

  public int inputHamburgerOrder() {
    hamburgerOrder = scanner.nextInt();

    if (isTheNumberOutOfRange(hamburgerOrder, MAX_ORDER_NUMBER)) {
      System.exit(0);
    }

    return hamburgerOrder;
  }

  public int inputSidemeunOrder() {
    sidemeunOrder = scanner.nextInt();

    if (isTheNumberOutOfRange(hamburgerOrder, MAX_ORDER_NUMBER)) {
      System.exit(0);
    }
    return sidemeunOrder;
  }

  public int inputDrinkOrder() {
    drinkOrder = scanner.nextInt();
    if (isTheNumberOutOfRange(drinkOrder, MAX_ORDER_NUMBER)) {
      System.exit(0);
    }

    return drinkOrder;
  }

  public int inputShoppingOrder() {

    shoppingOption = scanner.nextInt();
    if (isTheNumberOutOfRange(shoppingOption, MAX_SHOPPING_ORDER_NUMBER)) {
      System.exit(0);
    }

    return shoppingOption;
  }

  public int inputIndexOfOrder(int length) {
    shoppingOption = scanner.nextInt();

    if (isTheNumberOutOfRange(shoppingOption, length)) {
      System.exit(0);
    }

    return shoppingOption;
  }

  public int inputNumberOfShopping() {
    System.out.println("변경할 수량을 입력하세요:\n");
    shoppingOption = scanner.nextInt();

    if (isMoreThanFifty(shoppingOption)) {
      System.exit(0);

    }
    return shoppingOption;
  }

  public boolean isMoreThanFifty(int number) {
    boolean checkNum = true;
    try {
      if (number > MAX_NUMBER_OF_ORDER) {
        throw new IllegalArgumentException();
      } else {
        checkNum = false;
        return checkNum;
      }
    } catch (IllegalArgumentException e) {
      System.out.println("\n === 최대 주문 가능 개수는 [ 50개 ] 입니다. ===");
    }
    return checkNum;
  }

  public boolean isTheNumberOutOfRange(int number, int max) {
    boolean checkRange = true;
    try {
      if (number > max || number < 0) {
        throw new IllegalArgumentException();
      } else {
        checkRange = false;
        return checkRange;
      }
    } catch (IllegalArgumentException e) {
      System.out.println("\n === 올바르지 않은 입력입니다. ===");
    }
    return checkRange;
  }

  public int getDecision() {
    return decision;
  }

  public void setDecision(int decision) {
    this.decision = decision;
  }
}
