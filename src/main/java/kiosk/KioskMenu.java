package kiosk;
import java.util.Scanner;
public class KioskMenu {
    Scanner sc = new Scanner(System.in);

    //키오스크 화면에서 메뉴 선택
    public void chooseKioskMenu(){
        System.out.print("1. 햄버거\n" + "2. 사이드\n" + "3. 음료\n" + "4. 장바구니\n" + "5. 종료\n" + "\n" + "메뉴선택:");
        int option = sc.nextInt();
        getScore(option);
    }

    //선택한 메뉴대로 해당하는 클래스의 화면으로 보내는 작업
    static void getScore(int num) {
        if(num==1){ //햄버거 (완
            kiosk.HamburgerMenu hamburgerInput = new HamburgerMenu();
            hamburgerInput.chooseHamburgerMenu();
        }else if(num==2){ //사이드
            kiosk.SideMenu sideInput = new SideMenu();
            sideInput.chooseSideMenu();
        }else if(num==3){ //음료
            kiosk.DrinkMenu drinkInput = new DrinkMenu();
            drinkInput.chooseDrinkMenu();
        }else if(num==4){ //장바구니
            kiosk.Basket basketInput = new Basket();
            basketInput.prinkBasketMenu();
        }else if(num==5){

        }

    }
}
