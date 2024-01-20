package kiosk;

import java.util.List;

public class Print {

  public void printHomeMenu() {
    System.out.println("\n=====홈=====");
    System.out.println("1. 햄버거");
    System.out.println("2. 사이드");
    System.out.println("3. 음료");
    System.out.println("4. 장바구니");
    System.out.println("5. 종료");

    System.out.println("\n메뉴선택: ");
  }

  public void printMenuInfo(String[] menuName, int[] menuPrice) {
    System.out.println();
    for (int i = 0; i < menuName.length; i++) {
      System.out.println((i + 1) + ". " + menuName[i] + "  (" + menuPrice[i] + ")");
    }
    System.out.println("\n메뉴를 골라주세요 (0을 선택 시 홈으로): ");
  }

  public void printOrderList(List<String> nameList, List<Integer> numList, int totalprice) {

    System.out.println("메뉴는 다음과 같습니다.");

    String[] nameListArr = nameList.toArray(new String[nameList.size()]);
    int[] numListArr = numList.stream().mapToInt(i -> i).toArray();

    for (int i = 0; i < nameListArr.length; i++) {
      System.out.println(i + 1 + ". " + nameListArr[i] + " " + numListArr[i] + "개");
    }
    System.out.println("\n ==========================");
    System.out.println("\n1. 주문하기");
    System.out.println("2. 수량 조절하기");
    System.out.println("3. 삭제하기");

    System.out.println("총 가격은 " + totalprice + "원 입니다.\n");

    System.out.print("메뉴를 골라주세요 (0을 선택 시 홈으로): ");
  }

  public void printOrderList(List<String> nameList, List<Integer> numList) {

    System.out.println("메뉴는 다음과 같습니다.");

    String[] nameListArr = nameList.toArray(new String[nameList.size()]);
    int[] numListArr = numList.stream().mapToInt(i -> i).toArray();

    for (int i = 0; i < nameListArr.length; i++) {
      System.out.println(i + 1 + ". " + nameListArr[i] + " " + numListArr[i] + "개");
    }
    System.out.println("\n ==========================");



  }
}
