package kiosk;

import java.util.Scanner;

public class Input {
  Scanner scanner = new Scanner(System.in);
  private int decision;

  private String[] hamburgerName;
  private int[] hamburgerPrice;



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
    decision=scanner.nextInt();
    return decision;
  }

  public void controllHomeMenu(){


  }






}