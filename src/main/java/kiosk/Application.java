package kiosk;
import java.util.ArrayList;

// todo: 작동 제대로 하는지 확인   -> 기능 완성! -> refactor하기 (일단 배치는 정리 완료!) -> 이제 class별로 구분한 다음. -> 예외처리 해주자!
// todo: 예외들 확인하기

public class Application {
    public static ArrayList<Item> shoppingBasket = new ArrayList<>();
    public static void main(String[] args) {
        FunctionAboutFirstInput print = new FunctionAboutFirstInput();

        System.out.println("프로그램 실행 시작!");
        ArrayList<Item> burgerArrayList = new ArrayList<>();
        burgerArrayList = MenuToArray.addBurger(burgerArrayList);
        ArrayList<Item> sideArrayList = new ArrayList<>();
        sideArrayList = MenuToArray.addSide(sideArrayList);
        ArrayList<Item> drinkArrayList = new ArrayList<>();
        drinkArrayList = MenuToArray.addDrink(drinkArrayList);

        for(;;) {
            print.printHome();
            runProgram(burgerArrayList, sideArrayList, drinkArrayList);
        }
    }

    public static void runProgram(ArrayList<Item> burgerArrayList, ArrayList<Item> sideArrayList, ArrayList<Item> drinkArrayList){
        int input = ContactByUser.getIntByUser();
        switch(input){
            case 1 -> FunctionAboutFirstInput.printBurgerMenu(burgerArrayList);
            case 2 -> FunctionAboutFirstInput.printSideMenu(sideArrayList);
            case 3 -> FunctionAboutFirstInput.printDrinkMenu(drinkArrayList);
            case 4 -> FunctionAboutFirstInput.shoppingBasketOption();
            case 5 -> FunctionAboutFirstInput.exitProgram();
            default -> throw new IllegalArgumentException("잘못된 입력으로 인해 프로그램을 종료합니다.");
        }
    }
}

