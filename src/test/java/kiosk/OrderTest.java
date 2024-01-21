package kiosk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
  Menu[] menus;
  Order[] orders;

  @BeforeEach
  void setUp() {
    menus = new Menu[] {new Menu("와퍼", 3500), new Menu("콜라", 1500), new Menu("감자튀김", 1500)};
    orders = new Order[] {new Order(menus[0], 1), new Order(menus[1], 2), new Order(menus[2], 3)};
  }

  @AfterEach
  void tearDown() {
    menus = null;
    orders = null;
  }

  @Test
  void calculatePrice() {
    assertEquals(3500, orders[0].calculatePrice());
    assertEquals(3000, orders[1].calculatePrice());
    assertEquals(4500, orders[2].calculatePrice());
  }

  @Test
  void getName() {
    assertEquals("와퍼", orders[0].getName());
    assertEquals("콜라", orders[1].getName());
    assertEquals("감자튀김", orders[2].getName());
  }

  @Test
  void getCount() {
    assertEquals(1, orders[0].getCount());
    assertEquals(2, orders[1].getCount());
    assertEquals(3, orders[2].getCount());
  }

  @Test
  void addCount() {
    orders[0].addCount(1);
    assertEquals(2, orders[0].getCount());
    orders[1].addCount(2);
    assertEquals(4, orders[1].getCount());
    orders[2].addCount(3);
    assertEquals(6, orders[2].getCount());
  }

  @Test
  void addCountException() {
    assertThrows(IllegalArgumentException.class, () -> orders[0].addCount(-Order.MIN_COUNT));
    assertThrows(IllegalArgumentException.class, () -> orders[1].addCount(Order.MAX_COUNT - 1));
  }

  @Test
  void setCount() {
    orders[0].setCount(2);
    assertEquals(2, orders[0].getCount());
    orders[1].setCount(4);
    assertEquals(4, orders[1].getCount());
    orders[2].setCount(6);
    assertEquals(6, orders[2].getCount());
  }

  @Test
  void setCountException() {
    assertThrows(IllegalArgumentException.class, () -> orders[0].setCount(Order.MIN_COUNT - 1));
    assertThrows(IllegalArgumentException.class, () -> orders[1].setCount(Order.MAX_COUNT + 1));
  }
}
