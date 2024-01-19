package kiosk;

import java.util.ArrayList;

public class BurgerKingKioskCalculator {
  public static int calculateTotalPrice(ArrayList<Order> orders) {
    int totalPrice = 0;
    for (Order order : orders) {
      totalPrice += order.calculatePrice();
    }
    return totalPrice;
  }
}
