package kiosk;
import java.util.ArrayList;


public class Application {
    public static ArrayList<Item> shoppingBasket = new ArrayList<>();
    public static void main(String[] args) {
        FunctionAboutFirstInput functionAboutFirstInput = new FunctionAboutFirstInput();
        Run run = new Run();

        System.out.println("프로그램 실행 시작!");
        ArrayList<Item> burgerArrayList = new ArrayList<>();
        burgerArrayList = MenuToArray.addBurger(burgerArrayList);
        ArrayList<Item> sideArrayList = new ArrayList<>();
        sideArrayList = MenuToArray.addSide(sideArrayList);
        ArrayList<Item> drinkArrayList = new ArrayList<>();
        drinkArrayList = MenuToArray.addDrink(drinkArrayList);

        for(;;) {
            functionAboutFirstInput.printHome();
            run.runProgram(burgerArrayList, sideArrayList, drinkArrayList);
        }
    }


}

