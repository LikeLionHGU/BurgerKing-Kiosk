package kiosk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MenuInfoTest {
  MenuInfo menuInfo;
  MenuItem menuItem;

  private Map<String, Integer> basket = new HashMap<>();
  List<MenuItem> hamburgers = new ArrayList<>();

  @BeforeEach
  void setUp() {
    menuInfo = new MenuInfo();
  }

  @AfterEach
  void tearDown() {
    menuInfo = null;
  }

  @Test
  void 와퍼를_담은_후_basket의_상태() {
    // given
    hamburgers.add(new Hamburger("와퍼", 6900, 0));
    basket.put("와퍼", 6900);
    // then
    assertEquals(6900, basket.get("와퍼"));
  }

  @Test
  void 수량이_50_넘을_경우() {
    // given
    int newQuantity = 51;
    // then
    assertThrows(
        IllegalArgumentException.class, () -> menuInfo.validMenuNumber(newQuantity, 0, 50));
    }
}
