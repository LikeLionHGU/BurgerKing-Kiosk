package kiosk;

public class Application {
  public static void main(String[] args) {

    // TODO: 구현
    Input input = new Input();
    Controller controller = new Controller();
    Print print = new Print();


    controller.initEveryInfo();
    print.printHomeMenu();


    controller.controllHomeMenu(input.getInputOfHomeMenu());
  }
}
