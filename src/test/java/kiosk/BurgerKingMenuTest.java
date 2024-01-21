package kiosk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BurgerKingMenuTest {

  @Test
  void getHamburgerException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> BurgerKingMenu.getHamburger(BurgerKingMenu.getHamburgerListLength() + 1));
    assertThrows(IllegalArgumentException.class, () -> BurgerKingMenu.getHamburger(-1));
  }

  @Test
  void getSideMenuException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> BurgerKingMenu.getSideMenu(BurgerKingMenu.getSideMenuListLength() + 1));
    assertThrows(IllegalArgumentException.class, () -> BurgerKingMenu.getSideMenu(-1));
  }

  @Test
  void getBeverageException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> BurgerKingMenu.getBeverage(BurgerKingMenu.getBeverageListLength() + 1));
    assertThrows(IllegalArgumentException.class, () -> BurgerKingMenu.getBeverage(-1));
  }
}
