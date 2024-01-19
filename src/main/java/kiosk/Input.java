package kiosk;

import java.util.Scanner;

public class Input {

  Scanner scanner = new Scanner(System.in);

  private int decision;
  private int hamburgerOrder;

  private int sidemeunOrder;

  private int drinkOrder;

  public int getInputOfHomeMenu() {
    decision = scanner.nextInt();

    return decision;
  }

  public int inputHamburgerOrder(){
    hamburgerOrder = scanner.nextInt();
    return hamburgerOrder;
  }

  public int inputSidemeunOrder(){
    sidemeunOrder = scanner.nextInt();
    return sidemeunOrder;
  }

  public int inputDrinkOrder(){
    drinkOrder = scanner.nextInt();
    return drinkOrder;
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
