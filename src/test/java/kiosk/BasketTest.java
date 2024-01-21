package kiosk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

  Basket basket;

  @BeforeEach
  void setUp() {
    basket = new Basket();
  }

  @AfterEach
  void tearDown() {
    basket = null;
  }

  @Test
  void addOrder() {
    basket.addOrder(new Order(new Menu("와퍼", 3500), 1));
    basket.addOrder(new Order(new Menu("콜라", 1500), 2));
    basket.addOrder(new Order(new Menu("감자튀김", 1500), 3));
    assertEquals(3, basket.size());
  }

  @Test
  void getOrder() {
    basket.addOrder(new Order(new Menu("와퍼", 3500), 1));
    basket.addOrder(new Order(new Menu("콜라", 1500), 2));
    basket.addOrder(new Order(new Menu("감자튀김", 1500), 3));
    assertEquals("와퍼", basket.getOrder(0).getName());
    assertEquals("콜라", basket.getOrder(1).getName());
    assertEquals("감자튀김", basket.getOrder(2).getName());
  }

  @Test
  void getOrderException() {
    basket.addOrder(new Order(new Menu("와퍼", 3500), 1));
    basket.addOrder(new Order(new Menu("콜라", 1500), 2));
    basket.addOrder(new Order(new Menu("감자튀김", 1500), 3));
    assertThrows(IllegalArgumentException.class, () -> basket.getOrder(3));
  }

  @Test
  void getOrderList() {
    basket.addOrder(new Order(new Menu("와퍼", 3500), 1));
    basket.addOrder(new Order(new Menu("콜라", 1500), 2));
    basket.addOrder(new Order(new Menu("감자튀김", 1500), 3));
    ArrayList<Order> orderList = basket.getOrderList();
    assertEquals("와퍼", orderList.get(0).getName());
    assertEquals("콜라", orderList.get(1).getName());
    assertEquals("감자튀김", orderList.get(2).getName());
  }

  @Test
  void getTotalPrice() {
    basket.addOrder(new Order(new Menu("와퍼", 3500), 1));
    basket.addOrder(new Order(new Menu("콜라", 1500), 2));
    basket.addOrder(new Order(new Menu("감자튀김", 1500), 3));
    assertEquals(11000, basket.getTotalPrice());
  }

  @Test
  void removeOrder() {
    basket.addOrder(new Order(new Menu("와퍼", 3500), 1));
    basket.addOrder(new Order(new Menu("콜라", 1500), 2));
    basket.addOrder(new Order(new Menu("감자튀김", 1500), 3));
    basket.removeOrder(0);
    assertEquals(2, basket.size());
    assertEquals("콜라", basket.getOrder(0).getName());
    assertEquals("감자튀김", basket.getOrder(1).getName());
  }

  @Test
  void removeOrderException() {
    basket.addOrder(new Order(new Menu("와퍼", 3500), 1));
    basket.addOrder(new Order(new Menu("콜라", 1500), 2));
    basket.addOrder(new Order(new Menu("감자튀김", 1500), 3));
    assertThrows(IllegalArgumentException.class, () -> basket.removeOrder(3));
  }

  @Test
  void size() {
    basket.addOrder(new Order(new Menu("와퍼", 3500), 1));
    basket.addOrder(new Order(new Menu("콜라", 1500), 2));
    basket.addOrder(new Order(new Menu("감자튀김", 1500), 3));
    assertEquals(3, basket.size());
  }

  @Test
  void setOrderCount() {
    basket.addOrder(new Order(new Menu("와퍼", 3500), 1));
    basket.addOrder(new Order(new Menu("콜라", 1500), 2));
    basket.addOrder(new Order(new Menu("감자튀김", 1500), 3));
    basket.setOrderCount(0, 2);
    assertEquals(2, basket.getOrder(0).getCount());
    basket.setOrderCount(1, 4);
    assertEquals(4, basket.getOrder(1).getCount());
    basket.setOrderCount(2, 6);
    assertEquals(6, basket.getOrder(2).getCount());
  }

  @Test
  void setOrderCountException() {
    basket.addOrder(new Order(new Menu("와퍼", 3500), 1));
    basket.addOrder(new Order(new Menu("콜라", 1500), 2));
    basket.addOrder(new Order(new Menu("감자튀김", 1500), 3));
    assertThrows(IllegalArgumentException.class, () -> basket.setOrderCount(3, 1));
  }
}
