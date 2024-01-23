import kiosk.Controller;
import kiosk.Input;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    // given

    Controller controller;
    Input input;

    @BeforeEach
    void setUp() {
        controller = new Controller();

        input = new Input();
    }




    @DisplayName("메뉴는 6개인데 7번 메뉴를 시킬 때")
    @Test
    void indexBoundary() {
        // when
        int menu =7;

        // then
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    input.isTheNumberOutOfRange(menu, 5);
                    });
    }

    @DisplayName("수량 변경 시에 50개까지만 가능")
    @Test
    void moreThanFifty() {
        //when
        int nextMenu=51;

        //then
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    input.isMoreThanFifty(nextMenu);
                });

    }

    @AfterEach
    void tearDown() {
        controller = null;

        input = null;
    }
}
