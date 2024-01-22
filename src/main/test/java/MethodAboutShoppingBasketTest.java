package kiosk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodAboutShoppingBasketTest {
    CheckException checkException = new CheckException();

    @Test
    void getChangeMenuCountByUser() {
        int changeCount = 51;

        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            checkException.checkCountByUserRangeMax(changeCount);
        });
    }

    @Test
    void getChangeMenuCountByUser2() {
        int changeCount = 0;

        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            checkException.checkCountByUserRangeMin(changeCount);
        });
    }
}
