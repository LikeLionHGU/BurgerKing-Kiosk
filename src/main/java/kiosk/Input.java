package kiosk;

import java.util.Scanner;

public class Input {



  Scanner scanner = new Scanner(System.in);


  private int decision;








  public int getInputOfHomeMenu() {
    decision = scanner.nextInt();
    System.out.println(decision);
    return decision;
  }







  public int getDecision() {
    return decision;
  }

  public void setDecision(int decision) {
    this.decision = decision;
  }
}
