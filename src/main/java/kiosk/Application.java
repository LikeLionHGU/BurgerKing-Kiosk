package kiosk;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenuList();
            int num = sc.nextInt(); // 사용자 입력
            if (num == 1)
                printBugerList(b);
            else if (num == 2)
                printSideList(b);
            else if (num == 3)
                printDrinkList(b);
            else if (num == 4)
                b.printCartList();
            else if (num == 5){
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            else throw new IllegalArgumentException("오류 : 잘못된 번호 입력");
        }
//        choiceMenu(num);

//        b.addToCart();
    }
    static void homeScreen(){

    }
    static void printMenuList() {
        System.out.print(
                        "=====홈=====\n" +
                        "\n" +
                        "1. 햄버거\n" +
                        "2. 사이드\n" +
                        "3. 음료\n" +
                        "4. 장바구니\n" +
                        "5. 종료\n" +
                        "\n" +
                        "메뉴선택: ");
        ;}
    static void printBugerList(Buyer b) {
        Scanner sc = new Scanner(System.in);
        System.out.print(
                "=====햄버거 메뉴=====\n " +
                        "\n " +
                        "1. 와퍼 (6900원)\n " +
                        "2. 큐브 스테이크 와퍼 (8900원)\n " +
                        "3. 콰트로 치즈 와퍼 (7900원)\n " +
                        "4. 몬스터 와퍼 (9300원)\n " +
                        "5. 통새우 와퍼 (7900원)\n " +
                        "6. 블랙바베큐 와퍼 (9300원)\n " +
                        "\n" +
                        "메뉴선택 (0을 선택 시 홈으로): ");
        int num = sc.nextInt();
        if (num == 1) {
            Buger bg = new Buger("와퍼", 6900);
            b.addToCart(bg);
            return;
        } else if (num == 2) {
            Buger bg = new Buger("큐브 스테이크 와퍼", 8900);
            b.addToCart(bg);
            return;
        } else if (num == 3) {
            Buger bg = new Buger("콰트로 치즈 와퍼", 7900);
            b.addToCart(bg);
            return;
        } else if (num == 4) {
            Buger bg = new Buger("몬스터 와퍼", 9300);
            b.addToCart(bg);
            return;
        } else if (num == 5) {
            Buger bg = new Buger("통새우 와퍼", 7900);
            b.addToCart(bg);
            return;
        } else if (num == 6) {
            Buger bg = new Buger("블랙바베큐 와퍼", 9300);
            b.addToCart(bg);
            return;
        }
        else if (num == 0)
            return;
        else throw new IllegalArgumentException("오류 : 잘못된 번호 입력");

    }

    static void printSideList(Buyer b){
        Scanner sc = new Scanner(System.in);
        System.out.print(
                            "=====사이드 메뉴=====\n" +
                            "\n" +
                            "1. 너겟킹 (2500원)\n" +
                            "2. 해쉬 브라운 (1800원)\n" +
                            "3. 치즈스틱 (1200원)\n" +
                            "4. 어니언링 (2400원)\n" +
                            "5. 바삭킹 (3000원)\n" +
                            "6. 감자튀김 (2000원)\n" +
                            "\n" +
                            "메뉴선택 (0을 선택 시 홈으로): ");
        int num = sc.nextInt();
        if (num == 1) {
            Side si = new Side("너겟킹", 2500);
            b.addToCart(si);
            return;
        } else if (num == 2) {
            Side si = new Side("해쉬 브라운", 1800);
            b.addToCart(si);
            return;
        } else if (num == 3) {
            Side si = new Side("치즈스틱", 1200);
            b.addToCart(si);
            return;
        } else if (num == 4) {
            Side si = new Side("어니언링", 2400);
            b.addToCart(si);
            return;
        } else if (num == 5) {
            Side si = new Side("바삭킹", 3000);
            b.addToCart(si);
            return;
        } else if (num == 6) {
            Side si = new Side("감자튀김", 2000);
            b.addToCart(si);
            return;
        }
            else if (num == 0)
            return;
            else throw new IllegalArgumentException("오류 : 잘못된 번호 입력");
        }
    static void printDrinkList(Buyer b){
        Scanner sc = new Scanner(System.in);
        System.out.print(
                            "=====음료 메뉴=====\n" +
                            "\n" +
                            "1. 코카콜라 (2000원)\n" +
                            "2. 코카콜라 제로 (2000원)\n" +
                            "3. 펩시 (2000원)\n" +
                            "4. 펩시 제로 (2000원)\n" +
                            "5. 스프라이트 (2000원)\n" +
                            "6. 스프라이트 제로 (2000원)\n" +
                            "\n" +
                            "메뉴선택 (0을 선택 시 홈으로):");
        int num = sc.nextInt();
        if (num == 1) {
            Drink d = new Drink("코카콜라", 2000);
            b.addToCart(d);
            return;
        } else if (num == 2) {
            Drink d = new Drink("코카콜라 제로", 2000);
            b.addToCart(d);
            return;
        } else if (num == 3) {
            Drink d = new Drink("펩시", 2000);
            b.addToCart(d);
            return;
        } else if (num == 4) {
            Drink d = new Drink("펩시 제로", 2000);
            b.addToCart(d);
            return;
        } else if (num == 5) {
            Drink d = new Drink("스프라이트", 2000);
            b.addToCart(d);
            return;
        } else if (num == 6) {
            Drink d = new Drink("스프라이트 제로", 2000);
            b.addToCart(d);
            return;
        }
        else if (num == 0)
            return;
        else throw new IllegalArgumentException("오류 : 잘못된 번호 입력");
    }
}
