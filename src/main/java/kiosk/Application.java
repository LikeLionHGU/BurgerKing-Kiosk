package kiosk;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        BurgerKingKiosk kiosk = new BurgerKingKiosk();
        kiosk.startOrdering();
    }
}

class BurgerKingMenu {
    private Map<String, Double> menuItems;

    public BurgerKingMenu() {
        this.menuItems = new HashMap<>();
        menuItems.put("와퍼", 6900.0);
        menuItems.put("큐브 스테이크 와퍼", 8900.0);
        menuItems.put("콰트로 치즈 와퍼", 7900.0);
        menuItems.put("몬스터 와퍼", 9300.0);
        menuItems.put("통새우 와퍼", 7900.0);
        menuItems.put("블랙바베큐 와퍼", 9300.0);
        menuItems.put("너겟킹", 2500.0);
        menuItems.put("해쉬 브라운", 1800.0);
        menuItems.put("치즈스틱", 1200.0);
        menuItems.put("어니언링", 2400.0);
        menuItems.put("바삭킹", 3000.0);
        menuItems.put("감자튀김", 2000.0);
        menuItems.put("코카콜라", 2000.0);
        menuItems.put("코카콜라 제로", 2000.0);
        menuItems.put("펩시", 2000.0);
        menuItems.put("펩시 제로", 2000.0);
        menuItems.put("스프라이트", 2000.0);
        menuItems.put("스프라이트 제로", 2000.0);
    }

    public Map<String, Double> getMenuItems() {
        return menuItems;
    }
}

class Order {
    private Map<String, Integer> items;

    public Order() {
        this.items = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}

class BurgerKingKiosk {
    private Scanner scanner;
    private BurgerKingMenu menu;
    private Order order;

    public BurgerKingKiosk() {
        this.scanner = new Scanner(System.in);
        this.menu = new BurgerKingMenu();
        this.order = new Order();
    }

    public void startOrdering() {
        while (true) {
            printHomeScreen();

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    showMenuScreen(choice);
                    break;
                case 4:
                    showCartScreen();
                    break;
                case 5:
                    endOrdering();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    private void printHomeScreen() {
        System.out.println("=====홈=====");
        System.out.println("1. 햄버거");
        System.out.println("2. 사이드");
        System.out.println("3. 음료");
        System.out.println("4. 장바구니");
        System.out.println("5. 종료");
        System.out.print("메뉴선택: ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("숫자를 입력하세요.");
            scanner.next(); // 입력 버퍼 비우기
        }
        return scanner.nextInt();
    }

    private void showMenuScreen(int category) {
        System.out.println("=====" + getCategoryName(category) + " 메뉴=====");

        for (Map.Entry<String, Double> entry : menu.getMenuItems().entrySet()) {
            System.out.println(entry.getKey() + " (" + entry.getValue() + "원)");
        }

        System.out.print("메뉴선택 (0을 선택 시 홈으로): ");
        int choice = getUserChoice();

        if (choice != 0) {
            String selectedMenu = getMenuName(category, choice);
            System.out.print("수량을 입력하세요: ");
            int quantity = getUserChoice();
            order.addItem(selectedMenu, quantity);
            System.out.println("주문이 완료되었습니다.");
        }
    }

    private String getCategoryName(int category) {
        switch (category) {
            case 1:
                return "햄버거";
            case 2:
                return "사이드";
            case 3:
                return "음료";
            default:
                return "";
        }
    }

    private String getMenuName(int category, int choice) {
        int index = 1;
        for (Map.Entry<String, Double> entry : menu.getMenuItems().entrySet()) {
            if (index == choice) {
                return entry.getKey();
            }
            index++;
        }
        return "";
    }

    private void showCartScreen() {
        System.out.println("===== 장바구니 =====");

        for (Map.Entry<String, Integer> entry : order.getItems().entrySet()) {
            System.out.println("- " + entry.getKey() + " " + entry.getValue() + "개");
        }

        System.out.println("====================");
        System.out.println("1. 주문하기");
        System.out.println("2. 수량 조절하기");
        System.out.println("3. 삭제하기");
        System.out.println("총 가격: " + calculateTotalPrice() + "원");
        System.out.print("메뉴선택 (0을 선택 시 홈으로): ");
        int choice = getUserChoice();

        switch (choice) {
            case 1:
                endOrdering();
                break;
            case 2:
                adjustQuantity();
                break;
            case 3:
                removeItem();
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
    }

    private void adjustQuantity() {
        System.out.println("===== 수량 조절하기 =====");

        for (Map.Entry<String, Integer> entry : order.getItems().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }

        System.out.print("수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        int choice = getUserChoice();

        if (choice != 0) {
            String selectedMenu = getMenuName(1, choice); // 햄버거 카테고리는 1
            System.out.print("변경할 수량을 입력하세요 (1~50): ");
            int quantity = getUserChoice();

            if (quantity >= 1 && quantity <= 50) {
                order.addItem(selectedMenu, quantity);
                System.out.println("수량이 조절되었습니다.");
            } else {
                System.out.println("1에서 50까지의 값을 입력하세요.");
            }
        }
    }

    private void removeItem() {
        System.out.println("===== 삭제하기 =====");

        for (Map.Entry<String, Integer> entry : order.getItems().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }

        System.out.print("삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        int choice = getUserChoice();

        if (choice != 0) {
            String selectedMenu = getMenuName(1, choice); // 햄버거 카테고리는 1
            System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
            int confirmChoice = getUserChoice();

            if (confirmChoice == 1) {
                order.removeItem(selectedMenu);
                System.out.println("삭제가 완료되었습니다.");
            } else {
                System.out.println("삭제가 취소되었습니다.");
            }
        }
    }

    private int calculateTotalPrice() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : order.getItems().entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            double price = menu.getMenuItems().get(menuName);
            total += quantity * price;
        }
        return total;
    }

    private void endOrdering() {
        System.out.println("주문이 완료되었습니다.");
        scanner.close();
        System.exit(0);
    }

}

