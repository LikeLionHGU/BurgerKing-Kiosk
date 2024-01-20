package kiosk;

import java.util.Scanner;

public class SideMenu {

    Scanner sc = new Scanner(System.in);

    //사이드 선택 화면
    public void chooseSideMenu() {
        System.out.println("1. 너겟킹 (2500원)\n" + "2. 해쉬 브라운 (1800원)\n" + "3. 치즈스틱 (1200원)\n" + "4. 어니언링 (2400원)\n" + "5. 바삭킹 (3000원)\n" + "6. 감자튀김 (2000원)" + "\n" + "메뉴선택 (0을 선택 시 홈으로): ");
        int option = sc.nextInt();
        sideOption(option);
    }

    // 사이드를 바스켓에 추가
    public void sideOption(int n) {
        kiosk.KioskMenu kiosk = new KioskMenu();
        if (n >= 1 && n <= 6) {
            kiosk.Basket addSide = new Basket();
            addSide.sideAdd(n);
            kiosk.chooseKioskMenu();
        } else if (n == 0) {
            kiosk.chooseKioskMenu();
        }
    }

    // 사이드 가격 계산
    public int calculateSidePrice(int sideNo){
        int b=0;
        if(sideNo==1){
            b = 2500;
        }else if(sideNo==2){
            b = 1800;
        }else if(sideNo==3){
            b = 1200;
        }else if(sideNo==4){
            b = 2400;
        }else if(sideNo==5){
            b = 3000;
        }else if(sideNo==6){
            b = 2000;
        }
        return b;
    }

    public String returnSideName(int n){
        String sideName="";
        if(n==1){
            sideName = "너겟킹";
        }else if(n==2){
            sideName = "해쉬 브라운";
        }else if(n==3){
            sideName = "치즈스틱";
        }else if(n==4){
            sideName = "어니언링";
        }else if(n==5){
            sideName = "바삭킹";
        }else if(n==6){
            sideName = "감자튀김";
        }
        return sideName;
    }
}
