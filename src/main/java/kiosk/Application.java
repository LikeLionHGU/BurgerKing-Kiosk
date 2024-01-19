package kiosk;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("프로그램 실행 시작!");
        startProgram();

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
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

    public static void printSideMenu() {
    }

    public static void printDrinkMenu() {
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
    }

    public static void startProgram(){
        System.out.println("=====홈=====");
        System.out.println("1. 햄버거");
        System.out.println("2. 사이드");
        System.out.println("3. 음료");
        System.out.println("4. 장바구니");
        System.out.println("5. 종료\n");
        System.out.print("메뉴선택:");
    }

}