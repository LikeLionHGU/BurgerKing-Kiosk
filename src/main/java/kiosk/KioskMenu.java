package kiosk;

import java.util.Scanner;

public class KioskMenu {
    Scanner sc = new Scanner(System.in);

    public void chooseKioskMenu() {
        System.out.print("=====홈=====\n\n" + "1. 햄버거\n" + "2. 사이드\n" + "3. 음료\n" + "4. 장바구니\n" + "5. 종료\n" + "\n" + "메뉴선택: ");
        int option = sc.nextInt();
        chooseOption(option);
    }

    static void chooseOption(int num) {
        if (num == 1) { //햄버거
            kiosk.HamburgerMenu hamburgerInput = new HamburgerMenu();
            hamburgerInput.chooseHamburgerMenu();
        } else if (num == 2) { //사이드
            kiosk.SideMenu sideInput = new SideMenu();
            sideInput.chooseSideMenu();
        } else if (num == 3) { //음료
            kiosk.DrinkMenu drinkInput = new DrinkMenu();
            drinkInput.chooseDrinkMenu();
        } else if (num == 4) { //장바구니
            kiosk.Basket basketInput = new Basket();
            basketInput.printBasketMenu();
        } else if (num == 5) {
            System.out.println("이용해 주셔서 감사합니다.");
            System.exit(0);
        } else {
            throw new IllegalArgumentException("햄버거, 사이드, 음료, 장바구나, 종료 중 하나를 골라야 합니다.");
        }
    }
}
