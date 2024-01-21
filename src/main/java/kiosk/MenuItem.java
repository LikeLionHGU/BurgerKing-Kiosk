package kiosk;

public interface MenuItem {
    String getName();
    int getPrice();
    int getCount();

    void setCount(int i);
}
