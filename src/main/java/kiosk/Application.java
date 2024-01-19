package kiosk;

import java.util.ArrayList;
import java.util.Scanner;

class Item{
    String itemName;
    int price;
    int count;

    Item(String itemName, int price, int count){
        this.itemName = itemName;
        this.price = price;
        this.count = count;
    }
}

public class Application {
//    public static int sum = 0;
//    public static ArrayList<Item> shoppingBasket = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("프로그램 실행 시작!");
        ArrayList<Item> burgerArrayList = new ArrayList<>();
        burgerArrayList = addBurger(burgerArrayList);
        ArrayList<Item> sideArrayList = new ArrayList<>();
        sideArrayList = addSide(sideArrayList);
        ArrayList<Item> drinkArrayList = new ArrayList<>();
        drinkArrayList = addDrink(drinkArrayList);

        for(;;) {
            printHome();
            runProgram(burgerArrayList, sideArrayList, drinkArrayList);
        }
    }

    public static int getIntByUser(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static  void runProgram(ArrayList<Item> burgerArrayList, ArrayList<Item> sideArrayList, ArrayList<Item> drinkArrayList){
        int input = getIntByUser();
        switch(input){
            case 1:
                printBurgerMenu(burgerArrayList);
                break;
            case 2:
                printSideMenu(sideArrayList);
                break;
            case 3:
                printDrinkMenu(drinkArrayList);
                break;
            case 4:
                printShoppingBasket();
                break;
            case 5:
                exitProgram();
                break;
            default:
                throw new IllegalArgumentException("잘못된 입력으로 인해 프로그램을 종료합니다.");
        }
    }

    public static void printShoppingBasket() {
    }

    public static void exitProgram() {
        System.out.println("프로그램을 종료하겠습니다.");
        System.exit(0);
    }

    public static ArrayList<Item> addBurger(ArrayList<Item> burgerArrayList){
        burgerArrayList.add(new Item("와퍼", 6900, 0));
        burgerArrayList.add(new Item("큐브 스테이크 와퍼", 8900, 0));
        burgerArrayList.add(new Item("콰트로 치즈 와퍼", 7900, 0));
        burgerArrayList.add(new Item("몬스터 와퍼", 9300, 0));
        burgerArrayList.add(new Item("동새우 와퍼", 7900, 0));
        burgerArrayList.add(new Item("블랙바베큐 와퍼", 9300, 0));
        return burgerArrayList;
    }

    public static ArrayList<Item> addDrink(ArrayList<Item> drinkArrayList){
        drinkArrayList.add(new Item("코카콜라", 2000, 0));
        drinkArrayList.add(new Item("코카콜라 제로", 2000, 0));
        drinkArrayList.add(new Item("펩시", 2000, 0));
        drinkArrayList.add(new Item("펩시 제로", 2000, 0));
        drinkArrayList.add(new Item("스프라이트", 2000, 0));
        drinkArrayList.add(new Item("스프라이트 제로", 2000, 0));
        return drinkArrayList;
    }

    public static ArrayList<Item> addSide(ArrayList<Item> sideArrayList){
        sideArrayList.add(new Item("너겟킹", 2500, 0));
        sideArrayList.add(new Item("해쉬 브라운", 1800, 0));
        sideArrayList.add(new Item("치즈스틱", 1200, 0));
        sideArrayList.add(new Item("어니언링", 2400, 0));
        sideArrayList.add(new Item("바삭킹", 3000, 0));
        sideArrayList.add(new Item("감자튀김", 2000, 0));
        return sideArrayList;
    }
    public static ArrayList<Item> shoppingBasket = new ArrayList<>();

    // todo 장바구니에 선택된 메뉴 담고, 가격 총합을 담는 변수 필요.  || 개수(count) 관련 건은 원함수에서 더해줬기에 신경 안 써도 됨.
    public static void addShoppingBasket(Item food){
    }


    public static final int MinInputNum = 0;
    public static final int MaxInputNum = 6;

    public static void printSideMenu(ArrayList<Item> side) {
        System.out.println("=====사이드 메뉴=====");
        System.out.println("1. 너겟킹 (2500원)");
        System.out.println("2. 해쉬 브라운 (1800원)");
        System.out.println("3. 치즈스틱 (1200원)");
        System.out.println("4. 어니언링 (2400원)");
        System.out.println("5. 바삭킹 (3000원)");
        System.out.println("6. 감자튀김 (2000원)\n");
        System.out.print("메뉴선택 (0을 선택 시 홈으로):");

        int selectInt = getIntByUser();
        checkInputNumberRange(selectInt);

        Item selectSide = new Item(side.get(selectInt+1).itemName, side.get(selectInt+1).price, side.get(selectInt+1).count);
        if(selectInt != MinInputNum) addShoppingBasket(selectSide);

        System.out.println("선택하신 메뉴가 정상적으로 추가되었습니다.\n");
    }

    public static void printDrinkMenu(ArrayList<Item> drink) {
        System.out.println("=====음료 메뉴=====");
        System.out.println("1. 코카콜라 (2000원)");
        System.out.println("2. 코카콜라 제로 (2000원)");
        System.out.println("3. 펩시 (2000원)");
        System.out.println("4. 펩시 제로 (2000원)");
        System.out.println("5. 스프라이트 (2000원)");
        System.out.println("6. 스프라이트 제로 (2000원)");
        System.out.print("메뉴선택 (0을 선택 시 홈으로):");

        int selectInt = getIntByUser();
        checkInputNumberRange(selectInt);

        Item selectSide = new Item(drink.get(selectInt+1).itemName, drink.get(selectInt+1).price, drink.get(selectInt+1).count);
        if(selectInt != MinInputNum) addShoppingBasket(selectSide);

        System.out.println("선택하신 메뉴가 정상적으로 추가되었습니다.\n");
    }

    public static void checkInputNumberRange(int selectInt){
        if(selectInt < MinInputNum || MaxInputNum < selectInt) throw new IllegalArgumentException("잘못된 메뉴를 선택하셨습니다.");
    }

    public static void printBurgerMenu(ArrayList<Item> burger) {
        System.out.println("=====햄버거 메뉴=====");
        System.out.println("1. 와퍼 (6900원)");
        System.out.println("2. 큐브 스테이크 와퍼 (8900원)");
        System.out.println("3. 콰트로 치즈 와퍼 (7900원)");
        System.out.println("4. 몬스터 와퍼 (9300원)");
        System.out.println("5. 통새우 와퍼 (7900원)");
        System.out.println("6. 블랙바베큐 와퍼 (9300원)\n");
        System.out.print("메뉴선택 (0을 선택 시 홈으로): ");

        int selectInt = getIntByUser();
        checkInputNumberRange(selectInt);

        Item selectSide = new Item(burger.get(selectInt+1).itemName, burger.get(selectInt+1).price, burger.get(selectInt+1).count);
        if(selectInt != MinInputNum) addShoppingBasket(selectSide);

        System.out.println("선택하신 메뉴가 정상적으로 추가되었습니다.\n");
    }

    public static void printHome(){
        System.out.println("=====홈=====");
        System.out.println("1. 햄버거");
        System.out.println("2. 사이드");
        System.out.println("3. 음료");
        System.out.println("4. 장바구니");
        System.out.println("5. 종료\n");
        System.out.print("메뉴선택:");
    }

}
