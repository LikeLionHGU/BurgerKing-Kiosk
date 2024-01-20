package kiosk;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class ContactByUserTest {
	CheckException checkException = new CheckException();

	@Test
	void selectIndexByUser() {
		int index = -1;
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
			checkException.checkSelectIndexByUserRange(index));
	}

	@Test
	void reconfirmByUser() {
		int index = 2;
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
			checkException.checkReconfirmInputByUser(index));
	}
}