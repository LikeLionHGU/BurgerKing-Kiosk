package kiosk;

public class Application {
  public static void main(String[] args) {

    // TODO: 구현
    Input input = new Input();
    Controller controller = new Controller();
    Print print = new Print();



    while (controller.isExitCondition()) {
      System.out.println("현재 가격 : " + controller.getTotalPrice());
      print.printHomeMenu();

      controller.controlHomeMenu(input.getInputOfHomeMenu());
    }

    if (controller.isHasOrder()) {
      System.out.println("== 결제중입니다... ==");
      System.out.println("== ... ==");

      controller.assignWaitingNumber();
    } else{
      System.out.println("주문을 종료합니다");
    }
  }
}
