package kiosk;

public class BurgerKingMenu {
    private final static Hamburger [] hamburgerList= {
            new Hamburger("와퍼",6900),
            new Hamburger("큐브 스테이크 와퍼",8900),
            new Hamburger("콰트로 치즈 와퍼",7900),
            new Hamburger("몬스터 와퍼",9300),
            new Hamburger("통새우 와퍼",7900),
            new Hamburger("블랙바베큐 와퍼",9300),};

    private final static SideMenu [] sideMenuList= {
            new SideMenu("너겟킹",2500),
            new SideMenu("해쉬 브라운",1800),
            new SideMenu("치즈 스틱",1200),
            new SideMenu("어니언링",2400),
            new SideMenu("바삭킹",3000),
            new SideMenu("감자튀김",2000),
    };

    private final static Beverage [] beverageList= {
            new Beverage("코카콜라",2000),
            new Beverage("코카콜라 제로",2000),
            new Beverage("펲시",2000),
            new Beverage("펲시 제로",2000),
            new Beverage("스프라이트",2000),
            new Beverage("스프라이트 제로",2000),
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
}
