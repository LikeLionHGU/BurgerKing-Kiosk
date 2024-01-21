package kiosk;

public class Order {
  private final Menu menu;
  private int count;

  public static int MAX_COUNT = 50;

  public static int MIN_COUNT = 1;

  public Order(Menu menu, int count) {
    this.menu = menu;
    this.count = count;
  }

  public int calculatePrice() {
    return menu.getPrice() * count;
  }

  public Menu getMenu() {
    return menu;
  }

  public String getName() {
    return menu.getName();
  }

  public int getCount() {
    return count;
  }

  public void addCount(int count) {
    checkValidationCount(count + this.count);
    this.count += count;
  }

  public void setCount(int count) {
    checkValidationCount(count);
    this.count = count;
  }

  private void checkValidationCount(int count) {
    if (count > MAX_COUNT || count < MIN_COUNT) {
      throw new IllegalArgumentException(
          "주문 개수는 " + MIN_COUNT + "개 이상, " + MAX_COUNT + "개 이하이어야 합니다.");
    }
  }
}
