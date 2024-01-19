package kiosk;

import java.util.Scanner;

public class BurgerKingKioskIO {
  private static final Scanner scanner = new Scanner(System.in);

  public static void printWelcomeMessage() {
    System.out.println("어서오세요 버거킹입니다 ^^");
  }

  public static int selectNumberInMain() {
    System.out.println("\n메뉴를 선택해주세요.");
    System.out.println("1. 햄버거");
    System.out.println("2. 사이드");
    System.out.println("3. 음료");
    System.out.println("4. 장바구니");
    System.out.println("5. 종료\n");
    System.out.print("메뉴선택: ");
    return BurgerKingException.checkValidationNumberInMain(scanner.nextInt());
  }

  public static int selectMenuNumber(Menu[] menus) {
    for (int i = 0; i < menus.length; i++) {
      System.out.println((i + 1) + ". " + menus[i].getName() + " " + menus[i].getPrice() + "원");
    }
    System.out.println();
    System.out.print("메뉴 선택(0을 선택 시 홈으로): ");
    return BurgerKingException.checkValidationNumberInMenu(scanner.nextInt(), menus.length);
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
}
