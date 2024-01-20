package kiosk;

import java.util.Scanner;

public class DrinkMenu {
    Scanner sc = new Scanner(System.in);

    // 음료 선택 화면
    public void chooseDrinkMenu() {
        System.out.println("1. 코카콜라 (2000원)\n" + "2. 코카콜라 제로 (2000원)\n" + "3. 펩시 (2000원)\n" + "4. 펩시 제로 (2000원)\n" + "5. 스프라이트 (2000원)\n" + "6. 스프라이트 제로 (2000원)" + "\n" + "메뉴선택 (0을 선택 시 홈으로): ");
        int option = sc.nextInt();
        drinkOption(option);
    }

    //음료 바스켓에 추가
    public void drinkOption(int n) {
        kiosk.KioskMenu kiosk = new KioskMenu();
        if (n >= 1 && n <= 6) {
            kiosk.Basket addDrink = new Basket();
            addDrink.drinkAdd(n);
            kiosk.chooseKioskMenu();
        } else if (n == 0) {
            kiosk.chooseKioskMenu();
        }
    }

    //음료 가격 계산
    public int calculateDrinkPrice(int sideNo){
        int b=0;
        if(sideNo==1){
            b = 2000;
        }else if(sideNo==2){
            b = 2000;
        }else if(sideNo==3){
            b = 2000;
        }else if(sideNo==4){
            b = 2000;
        }else if(sideNo==5){
            b = 2000;
        }else if(sideNo==6){
            b = 2000;
        }
        return b;
    }

    public String returnDrinkName(int n){
        String drinkName="";
        if(n==1){
            drinkName = "코카콜라";
        }else if(n==2){
            drinkName = "코카콜라 제로";
        }else if(n==3){
            drinkName = "펩시";
        }else if(n==4){
            drinkName = "펩시 제로";
        }else if(n==5){
            drinkName = "스프라이트";
        }else if(n==6){
            drinkName = "스프라이트 제로";
        }
        return drinkName;
    }
}
