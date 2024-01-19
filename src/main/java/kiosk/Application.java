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
    }

    public static void printSideMenu() {
    }

    public static void printDrinkMenu() {
    }

    public static void printBurgerMenu() {
    }

    public static void startProgram(){
        System.out.println("====홈====");
        System.out.println("햄버거");
        System.out.println("사이햐드");
        System.out.println("음료");
        System.out.println("장바구니");
        System.out.println("종료");

    }

}