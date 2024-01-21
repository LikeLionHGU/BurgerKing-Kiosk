package kiosk;

import java.util.*;
import java.util.List;

public class MenuInfo {
  Scanner scanner = new Scanner(System.in);
  private int menuNumber;
  private String menuName;
  private Map<String, Integer> basket = new HashMap<>();
  List<MenuItem> sides = new ArrayList<>();
  List<MenuItem> hamburgers = new ArrayList<>();
  List<MenuItem> drinks = new ArrayList<>();
  int MAX_NUM = 50;
  int MIN_NUM = 0;
  int cost = 0;

  private void inputHamburger() {
    hamburgers.add(new Hamburger("와퍼", 6900, 0));
    hamburgers.add(new Hamburger("큐브 스테이크 와퍼", 8900, 0));
    hamburgers.add(new Hamburger("콰트로 치즈 와퍼", 7900, 0));
    hamburgers.add(new Hamburger("몬스터 와퍼", 9300, 0));
    hamburgers.add(new Hamburger("통새우 와퍼", 7900, 0));
    hamburgers.add(new Hamburger("블랙바베큐 와퍼", 9300, 0));
  }

  private void inputSide() {
    sides.add(new Side("프렌치 후라이", 2000, 0));
    sides.add(new Side("너겟킹", 2500, 0));
    sides.add(new Side("해쉬 브라운", 1800, 0));
    sides.add(new Side("치즈스틱", 1200, 0));
    sides.add(new Side("어니언링", 2400, 0));
    sides.add(new Side("바삭킹", 3000, 0));
    sides.add(new Side("감자튀김", 2000, 0));
  }

  private void inputDrink() {
    drinks.add(new Drink("콜라", 1500, 0));
    drinks.add(new Drink("스프라이트", 1500, 0));
    drinks.add(new Drink("환타", 1500, 0));
    drinks.add(new Drink("커피", 1500, 0));
    drinks.add(new Drink("아메리카노", 1500, 0));
    drinks.add(new Drink("핫초코", 1500, 0));
  }

  public MenuInfo() {
    inputHamburger();
    inputSide();
    inputDrink();
  }

  public void printMenu() {
    System.out.println("=====홈=====\n");
    System.out.println("1. 햄버거");
    System.out.println("2. 사이드");
    System.out.println("3. 음료");
    System.out.println("4. 장바구니");
    System.out.println("5. 종료\n");
    System.out.print("메뉴선택: ");

    menuNumber = scanner.nextInt();

    selectMenu(menuNumber);
  }

  public void selectMenu(int menuNumber) {
    if (menuNumber == 1) {
      printHamburgerMenuInfo();
    } else if (menuNumber == 2) {
      printSideMenuInfo();
    } else if (menuNumber == 3) {
      printDrinkMenuInfo();
    } else if (menuNumber == 4) {
      selectBasket();
    } else if (menuNumber == 5) {
      System.exit(0);
    } else {
      validMenuNumber(menuNumber, 1, 5);
    }
  }

  public int printMenuDetail(List<MenuItem> menu) {
    String menuName;
    int menuPrice;
    int menuCount;
    for (int i = 0; i < menu.size(); i++) {
      menuName = menu.get(i).getName();
      menuPrice = menu.get(i).getPrice();
      System.out.println(i + 1 + ". " + menuName + " (" + menuPrice + "원)");
    }
    System.out.print("\n메뉴선택 (0을 선택 시 홈으로): ");
    int result = scanner.nextInt();
    if (result == 0) printMenu();

    validMenuNumber(result, 0, menu.size());

    menuName = menu.get(result - 1).getName();

    menu.get(result - 1).setCount(menu.get(result - 1).getCount() + 1);
    menuCount = menu.get(result - 1).getCount();

    if (menuCount < MIN_NUM || menuCount > MAX_NUM)
      throw new IllegalArgumentException("수량은 50개를 초과할 수 없습니다.");
    basket.put(menuName, menuCount);

    cost += menu.get(result - 1).getPrice();
    System.out.println("\n" + menuName + "이/가 장바구니에 추가되었습니다.\n");
    printMenu();

    return result;
  }

  private void printHamburgerMenuInfo() {
    System.out.println("\n===== 햄버거 메뉴 =====\n");
    printMenuDetail(hamburgers);
  }

  private void printSideMenuInfo() {
    System.out.println("\n===== 사이드 메뉴 =====\n");
    printMenuDetail(sides);
  }

  private void printDrinkMenuInfo() {
    System.out.println("\n===== 음료 메뉴 =====\n");
    printMenuDetail(drinks);
  }

  public void printCurrentBasket() {
    System.out.println("\n현재 장바구니\n");
    int i = 1;
    for (String key : basket.keySet()) {
      System.out.println(i + ". " + key + (" ") + basket.get(key) + " 개");
      i++;
    }
    System.out.println("\n====================");
  }

  public short selectBasket() {
    System.out.println("\n===== 장바구니 =====\n");
    for (String key : basket.keySet()) {
      System.out.println("- " + key + (" ") + basket.get(key) + " 개");
    }
    System.out.println("\n====================");

    System.out.println("1. 주문하기");
    System.out.println("2. 수량 조절하기");
    System.out.println("3. 삭제하기\n");

    System.out.println("총 가격: " + cost + "원\n");

    System.out.println("메뉴선택 (0을 선택 시 홈으로): ");
    int result = scanner.nextInt();

    if (result == 0) printMenu();
    else if (result == 1) {
      System.out.println("주문이 완료되었습니다.");
      System.exit(0);
    } else if (result == 2) {
      controlQuantity();
    } else if (result == 3) {
      deleteBasket();
    } else {
      validMenuNumber(result, 0, 3);
    }
    return 0;
  }

  public void controlQuantity() {
    System.out.println("\n===== 수량 조절하기 =====");

    printCurrentBasket();

    System.out.println("수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
    int menuNum = scanner.nextInt();
    if (menuNum == 0) printMenu();
    validMenuNumber(menuNum, 0, basket.size());

    menuName = basket.keySet().toArray(new String[0])[menuNum - 1];
    int currentQuantity = basket.get(menuName);

    System.out.println("변경할 수량을 입력하세요: ");
    int newQuantity = scanner.nextInt();

    validMenuNumber(newQuantity, MIN_NUM, MAX_NUM);

    MenuItem menuItem = findMenuItemByMenuName(menuName);
    menuItem.setCount(newQuantity);

    if (menuItem != null) {
      cost -= menuItem.getPrice() * currentQuantity;
      cost += menuItem.getPrice() * newQuantity;
    }

    basket.put(menuName, menuItem.getCount());

    System.out.println(menuName + "의 수량이 변경되었습니다.");
    selectBasket();
  }

  public void deleteBasket() {
    System.out.println("\n===== 삭제하기 =====");

    printCurrentBasket();

    System.out.println("삭제할 메뉴 번호를 선택하세요 ((0을 선택 시 홈으로): ");
    int menuNum = scanner.nextInt();
    if (menuNum == 0) printMenu();

    System.out.println("정말 삭제하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
    int deleteNum = scanner.nextInt();
    if (deleteNum == 0) {
      System.out.println("취소되었습니다.");
      selectBasket();
    } else if (deleteNum == 1){
      menuName = basket.keySet().toArray(new String[0])[menuNum - 1];
      int currentQuantity = basket.get(menuName);

      MenuItem menuItem = findMenuItemByMenuName(menuName);
      if (menuItem != null) {
        cost -= menuItem.getPrice() * currentQuantity;
        basket.remove(menuName);
        menuItem.setCount(0);
        System.out.println("삭제되었습니다.");
      }
      selectBasket();
    }
    else {
      validMenuNumber(deleteNum, 0, 1);
    }
  }

  public MenuItem findMenuItemByMenuName(String name) {
    for (MenuItem item : hamburgers) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    for (MenuItem item : sides) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    for (MenuItem item : drinks) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    return null;
  }

  public void validMenuNumber(int menuNumber, int min, int max) {
    if (menuNumber < min || menuNumber > max) {
      throw new IllegalArgumentException(min + " ~ " + max + " 사이의 숫자만 입력 가능합니다.");
    }
  }
}
