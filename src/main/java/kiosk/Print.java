package kiosk;

public class Print {

    public void printHomeMenu() {
        System.out.println("=====홈=====");
        System.out.println("1. 햄버거");
        System.out.println("2. 사이드");
        System.out.println("3. 음료");
        System.out.println("4. 장바구니");
        System.out.println("5. 종료");

        System.out.println("\n메뉴선택: ");

    }

    public void printMenuInfo(String[] menuName, int[] menuPrice) {
        for (int i = 0; i < menuName.length; i++) {
            System.out.println((i + 1) + ". " + menuName[i] + "  (" + menuPrice[i] + ")");
        }
        System.out.println("\n메뉴선택 (0을 선택 시 홈으로): ");
    }
}
