package kiosk;

public class Order{
    private Menu menu;
    private int count;

    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public int calculatePrice() {
        return menu.getPrice() * count;
    }

    public String getName() {
        return menu.getName();
    }

    public int getCount() {
        return count;
    }
}
