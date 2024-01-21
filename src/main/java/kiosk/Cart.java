package Beverage.src.main.java.kiosk;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    // 장바구니에 담긴 상품명 저장
    private List<String> items;

    // 각 상품의 수량을 저장
    private List<Integer> quantities;

    // 각 상품의 가격을 저장
    private List<Integer> prices;


    // 클래스 생성자. 객체 생성시 3개의 리스트 초기화
    public Cart() {
        this.items = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.prices = new ArrayList<>();
    }


    // 선택한 메뉴를 추가하는
    public void addItem(String item, int quantity, int price) {
        items.add(item);                // 상품명을 추가
        quantities.add(quantity);       // 수량을 추가
        prices.add(price);              // 가격을 추가
    }

    // 장바구니의 내용 출력
    public void printCart() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i) + " - " + quantities.get(i) + "개 - " + prices.get(i) + "원");
        }
    }

    // 장바구니에 담긴 모든 상품의 총 가격을 계산
    public int calculateTotal() {
        int total = 0;
        for (int i = 0; i < prices.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }
        return total;
    }

    // 장바구니에 담긴 상품의 개수 반환
    public int getSize() {
        return items.size();
    }

    // 지정된 인덱스의 상품 수량을 업데이트
    public void updateQuantity(int index, int newQuantity) {
        if (index >= 0 && index < quantities.size()) {
            quantities.set(index, newQuantity);
        }
    }

    // 지정된 인덱스의 상품을 장바구니에서 제거함
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            quantities.remove(index);
            prices.remove(index);
        }
    }
}
