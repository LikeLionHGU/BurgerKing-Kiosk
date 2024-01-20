package kiosk;

public class Application {
  public static void main(String[] args) {

    // TODO: 구현
    Input input = new Input();
    Controller controller = new Controller();
    Print print = new Print();

    controller.initEveryInfo();

    while (controller.isExitCondition()) {
      print.printHomeMenu();

      controller.controlHomeMenu(input.getInputOfHomeMenu());
    }
    System.out.println("== 결제중입니다... ==");
    System.out.println("== ... ==");




  }
}
