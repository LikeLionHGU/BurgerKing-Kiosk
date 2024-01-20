package kiosk;

import java.util.Scanner;

//실질적인 값 계산
public class Basket {
    Scanner sc = new Scanner(System.in);
    static int price=0;
    static int[] burger= new int []{0,0,0,0,0,0};
    static int[] side = new int []{0,0,0,0,0,0};
    static int[] drink = new int []{0,0,0,0,0,0};

    //햄버거 수와 가격 계산
    public void hambergerAdd(int num){
        burger[num]++;
        kiosk.HamburgerMenu burgerP = new HamburgerMenu();
        int p=burgerP.calculateBurgerPrice(num);
        price+=p;
    }

    //사이드 수와 가격 계산
    public void sideAdd(int num){
        side[num]++;
        kiosk.SideMenu sideP = new SideMenu();
        int p=sideP.calculateSidePrice(num);
        price+=p;
    }

    //음료 수와 가격 계산
    public void drinkAdd(int num){
        drink[num]++;
        kiosk.DrinkMenu drinkP = new DrinkMenu();
        int p=drinkP.calculateDrinkPrice(num);
        price+=p;
    }

    public void prinkBasketMenu(){
        System.out.println("===== 장바구니 =====\n");
        printBirgerMenu();
        printSideMenu();
        printDrinkMenu();

        System.out.print("\n====================\n" + "1. 주문하기 \n" + "2. 수량 조절하기\n" + "3. 삭제하기 \n" + "\n" +
                "총 가격: " + price + "원" + "\n\n" + "메뉴선택 (0을 선택 시 홈으로): ");

        int option = sc.nextInt();
        basketOption(option);

    }


    public void basketOption(int n) {
        kiosk.KioskMenu kiosk = new KioskMenu();
        if (n >= 1 && n <= 6) {

            choosingBasketOption(n);

            kiosk.chooseKioskMenu();
        } else if (n == 0) {
            kiosk.chooseKioskMenu();
        }
    }

    public void choosingBasketOption(int n){
        if(n==1){
            order();
        }else if(n==2){
            changeOrder();
        }else if(n==3){

        }
    }



    //주문하기 선택 시
    public void order(){
        System.out.println("주문해 주셔서 감사합니다. 총 " + price + "원 입니다.");
        System.exit(0);
    }

    // 수량 조절하기 선택 시
    public void changeOrder(){
        System.out.println("수정할 메뉴를 선택해 주세요.");
        int count=1;
        int[] checkingNum = new int[3];
        int[] st = new int[18];
        String[] menu= new String[count];
        kiosk.HamburgerMenu burgerP = new HamburgerMenu();
        for(int i=0; i<6; i++){
            if(burger[i]!=0){
                System.out.println(count + "." + burgerP.returnBurgerName(i) + " " + burger[i] +"개\n");
                count++;

            }
        }

        kiosk.SideMenu sideP = new SideMenu();
        for(int i=0; i<6; i++){
            if(side[i]!=0){
                System.out.println(count + "."+ sideP.returnSideName(i) + " " + side[i] +"개\n");
                count++;

            }
        }

        kiosk.DrinkMenu drinkP = new DrinkMenu();
        for(int i=0; i<6; i++){
            if(drink[i]!=0){
                System.out.println(count + "." + drinkP.returnDrinkName(i) + " " + drink[i] +"개\n");
                count++;

            }
        }
        System.out.print("바꿀 메뉴는?: ");
        int option = sc.nextInt();
        System.out.println("바꿀 수량을 입력하시오 (1개 이상 50개 이하). ");
        int quantity = sc.nextInt();

        int count2=1;
        int difference=0;

        //수량 바꾸는 로직
        for(int i=0; i<6; i++) {
            if (burger[i] != 0) {
                if (count2 == option) {
                    if (burger[i] < quantity) {
                        difference = quantity - burger[i];
                        price += burgerP.calculateBurgerPrice(i) * difference;
                    } else if (burger[i] > quantity) {
                        difference = burger[i] - quantity;
                        price -= burgerP.calculateBurgerPrice(i) * difference;
                    }
                    burger[i] = quantity;
                    count2++;
                } else if(count2<option){
                    count2++;
                }
            }
        }
        for(int i=0; i<6; i++) {
            if (side[i] != 0) {
                if (count2 == option) {
                    if (side[i] < quantity) {
                        difference = quantity - side[i];
                        price += sideP.calculateSidePrice(i) * difference;
                    } else if (side[i] > quantity) {
                        difference = side[i] - quantity;
                        price -= sideP.calculateSidePrice(i) * difference;
                    }
                    side[i] = quantity;
                    count2++;
                } else if(count2<option){
                    count2++;
                }
            }
        }
        for(int i=0; i<6; i++) {
            if(drink[i]!=0){
                if(count2==option){
                    if(drink[i]<quantity){
                        difference = quantity-drink[i];
                        price+= drinkP.calculateDrinkPrice(i)*difference;
                    } else if (drink[i]>quantity) {
                        difference = drink[i]-quantity;
                        price-= drinkP.calculateDrinkPrice(i)*difference;
                    }
                    drink[i] = quantity;
                    count2++;
                }else if(count2<option){
                    count2++;
                }
            }

        }

    }


    public void printBirgerMenu(){
        kiosk.HamburgerMenu burgerP = new HamburgerMenu();
        for(int i=0; i<6; i++){
            if(burger[i]!=0){
                System.out.println(burgerP.returnBurgerName(i) + " " + burger[i] +"개\n");
            }
        }
    }

    public void printSideMenu(){
        kiosk.SideMenu sideP = new SideMenu();
        for(int i=0; i<6; i++){
            if(side[i]!=0){
                System.out.println(sideP.returnSideName(i) + " " + side[i] +"개\n");
            }
        }
    }
    public void printDrinkMenu(){
        kiosk.DrinkMenu drinkP = new DrinkMenu();
        for(int i=0; i<6; i++){
            if(drink[i]!=0){
                System.out.println(drinkP.returnDrinkName(i) + " " + drink[i] +"개\n");
            }
        }
    }
}
