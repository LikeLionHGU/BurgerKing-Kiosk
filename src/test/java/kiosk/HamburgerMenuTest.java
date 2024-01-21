package kiosk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburgerMenuTest {
    HamburgerMenu hamburgerMenuTest;

    @BeforeEach
    public void setUp() {
        hamburgerMenuTest = new HamburgerMenu();
    }

    @DisplayName("햄버거 이름 출력 테스트")
    @Test
    void checkError() {
        // when
        int input = 5;
        String result = hamburgerMenuTest.returnBurgerName(input);
        //then
        assertEquals("블랙바베큐 와퍼", result);
    }
}