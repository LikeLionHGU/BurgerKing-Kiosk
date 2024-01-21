package kiosk;

public class BurgerKingKiosk {
  private final Basket basket = new Basket();

  public void run() {
    BurgerKingKioskIO.printWelcomeMessage();
    while (true) {
      switch (BurgerKingKioskIO.selectNumberInMain()) {
        case 1 -> selectHamburger();
        case 2 -> selectSideMenu();
        case 3 -> selectBeverage();
        case 4 -> {
          if (basketManagement() == 1) {
            BurgerKingKioskIO.GoodBye();
            return;
          }
        }
        case 5 -> {
          BurgerKingKioskIO.GoodBye();
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
    for (Order order : basket.getOrderList()) {
      if (order.getMenu() == menu) {
        order.addCount(1);
        BurgerKingKioskIO.printAddedOrder(order);
        return;
      }
    }
    Order order = new Order(menu, 1);
    basket.addOrder(order);
    BurgerKingKioskIO.printAddedOrder(order);
  }

  private int basketManagement() {
    while (true) {
      switch (BurgerKingKioskIO.selectBasketMenu(basket)) {
        case 0 -> {
          return 0;
        }
        case 1 -> {
          BurgerKingKioskIO.pay(basket);
          return 1;
        }
        case 2 -> {
          if (manageOrderCount() == 0) return 0; // 0을 선택하면 홈으로
        }
        case 3 -> {
          if (deleteOrder() == 0) return 0; // 0을 선택하면 홈으로
        }
      }
    }
  }

  private int deleteOrder() {
    int index = BurgerKingKioskIO.selectOrderFromBasketToDelete(basket);
    if (index == 0) return 0; // 0을 선택하면 홈으로
    if (BurgerKingKioskIO.checkDeleteOk() == 1) { // 삭제 확인이 1일 경우 삭제
      BurgerKingKioskIO.deleteOrderComplete(basket.getOrder(index - 1));
      basket.removeOrder(index - 1);
    }
    return 1;
  }

  private int manageOrderCount() {
    int index = BurgerKingKioskIO.selectOrderFromBasketToChangeCount(basket);
    if (index == 0) return 0; // 0을 선택하면 홈으로
    int count = BurgerKingKioskIO.selectCount();
    basket.setOrderCount(index-1, count);
    BurgerKingKioskIO.setOrderCountComplete(basket.getOrder(index-1), count);
    return 1;
  }
}
