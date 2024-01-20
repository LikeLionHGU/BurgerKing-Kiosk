package kiosk;

public class Application {
  public static void main(String[] args) {

    // TODO: 구현
    Input input = new Input();
    Controller controller = new Controller();
    Print print = new Print();

    controller.initEveryInfo();

    while (controller.isExitCondition()) {
      System.out.println("현재 가격 : "+controller.getTotalPrice());
      print.printHomeMenu();

      controller.controlHomeMenu(input.getInputOfHomeMenu());
    }
    System.out.println("== 결제중입니다... ==");
    System.out.println("== ... ==");




  }
}
