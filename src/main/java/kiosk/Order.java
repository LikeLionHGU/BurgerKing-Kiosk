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
  }
}
