package kiosk;

import java.util.ArrayList;

public class Basket {
  private final ArrayList<Order> orderList = new ArrayList<>();

  public void addOrder(Order order) {
    orderList.add(order);
  }

  public ArrayList<Order> getOrderList() {
    return orderList;
  }

  public int getTotalPrice() {
    int totalPrice = 0;
    for (Order order : orderList) {
      totalPrice += order.calculatePrice();
    }
    return totalPrice;
  }

  public void removeOrder(int index) {
    checkValidationIndex(index);
    orderList.remove(index);
  }

  public Order getOrder(int index) {
    checkValidationIndex(index);
    return orderList.get(index);
  }

  public int size() {
    return orderList.size();
  }

  public void setOrderCount(int index, int count) {
    checkValidationIndex(index);
    orderList.get(index).setCount(count);
  }

  public void checkValidationIndex(int index) {
    if (index < 0 || index >= orderList.size()) {
      throw new IllegalArgumentException("주문 번호는 1부터 " + orderList.size() + "까지 입니다.");
    }
  }
}
