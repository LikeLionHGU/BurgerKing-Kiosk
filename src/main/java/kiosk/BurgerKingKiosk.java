package kiosk;

import java.util.ArrayList;

public class BurgerKingKiosk {
  private ArrayList<Order> basket = new ArrayList<>();

  public void run() {
    BurgerKingKioskIO.printWelcomeMessage();
    while (true) {
      switch (BurgerKingKioskIO.selectNumberInMain()) {
        case 1 -> selectHamburger();
        case 2 -> selectSideMenu();
        case 3 -> selectBeverage();
        case 4 -> {
          if (basketManagement() == 1){
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
    for (Order order : basket) {
      if (order.getName().equals(menu.getName())) {
        order.addCount(1);
        BurgerKingKioskIO.printAddedOrder(order);
        return;
      }
    }
    basket.add(BurgerKingKioskIO.printAddedOrder(new Order(menu, 1)));
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
          if (manageOrderCount()==0) return 0;// 0을 선택하면 홈으로
        }
        case 3 -> {
          return 3;
        }
      }
    }
  }

  private int manageOrderCount(){
    int index=BurgerKingKioskIO.selectOrderFromBasket(basket);
    if(index==0) return 0; // 0을 선택하면 홈으로
    int count=BurgerKingKioskIO.selectCount();
    setOrderCount(index-1,count);
    return 1;
  }

  private void setOrderCount(int index, int count) {
    basket.get(index).setCount(count);
    BurgerKingKioskIO.setOrderCountComplete(basket.get(index), count);
  }
}
