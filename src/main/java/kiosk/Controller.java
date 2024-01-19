package kiosk;

import java.util.ArrayList;
import java.util.List;

public class Controller {

  Print print = new Print();
  Input input = new Input();

  boolean exitCondition = true;
  private String[] pickedMenu;

  private String[] hamburgerName;
  private int[] hamburgerPrice;

  private String[] sidemenuName;
  private int[] sidemenuPrice;

  private String[] drinkName;
  private int[] drinkPrice;


  private int totalPrice;

  private List<String> orderNameList;

  private List<Integer> orderNumList;

  public void initEveryInfo() {
    hamburgerName = new String[] {"와퍼", "큐브 스테이크 와퍼", "콰트로 치즈 와퍼", "몬스터 와퍼", "통새우 와퍼", "블랙바베큐 와퍼"};
    hamburgerPrice = new int[] {6900, 8900, 7900, 9300, 7900, 9300};

    sidemenuName = new String[] {"너겟킹", "해쉬 브라운", "치즈 스틱", "어니언링", "바삭킹", "감자튀김"};
    sidemenuPrice = new int[] {2500, 1800, 1200, 2400, 3000, 2000};

    drinkName = new String[] {"코카콜라", "코카콜라 제로", "펩시", "펩시 제로", "스프라이트", "스프라이트 제로"};
    drinkPrice = new int[] {2000, 2000, 2000, 2000, 2000, 2000};

    totalPrice = 0;

    orderNameList =  new ArrayList<>();
    orderNumList = new ArrayList<>();

  }

  public void controlHomeMenu(int paraDecision) {

    if (input.isTheNumberOutOfRange(paraDecision, 5)) {
      System.exit(0);
    }

    if (paraDecision == 1) {
      controlHamburger();
    } else if (paraDecision == 2) {

      controlSidemenu();
    } else if (paraDecision == 3) {
      controlDrink();
    } else if (paraDecision == 4) {
      //    장바구니
    } else if (paraDecision == 5) {
      exitCondition = false;
    }
  }

  public void controlHamburger() {
    System.out.println("=== 햄버거 ===");
    print.printMenuInfo(hamburgerName, hamburgerPrice);

    int result = input.inputHamburgerOrder();
    totalPrice += hamburgerPrice[result - 1];
    if (!orderNameList.contains(hamburgerName[result])) {

      orderNameList.add(hamburgerName[result - 1]);
    }
  }

  public void controlSidemenu() {
    System.out.println("=== 사이드 ===");
    print.printMenuInfo(sidemenuName, sidemenuPrice);
    int result = input.inputSidemeunOrder();
    totalPrice += sidemenuPrice[result - 1];
    if (!orderNameList.contains(sidemenuName[result])) {

      orderNameList.add(sidemenuName[result - 1]);
    }
  }

  public void controlDrink() {
    System.out.println("=== 음료수 ===");
    print.printMenuInfo(drinkName, drinkPrice);
    int result = input.inputDrinkOrder();
    totalPrice += drinkPrice[result - 1];
    if (!orderNameList.contains(drinkName[result])) {
      orderNameList.add(drinkName[result - 1]);
    }
  }





  public String[] getHamburgerName() {
    return hamburgerName;
  }

  public void setHamburgerName(String[] hamburgerName) {
    this.hamburgerName = hamburgerName;
  }

  public int[] getHamburgerPrice() {
    return hamburgerPrice;
  }

  public void setHamburgerPrice(int[] hamburgerPrice) {
    this.hamburgerPrice = hamburgerPrice;
  }

  public String[] getSidemenuName() {
    return sidemenuName;
  }

  public void setSidemenuName(String[] sidemenuName) {
    this.sidemenuName = sidemenuName;
  }

  public int[] getSidemenuPrice() {
    return sidemenuPrice;
  }

  public void setSidemenuPrice(int[] sidemenuPrice) {
    this.sidemenuPrice = sidemenuPrice;
  }

  public String[] getDrinkName() {
    return drinkName;
  }

  public void setDrinkName(String[] drinkName) {
    this.drinkName = drinkName;
  }

  public int[] getDrinkPrice() {
    return drinkPrice;
  }

  public void setDrinkPrice(int[] drinkPrice) {
    this.drinkPrice = drinkPrice;
  }

  public String[] getPickedMenu() {
    return pickedMenu;
  }

  public void setPickedMenu(String[] pickedMenu) {
    this.pickedMenu = pickedMenu;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public List<String> getOrderNameList() {
    return orderNameList;
  }

  public void setOrderNameList(List<String> orderNameList) {
    this.orderNameList = orderNameList;
  }

  public List<Integer> getOrderNumList() {
    return orderNumList;
  }

  public void setOrderNumList(List<Integer> orderNumList) {
    this.orderNumList = orderNumList;
  }

}
