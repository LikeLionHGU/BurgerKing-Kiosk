package kiosk;

public class BurgerKingMenu {
  private static final Hamburger[] hamburgerList = {
    new Hamburger("와퍼", 6900),
    new Hamburger("큐브 스테이크 와퍼", 8900),
    new Hamburger("콰트로 치즈 와퍼", 7900),
    new Hamburger("몬스터 와퍼", 9300),
    new Hamburger("통새우 와퍼", 7900),
    new Hamburger("블랙바베큐 와퍼", 9300),
  };

  private static final SideMenu[] sideMenuList = {
    new SideMenu("너겟킹", 2500),
    new SideMenu("해쉬 브라운", 1800),
    new SideMenu("치즈 스틱", 1200),
    new SideMenu("어니언링", 2400),
    new SideMenu("바삭킹", 3000),
    new SideMenu("감자튀김", 2000),
  };

  private static final Beverage[] beverageList = {
    new Beverage("코카콜라", 2000),
    new Beverage("코카콜라 제로", 2000),
    new Beverage("펩시", 2000),
    new Beverage("펩시 제로", 2000),
    new Beverage("스프라이트", 2000),
    new Beverage("스프라이트 제로", 2000),
  };

  public static Hamburger[] getHamburgerList() {
    return hamburgerList;
  }

  public static SideMenu[] getSideMenuList() {
    return sideMenuList;
  }

  public static Beverage[] getBeverageList() {
    return beverageList;
  }

  public static Hamburger getHamburger(int index) {
    checkIndexValidation(index, hamburgerList.length);
    return hamburgerList[index];
  }

  public static SideMenu getSideMenu(int index) {
    checkIndexValidation(index, sideMenuList.length);
    return sideMenuList[index];
  }

  public static Beverage getBeverage(int index) {
    checkIndexValidation(index, beverageList.length);
    return beverageList[index];
  }

  private static void checkIndexValidation(int index, int length) {
    if (index < 0 || index >= length) {
      throw new IllegalArgumentException("메뉴 번호는 1부터 " + length + "까지 입니다.");
    }
  }

  public static int getHamburgerListLength() {
    return hamburgerList.length;
  }

  public static int getSideMenuListLength() {
    return sideMenuList.length;
  }

  public static int getBeverageListLength() {
    return beverageList.length;
  }
}
