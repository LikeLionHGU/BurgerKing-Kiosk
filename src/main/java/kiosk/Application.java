package kiosk;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("프로그램 실행 시작!");
        printHome();
    }

    public static int getIntByUser(){
        Scanner scanner = new Scanner(System.in);
	    return scanner.nextInt();
    }

    public static  void runProgram(){
        int input = getIntByUser();
        switch(input){
            case 1:
                printBurgerMenu();
            case 2:
                printSideMenu();
            case 3:
                printDrinkMenu();
            case 4:
                printShoppingBasket();
            case 5:
                exitProgram();
            default:
                throw new IllegalArgumentException("잘못된 입력으로 인해 프로그램을 종료합니다.");

        }


    }

    public static void printShoppingBasket() {
    }

    public static void exitProgram() {
        System.exit(0);
    }

    // 메뉴에서 원하는 메뉴를 입력하면, 해당 메뉴가 장바구니에 담김.
    // 이때 개수는 1개!
    // 추가로 이때, 가격 계산해주는 함수도 필요함.
    public static void addFood(){

    }

    public static void printSideMenu() {
        System.out.println("=====사이드 메뉴=====");
        System.out.println("1. 너겟킹 (2500원)");
        System.out.println("2. 해쉬 브라운 (1800원)");
        System.out.println("3. 치즈스틱 (1200원)");
        System.out.println("4. 어니언링 (2400원)");
        System.out.println("5. 바삭킹 (3000원)");
        System.out.println("6. 감자튀김 (2000원)\n");
        System.out.print("메뉴선택 (0을 선택 시 홈으로):");
        printHome();
    }

    public static void printDrinkMenu() {
        System.out.println("=====음료 메뉴=====");
        System.out.println("1. 코카콜라 (2000원)");
        System.out.println("2. 코카콜라 제로 (2000원)");
        System.out.println("3. 펩시 (2000원)");
        System.out.println("4. 펩시 제로 (2000원)");
        System.out.println("5. 스프라이트 (2000원)");
        System.out.println("6. 스프라이트 제로 (2000원)");
        System.out.println("메뉴선택 (0을 선택 시 홈으로):");
        printHome();
    }

    public static void printBurgerMenu() {
        System.out.println("=====햄버거 메뉴=====");
        System.out.println("1. 와퍼 (6900원)");
        System.out.println("2. 큐브 스테이크 와퍼 (8900원)");
        System.out.println("3. 콰트로 치즈 와퍼 (7900원)");
        System.out.println("4. 몬스터 와퍼 (9300원)");
        System.out.println("5. 통새우 와퍼 (7900원)");
        System.out.println("6. 블랙바베큐 와퍼 (9300원)\n");
        System.out.println("메뉴선택 (0을 선택 시 홈으로): ");
        printHome();
    }

    public static void printHome(){
        System.out.println("=====홈=====");
        System.out.println("1. 햄버거");
        System.out.println("2. 사이드");
        System.out.println("3. 음료");
        System.out.println("4. 장바구니");
        System.out.println("5. 종료\n");
        System.out.print("메뉴선택:");
        runProgram();
    }

}