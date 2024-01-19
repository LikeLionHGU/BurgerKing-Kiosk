package kiosk;

public class Controller {

  Print print = new Print();

  private String[] pickedMenu;

  private String[] hamburgerNameInController;
  private int[] hamburgerPriceInController;

  private String[] sidemenuNameInController;
  private int[] sidemenuPriceInController;

  private String[] drinkNameInController;
  private int[] drinkPriceInController;

  public void initEveryInfo() {
    hamburgerNameInController =
            new String[] {"와퍼", "큐브 스테이크 와퍼", "콰트로 치즈 와퍼", "몬스터 와퍼", "통새우 와퍼", "블랙바베큐 와퍼"};
    hamburgerPriceInController = new int[] {6900, 8900, 7900, 9300, 7900, 9300};

    sidemenuNameInController = new String[] {"너겟킹", "해쉬 브라운", "치즈 스틱", "어니언링", "바삭킹", "감자튀김"};
    sidemenuPriceInController = new int[] {2500, 1800, 1200, 2400, 3000, 2000};

    drinkNameInController = new String[] {"코카콜라", "코카콜라 제로", "펩시", "펩시 제로", "스프라이트", "스프라이트 제로"};
    drinkPriceInController = new int[] {2000, 2000, 2000, 2000, 2000, 2000};
  }




  public void controllHomeMenu(int paraDecision) {

    if (isTheNumberOutOfRange(paraDecision, 5)) {
      System.exit(0);
    }

    if (paraDecision == 1) {
      print.printMenuInfo(hamburgerNameInController, hamburgerPriceInController);
    } else if (paraDecision == 2) {

      print.printMenuInfo(sidemenuNameInController, sidemenuPriceInController);

    } else if (paraDecision == 3) {
      print.printMenuInfo(drinkNameInController, drinkPriceInController);

    } else if (paraDecision == 4) {
      //    장바구니
    } else if (paraDecision == 5) {
      //    종료
    }
  }

  public boolean isTheNumberOutOfRange(int number, int max) {
    boolean checkRange = true;
    try {
      if (number > max || number < 0) {
        throw new IllegalArgumentException();
      } else {
        checkRange = false;
        return checkRange;
      }
    } catch (IllegalArgumentException e) {
      System.out.println("\n === 올바르지 않은 입력입니다. ===");
    }
    return checkRange;
  }

  public String[] getHamburgerNameInController() {
    return hamburgerNameInController;
  }

  public void setHamburgerNameInController(String[] hamburgerNameInController) {
    this.hamburgerNameInController = hamburgerNameInController;
  }

  public int[] getHamburgerPriceInController() {
    return hamburgerPriceInController;
  }

  public void setHamburgerPriceInController(int[] hamburgerPriceInController) {
    this.hamburgerPriceInController = hamburgerPriceInController;
  }

  public String[] getSidemenuNameInController() {
    return sidemenuNameInController;
  }

  public void setSidemenuNameInController(String[] sidemenuNameInController) {
    this.sidemenuNameInController = sidemenuNameInController;
  }

  public int[] getSidemenuPriceInController() {
    return sidemenuPriceInController;
  }

  public void setSidemenuPriceInController(int[] sidemenuPriceInController) {
    this.sidemenuPriceInController = sidemenuPriceInController;
  }

  public String[] getDrinkNameInController() {
    return drinkNameInController;
  }

  public void setDrinkNameInController(String[] drinkNameInController) {
    this.drinkNameInController = drinkNameInController;
  }

  public int[] getDrinkPriceInController() {
    return drinkPriceInController;
  }

  public void setDrinkPriceInController(int[] drinkPriceInController) {
    this.drinkPriceInController = drinkPriceInController;
  }

  public String[] getPickedMenu() {
    return pickedMenu;
  }

  public void setPickedMenu(String[] pickedMenu) {
    this.pickedMenu = pickedMenu;
  }
}
