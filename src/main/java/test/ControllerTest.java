package test;

import kiosk.Controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

  // given
  Controller controller;

  @BeforeEach
  void setUp() {

    controller = new Controller();
  }

  @DisplayName("잘 담기는지 확인해보자 + 사이드 메뉴,음료도 같은 메커니즘이기 때문에 결과는 같다.")
  @Test
  void controlHamburger() {
    // when
    String hamburgerName = "와퍼";
    int hamburgerPrice = 6900;
    int hamburgerNum = 1;

    // then
    //    assertEqual

  }

  @DisplayName("50개보다 크면 예외처리")
  @Test
  void checkrestrictOfMaxNumber() {

    // when
    controller.getOrderNumList().add(0, 50);

    // then
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          controller.restrictNumOfOrder(controller.getOrderNumList().get(0), 1);
        });
  }

  @AfterEach
  void tearDown() {
    controller = null;
  }
}
