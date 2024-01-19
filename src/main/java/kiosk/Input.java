package kiosk;

import java.util.Scanner;

public class Input {
  Scanner scanner = new Scanner(System.in);
  private int decision;

  private String[] pickedMenu;
  private String[] hamburgerName;
  private int[] hamburgerPrice;

  private String[] sidemenuName;
  private int[] sidemenuPrice;

  private String[] drinkName;
  private int[] drinkPrice;

  private void initEveryInfo() {
    hamburgerName = new String[] {"와퍼", "큐브 스테이크 와퍼", "콰트로 치즈 와퍼", "몬스터 와퍼", "통새우 와퍼", "블랙바베큐 와퍼"};
    hamburgerPrice = new int[] {6900, 8900, 7900, 9300, 7900, 9300};

    sidemenuName = new String[] {"너겟킹", "해쉬 브라운", "치즈 스틱", "어니언링", "바삭킹", "감자튀김"};
    sidemenuPrice = new int[] {2500, 1800, 1200, 2400, 3000, 2000};

    drinkName = new String[] {"코카콜라", "코카콜라 제로", "펩시", "펩시 제로", "스프라이트", "스프라이트 제로"};
    drinkPrice = new int[] {2000, 2000, 2000, 2000, 2000, 2000};
  }

  public void printHomeMenu() {
    System.out.println("=====홈=====");
    System.out.println("1. 햄버거");
    System.out.println("2. 사이드");
    System.out.println("3. 음료");
    System.out.println("4. 장바구니");
    System.out.println("5. 종료");

    System.out.println("\n메뉴선택: ");
  }

  public int getInputOfHomeMenu() {
    printHomeMenu();
    decision = scanner.nextInt();
    return decision;
  }

  public void controllHomeMenu() {
    decision = getInputOfHomeMenu();

    //    if()0~5사이가 아니면 에러 발생

    if (decision == 1) {
      printMenuInfo(hamburgerName, hamburgerPrice);
    } else if (decision == 2) {
      printMenuInfo(sidemenuName, sidemenuPrice);

    } else if (decision == 3) {
      printMenuInfo(drinkName, drinkPrice);

    } else if (decision == 4) {
//    장바구니
    } else if (decision == 5) {
//    종료
    }
  }

  public void printMenuInfo(String[] menuName, int[] menuPrice) {
    for (int i = 0; i < menuName.length; i++) {
      System.out.println((i + 1) + ", " + menuName[i] + "(" + menuPrice[i] + ")");
    }
    System.out.println("메뉴선택 (0을 선택 시 홈으로): ");
  }


}
