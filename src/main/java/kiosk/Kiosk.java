package Beverage.src.main.java.kiosk;

import java.util.Scanner;


// 클래스 생성자
public class Kiosk {
  private Cart cart;
  private Scanner scanner;

  public Kiosk() {
    this.cart = new Cart();
    this.scanner = new Scanner(System.in);
  }

  // 메뉴를 고르는 메소드
  public void MenuChoice() {
    boolean isRunning = true;
    while (isRunning) {
      System.out.println("=====홈=====\n1. 햄버거\n2. 사이드\n3. 음료\n4. 장바구니\n5. 종료\n");
      System.out.print("메뉴선택: ");

      // switch 문을 사용하여 원하는 메뉴를 고르고 그에 맞는 메소드로 이동
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          ChoiceBurger();       //버거 메소드
          break;
        case 2:
          selectSideMenu();     // 사이드 메뉴 메소드
          break;
        case 3:
          ChoiceDrink();        // 음료 메소드
          break;
        case 4:
          cartManage();         // 장바구니 메소드
          break;
        case 5:
          System.out.println("애플리케이션이 종료됩니다.");
          isRunning = false;
          break;
        default:
          System.out.println("잘못된 입력입니다.");
      }
    }
    scanner.close();
  }


  // 맛있는 사이드 메뉴 메소드
    private void selectSideMenu() {
        System.out.println("=====사이드 메뉴=====\n1. 너겟킹 (2500원)\n2. 해쉬 브라운 (1800원)\n3. 치즈스틱 (1200원)\n4. 어니언링 (2400원)\n5. 바삭킹 (3000원)\n6. 감자튀김 (2000원)\n7. 뒤로가기\n");
        System.out.print("메뉴선택: ");
        int sideChoice = scanner.nextInt();

        // switch문을 사용하여 로직 구현
        switch (sideChoice) {
            case 1:
                cart.addItem("너겟킹", 1, 2500);
                System.out.println("너겟킹이 장바구니에 추가되었습니다.");
                break;
            case 2:
                cart.addItem("해쉬 브라운", 1, 1800);
                System.out.println("어니언링이 장바구니에 추가되었습니다.");
                break;
            case 3:
                cart.addItem("치즈스틱", 1, 1200);
                System.out.println("어니언링이 장바구니에 추가되었습니다.");
                break;
            case 4:
                cart.addItem("어니언링", 1, 2400);
                System.out.println("어니언링이 장바구니에 추가되었습니다.");
                break;
            case 5:
                cart.addItem("바삭킹", 1, 3000);
                System.out.println("어니언링이 장바구니에 추가되었습니다.");
                break;
            case 6:
                cart.addItem("감자튀김", 1, 200);
                System.out.println("감자튀김이 장바구니에 추가되었습니다.");
                break;
            case 7:
                return; // 홈으로 돌아가기
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }


    // 맛있는 음료 메소드
    private void ChoiceDrink() {
        System.out.println("=====음료 메뉴=====\n1. 코카콜라 (2000원)\n2. 코카콜라 제로 (2000원)\n3. 펩시 (2000원)\n4. 펩시 제로 (2000원)\n5. 스프라이트 (2000원)\n6. 스프라이트 제로 (2000원)\n7. 뒤로가기\n");
        System.out.print("메뉴선택: ");
        int drinkChoice = scanner.nextInt();

        // 마찬가지로 switch 문 활용
        switch (drinkChoice) {
            case 1:
                cart.addItem("코카콜라", 1, 2000);
                System.out.println("코카콜라가 장바구니에 추가되었습니다.");
                break;
            case 2:
                cart.addItem("코카콜라 제로", 1, 2000);
                System.out.println("코카콜라 제로가 장바구니에 추가되었습니다.");
                break;
            case 3:
                cart.addItem("펩시", 1, 2000);
                System.out.println("펩시가 장바구니에 추가되었습니다.");
                break;
            case 4:
                cart.addItem("펩시제로", 1, 2000);
                System.out.println("스프라이트가 장바구니에 추가되었습니다.");
                break;
            case 5:
                cart.addItem("스프라이트", 1, 2000);
                System.out.println("스프라이트가 장바구니에 추가되었습니다.");
                break;
            case 6:
                cart.addItem("스프라이트 제로", 1, 2000);
                System.out.println("스프라이트 제로가 장바구니에 추가되었습니다.");
                break;
            case 7:
                return; // 홈으로 돌아가기
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }

    // 맛있는 버거 메소드
    private void ChoiceBurger() {
        System.out.println("=====햄버거 메뉴=====\n1. 와퍼 (8900원)\n2. 큐브 스테이크 와퍼 (7900원)\n3. 콰트로 치즈 와퍼 (9300원)\n4. 몬스터 와퍼 (9300원)\n5. 통새우 와퍼 (7900원)\n6. 블랙 바베큐 와퍼 (9300원)\n7. 뒤로가기\n");
        System.out.print("메뉴선택: ");
        int burgerChoice = scanner.nextInt();

        switch (burgerChoice) {
            case 1:
                cart.addItem("와퍼", 1, 8900);
                System.out.println("와퍼가 장바구니에 추가되었습니다.");
                break;
            case 2:
                cart.addItem("큐브 스테이크 와퍼", 1, 7900);
                System.out.println("큐스 스테이크 와퍼가 장바구니에 추가되었습니다.");
                break;
            case 3:
                cart.addItem("콰트로 치즈 와퍼", 1, 9300);
                System.out.println("콰트로 치즈 와퍼가 장바구니에 추가되었습니다.");
                break;
            case 4:
                cart.addItem("몬스터 와퍼", 1, 9300);
                System.out.println("몬스터 와퍼가 장바구니에 추가되었습니다.");
                break;
            case 5:
                cart.addItem("통새우 와퍼", 1, 7900);
                System.out.println("통새우 와퍼가 장바구니에 추가되었습니다.");
                break;
            case 6:
                cart.addItem("블랙 바베큐 와퍼", 1, 9300);
                System.out.println("블랙 바베큐 와퍼가 장바구니에 추가되었습니다.");
                break;
            case 7:
                return; // 홈으로 돌아가기
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }


    // 장바구니 메소드
    private void cartManage() {
        boolean manageCart = true;
        while (manageCart) {
            System.out.println("=====장바구니=====");
            cart.printCart();
            System.out.println("1. 주문하기\n2. 수량 조절하기\n3. 삭제하기\n4. 뒤로가기\n");
            System.out.print("메뉴선택: ");
            int cartChoice = scanner.nextInt();

            switch (cartChoice) {
                case 1:
                    completeOrder();
                    manageCart = false;
                    break;
                case 2:
                    adjustQuantity();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    manageCart = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 수량조절 메소드
  private void adjustQuantity() {
    System.out.println("수량을 조절할 항목을 선택하세요: ");
    cart.printCart();
    System.out.print("메뉴 번호 선택 (취소하려면 0을 입력): ");
    int itemIndex = scanner.nextInt() - 1;

    if (itemIndex < 0 || itemIndex >= cart.getSize()) {
      System.out.println("잘못된 선택입니다.");
      return;
    }
  }

    // 삭제 메소드
    private void removeItem() {
        System.out.println("삭제할 항목을 선택하세요: ");
        cart.printCart();
        System.out.print("메뉴 번호 선택 (취소하려면 0을 입력): ");
        int itemIndex = scanner.nextInt() - 1;

        if (itemIndex < 0 || itemIndex >= cart.getSize()) {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        cart.removeItem(itemIndex);
        System.out.println("항목이 삭제되었습니다.");
    }


    // 주문완료 메소드
    private void completeOrder() {
        int total = cart.calculateTotal();
        System.out.println("주문이 완료되었습니다. 총 가격: " + total + "원");
    }
}

