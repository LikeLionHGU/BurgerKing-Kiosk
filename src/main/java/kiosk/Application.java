package kiosk;

public class Application {
  public static void main(String[] args) {

    // TODO: 구현
    Input input = new Input();
    Controller controller = new Controller();
    Print print = new Print();

    controller.initEveryInfo();

    while (controller.exitCondition) {
      print.printHomeMenu();

      controller.controlHomeMenu(input.getInputOfHomeMenu());
    }
    System.out.println("총 가격은 " + controller.getTotalPrice() + "원 입니다.");
    System.out.println("주문은 다음과 같습니다." );

      System.out.println(controller.getOrderNameList());


}
}
