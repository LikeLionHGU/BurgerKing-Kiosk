package kiosk;

import java.util.ArrayList;

public class BurgerKingKiosk {
  private ArrayList<Order> bascket = new ArrayList<>();

  public void run() {
    BurgerKingKioskIO.printWelcomeMessage();
    while (true) {
      switch (BurgerKingKioskIO.selectNumberInMain()) {
        case 1 -> selectHamburger();
        case 2 -> selectSideMenu();
        case 3 -> selectBeverage();
        case 4 -> {
          BurgerKingKioskIO.printAddedOrder(bascket.get(bascket.size() - 1));
        }
        case 5 -> {
          return;
        }
      }
    }
  }

  private void selectHamburger() {
    int input = BurgerKingKioskIO.selectHamburgerMenu(BurgerKingMenu.getHamburgerList());
    if (input != 0) addOrder(BurgerKingMenu.getHamburger(input - 1));
  }

  private void selectSideMenu() {
    int input = BurgerKingKioskIO.selectSideMenu(BurgerKingMenu.getSideMenuList());
    if (input != 0) addOrder(BurgerKingMenu.getSideMenu(input - 1));
  }

  private void selectBeverage() {
    int input = BurgerKingKioskIO.selectDrinkMenu(BurgerKingMenu.getBeverageList());
    if (input != 0) addOrder(BurgerKingMenu.getBeverage(input - 1));
  }

  private void addOrder(Menu menu) {
    for (Order order : bascket) {
      if (order.getName().equals(menu.getName())) {
        order.addCount(1);
        BurgerKingKioskIO.printAddedOrder(order);
        return;
      }
    }
    bascket.add(BurgerKingKioskIO.printAddedOrder(new Order(menu, 1)));
  }
}
