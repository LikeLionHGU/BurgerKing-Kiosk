package kiosk;
import java.util.*;
import java.util.stream.Collectors;

public class Buyer {
    ArrayList<Product> cart = new ArrayList<>();//cart 배열
    int cost; // 지불할 가격

    Scanner sc = new Scanner(System.in);
    void addToCart(Product p) {
        // 반복문을 통해 같은 객체가 발견되면 갯수를 올립니다.
        for (Product tmp : cart) {
            if (tmp.getName() == p.getName()){
            tmp.increaseQuantities();
            System.out.println("메뉴가 추가되었습니다.");
            return;} // 수량만 올리고 종료
        }
        // 객체가 발견되지 않으면 cart에 넣습니다.
        cart.add(p);
        System.out.println("메뉴가 추가되었습니다.");

    }
    int deleteFromCart() {
        int i = 0;
        System.out.println("\n===== 삭제하기 =====");
        System.out.println("\n현재 장바구니\n");
        for (Product p : cart) {
            ++i;
            System.out.println(i + ". " + p.toString() +" " + p.getQuantities() + "개"); // 갯수 구현
        }
        System.out.print("\n삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        int menuNum = sc.nextInt(); // 삭제할 메뉴 번호 선택
        if(menuNum > i || menuNum < 0) throw new IllegalArgumentException("오류 : 잘못된 번호 입력");
        if (menuNum == 0) return 0; // 0번 선택시 홈으로
        else {
            System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
            int deleteOrHome = sc.nextInt();
            if(deleteOrHome == 1){
                cart.remove(menuNum-1); //삭제 기능 구현
                System.out.println("메뉴가 삭제되었습니다.");
                return 0;
            }
            else if (deleteOrHome == 0) // 0번 선택시 홈으로
                return 1;
            else {
                throw new IllegalArgumentException("오류 : 잘못된 번호 입력");
            }

        }

    }



    int adjustQuantities(){
            int i = 0 ;
            System.out.println("\n===== 수량 조절하기 =====");
            System.out.println("\n현재 장바구니\n");
            for (Product p : cart) {
                ++i;
                System.out.println(i + ". " + p.toString() +" " + p.getQuantities() + "개"); // 갯수 구현
            }
            System.out.print("\n수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
            int menuNum = sc.nextInt(); // 조절할 메뉴 번호 선택
            if(menuNum > i || menuNum < 0) throw new IllegalArgumentException("오류 : 잘못된 번호 입력");
            if(menuNum == 0) return 1; // 0 선택 시 back = 1 활성화, 홈으로
            Product tmp = cart.get(menuNum-1);
            System.out.print("변경할 수량을 입력하세요: ");
            int quantities = sc.nextInt(); // 조절할 개수 입력
            tmp.adjustQuantities(quantities);
            System.out.println("메뉴의 수량이 수정되었습니다.");
            return 0;// back = 0 비활성화, 이전화면
    }

    void printCartList() {
        int back = 0 ;

        while(true) {
            int cost = 0 ;
            System.out.println("\n===== 장바구니 =====\n");
            for (Product p : cart) {
                cost += p.getTotalPrice();
                System.out.println("- " + p.toString() + " " + p.getQuantities() + "개"); // 갯수 구현
            }
            System.out.println("\n====================");
            System.out.println("1. 주문하기 ");
            System.out.println("2. 수량 조절하기");
            System.out.println("3. 삭제하기 \n");

            System.out.println("총 가격: " + cost + "원\n");
            System.out.print("메뉴선택 (0을 선택 시 홈으로): ");
            int num = sc.nextInt();

            if (num == 1) {
                System.out.println("\n주문이 완료되었습니다.\n");
                System.exit(0);
            } else if (num == 2) {
                back = adjustQuantities();
            } else if (num == 3) {
                back = deleteFromCart(); // 1일경우 다시 반복문 돌아가
            } else if (num == 0) {
                back = 1;
            }

            if(back == 1)
                return;
        }

    }

}
