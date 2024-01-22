package kiosk;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class FunctionAboutFirstInputTest {
	CheckException checkException = new CheckException();

  @Test
  void printBurgerMenu() {
	  int selectInt = -1;
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> checkException.checkInputRange(selectInt));
	}

	@Test
	void printSideMenu() {
		int selectInt = 7;
		Exception exception =
			assertThrows(IllegalArgumentException.class, () -> checkException.checkInputRange(selectInt));
	}

	@Test
	void printDrinkMenu() {
		int selectInt = 11;
		Exception exception =
			assertThrows(IllegalArgumentException.class, () -> checkException.checkInputRange(selectInt));
	}

	@Test
	void editCountInShoppingBasket() {
		ArrayList<Item> shoppingBasket = new ArrayList<>();
		shoppingBasket.add(new Item("와퍼",6900));
		shoppingBasket.add(new Item("코카콜라",2000));
		shoppingBasket.get(0).count=21;
		shoppingBasket.get(1).count=51;

	    assertThrows(IllegalArgumentException.class, ()->{
		    for(Item it : shoppingBasket){
			    checkException.checkCountByUserRangeMax(it.count);
			}
	    });
	  }
}