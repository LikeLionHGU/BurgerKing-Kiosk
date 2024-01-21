package kiosk;

import java.util.Scanner;

public class DrinkMenu {
    Scanner sc = new Scanner(System.in);

    public void chooseDrinkMenu() {
        System.out.print("=====음료 메뉴=====\n\n" + "1. 코카콜라 (2000원)\n" + "2. 코카콜라 제로 (2000원)\n" + "3. 펩시 (2000원)\n" + "4. 펩시 제로 (2000원)\n" + "5. 스프라이트 (2000원)\n" + "6. 스프라이트 제로 (2000원)" + "\n" + "메뉴선택 (0을 선택 시 홈으로): ");
        int option = sc.nextInt();
        drinkOption(option);
    }

    public void drinkOption(int n) {
        kiosk.KioskMenu kiosk = new KioskMenu();
        if (n >= 1 && n <= 6) {
            kiosk.Basket addDrink = new Basket();
            addDrink.drinkAdd(n);
            System.out.println("음료가 장바구니 안에 담겼습니다.");
            kiosk.chooseKioskMenu();
        } else if (n == 0) {
            kiosk.chooseKioskMenu();
        } else {
            throw new IllegalArgumentException("음료 메뉴는 1~6 중 하나를 골라야 합니다.");
        }
    }

    public int calculateDrinkPrice(int sideNo) {
        int b = 0;
        if (sideNo == 1) {
            b = 2000;
        } else if (sideNo == 2) {
            b = 2000;
        } else if (sideNo == 3) {
            b = 2000;
        } else if (sideNo == 4) {
            b = 2000;
        } else if (sideNo == 5) {
            b = 2000;
        } else if (sideNo == 6) {
            b = 2000;
        }
        return b;
    }

    public String returnDrinkName(int n) {
        n += 1;
        String drinkName = "";
        if (n == 1) {
            drinkName = "코카콜라";
        } else if (n == 2) {
            drinkName = "코카콜라 제로";
        } else if (n == 3) {
            drinkName = "펩시";
        } else if (n == 4) {
            drinkName = "펩시 제로";
        } else if (n == 5) {
            drinkName = "스프라이트";
        } else if (n == 6) {
            drinkName = "스프라이트 제로";
        }
        return drinkName;
    }
}