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

    print.printOrderList(controller.getOrderNameList(),controller.getOrderNumList());



}
}
