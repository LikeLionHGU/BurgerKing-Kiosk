package kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class BurgerKingKioskIO {
  private static final int MAX_MAIN_MENU_COUNT = 5;
  private static final int MAX_BASKET_MENU_COUNT = 3;
  private static final Scanner scanner = new Scanner(System.in);

  public static void printWelcomeMessage() {
    System.out.println("어서오세요 버거킹입니다 ^^");
  }

  public static int selectNumberInMain() {
    System.out.println("\n=====홈=====\n");
    System.out.println("1. 햄버거");
    System.out.println("2. 사이드");
    System.out.println("3. 음료");
    System.out.println("4. 장바구니");
    System.out.println("5. 종료\n");
    System.out.print("메뉴선택(0을 선택 시 새로고침): ");
    return BurgerKingException.checkValidationNumberAboutLength(
        scanner.nextInt(), MAX_MAIN_MENU_COUNT);
  }

  public static int selectMenuNumber(Menu[] menus) {
    for (int i = 0; i < menus.length; i++) {
      System.out.println((i + 1) + ". " + menus[i].getName() + " " + menus[i].getPrice() + "원");
    }
    System.out.println();
    System.out.print("메뉴 선택(0을 선택 시 홈으로): ");
    return BurgerKingException.checkValidationNumberAboutLength(scanner.nextInt(), menus.length);
  }

  public static int selectHamburgerMenu(Menu[] menus) {
    System.out.println("\n=====햄버거 메뉴=====\n");
    return selectMenuNumber(menus);
  }

  public static int selectSideMenu(Menu[] menus) {
    System.out.println("\n=====사이드 메뉴=====\n");
    return selectMenuNumber(menus);
  }

  public static int selectDrinkMenu(Menu[] menus) {
    System.out.println("\n=====음료 메뉴=====\n");
    return selectMenuNumber(menus);
  }

  public static Order printAddedOrder(Order order) {
    System.out.println(order.getName() + "가 추가되었습니다.");
    return order;
  }

  public static void printBasket(ArrayList<Order> orders) {
    System.out.println("\n=====장바구니=====\n");
    for (int i = 0; i < orders.size(); i++) {
      System.out.println(
          (i + 1)
              + ". "
              + orders.get(i).getName()
              + " "
              + orders.get(i).getMenu().getPrice()
              + "원 "
              + orders.get(i).getCount()
              + "개 "
              + orders.get(i).calculatePrice()
              + "원");
    }
    System.out.println();
    System.out.println("총 가격: " + BurgerKingKioskCalculator.calculateTotalPrice(orders) + "원");
  }

  public static int selectOrderFromBasket(ArrayList<Order> orders) {
    printBasket(orders);
    System.out.print("메뉴 선택(0을 선택 시 홈으로): ");
    return BurgerKingException.checkValidationNumberAboutLength(scanner.nextInt(), orders.size());
  }

  public static int selectBasketMenu(ArrayList<Order> orders) {
    printBasket(orders);
    System.out.println("\n==========\n");
    System.out.println("1. 주문하기");
    System.out.println("2. 수량 조절하기");
    System.out.println("3. 삭제하기");
    System.out.println();
    System.out.print("메뉴 선택(0을 선택 시 홈으로): ");
    return BurgerKingException.checkValidationNumberAboutLength(
        scanner.nextInt(), MAX_BASKET_MENU_COUNT);
  }

  public static void pay(ArrayList<Order> orders) {
    System.out.println("\n=====결제=====");
    printBasket(orders);
    System.out.println("\n결제가 완료되었습니다.");
  }

  public static void GoodBye() {
    System.out.println("이용해주셔서 감사합니다.");
  }
}
