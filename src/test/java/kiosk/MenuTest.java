package kiosk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

  Menu menu;

  @BeforeEach
  void setUp() {
    menu = new Menu("와퍼", 3500);
  }

  @AfterEach
  void tearDown() {
    menu = null;
  }

  @Test
  void getName() {
    assertEquals("와퍼", menu.getName());
  }

  @Test
  void getPrice() {
    assertEquals(3500, menu.getPrice());
  }
}
