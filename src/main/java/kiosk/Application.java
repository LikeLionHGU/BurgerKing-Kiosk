package kiosk;

import java.util.ArrayList;
import java.util.Scanner;

// todo: 작동 제대로 하는지 확인
// todo: 예외들 확인하기
// todo: class단위로 파일 구분하기

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

    public static void runProgram(ArrayList<Item> burgerArrayList, ArrayList<Item> sideArrayList, ArrayList<Item> drinkArrayList){
        int input = getIntByUser();
        switch(input){
            case 1 -> printBurgerMenu(burgerArrayList);
            case 2 -> printSideMenu(sideArrayList);
            case 3 -> printDrinkMenu(drinkArrayList);
            case 4 -> shoppingBasketOption();
            case 5 -> exitProgram();
            default -> throw new IllegalArgumentException("잘못된 입력으로 인해 프로그램을 종료합니다.");
        }
    }
    public static ArrayList<Item> shoppingBasket = new ArrayList<>();


    public static void shoppingBasketOption() {
        int total = 0;
        System.out.println("===== 장바구니 =====\n");
        for(Item it : shoppingBasket){
            System.out.println("- " + it.itemName + " " + it.count + "개");
            total += (it.count * it.price);
        }
        System.out.println();
        System.out.println("====================");
        System.out.println("1. 주문하기");
        System.out.println("2. 수량 조절하기");
        System.out.println("3. 삭제하기\n");

        System.out.println("총 가격 :  " + total + "원\n");
        System.out.print("메뉴 선택 (0을 선택 시 홈으로): ");
        int selectInt = getIntByUser();
	    if(selectInt == MinInputNum)  return;

        switch(selectInt){
            case 1 -> order();
            case 2 -> controlCount();
            case 3 -> cancelOrder();
            default -> throw new IllegalArgumentException("장바구니 부분에서 잘못된 값을 입력하셨습니다.");
        }
    }

    public static void order() {
        System.out.println("주문이 성공적으로 되었습니다.");
        System.exit(0);
    }

    public static void controlCount(){
        System.out.println("===== 수량 조절하기 =====\n");
        System.out.println("현재 장바구니\n");
        for (Item it : shoppingBasket) {
            System.out.println("- " + it.itemName + " " + it.count + "개");
        }
        System.out.println();
        System.out.print("수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        int changeMenuIndex = getIntByUser();
        System.out.print("변경할 수량을 입력하세요:");
        int chageCount = getIntByUser();
        shoppingBasket.get(changeMenuIndex-1).count = chageCount;
    }

    public static void cancelOrder(){
        System.out.println("===== 삭제하기 =====\n");
        System.out.println("현재 장바구니\n");
        for (Item it : shoppingBasket) {
            System.out.println("- " + it.itemName + " " + it.count + "개");
        }
        System.out.println();
        System.out.print("삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        int deleteIndex = getIntByUser();
        System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
        int decideInputNum = getIntByUser();

        if(decideInputNum == 0) return;
            else if(deleteIndex == 1) shoppingBasket.remove(deleteIndex-1);
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

    public static void addShoppingBasket(Item food){
        food.count++;
        shoppingBasket.add(new Item(food.itemName, food.price, food.count));
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
        checkInputRange(selectInt);

	    if(selectInt == MinInputNum)  return;
	    Item selectSide = new Item(side.get(selectInt-1).itemName, side.get(selectInt-1).price, side.get(selectInt-1).count);
        addShoppingBasket(selectSide);

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
        checkInputRange(selectInt);

        if(selectInt == MinInputNum)  return;
        Item selectSide = new Item(drink.get(selectInt-1).itemName, drink.get(selectInt-1).price, drink.get(selectInt-1).count);
        addShoppingBasket(selectSide);

        System.out.println("선택하신 메뉴가 정상적으로 추가되었습니다.\n");
    }

    public static void checkInputRange(int selectInt){
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
        checkInputRange(selectInt);

	    if(selectInt == MinInputNum)  return;
	    Item selectSide = new Item(burger.get(selectInt-1).itemName, burger.get(selectInt-1).price, burger.get(selectInt-1).count);
        addShoppingBasket(selectSide);

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
