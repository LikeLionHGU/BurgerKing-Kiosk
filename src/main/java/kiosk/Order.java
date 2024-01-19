package kiosk;

public class Order {
  private final Menu menu;
  private int count;

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
    this.count += count;
    checkValidationCount(this.count);
  }

  public void setCount(int count) {
    this.count = count;
  }

  private void checkValidationCount(int count) {
    if (count > 50) {
      throw new IllegalArgumentException("주문 개수는 50개 이하이어야 합니다.");
    }
  }
}
