import kiosk.Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    class ControlOrderTest {

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
            controller.getOrderNameList().add(0,"와퍼");
            controller.getOrderPriceList().add(0,6900);
            controller.getOrderNumList().add(0, 1);

            // then
            assertEquals("와퍼",controller.getOrderNameList().get(0));
            assertEquals(6900,controller.getOrderPriceList().get(0));
            assertEquals(1,controller.getOrderNumList().get(0));
        }


        @DisplayName("총 주문 금액이 맞는지 확인하자")
        @Test
        void totalPrice() {
            // when
            controller.getOrderNameList().add(0,"와퍼");
            controller.getOrderPriceList().add(0,6900);
            controller.getOrderNumList().add(0, 1);

            controller.getOrderNameList().add(1,"콜라");
            controller.getOrderPriceList().add(1,2000);
            controller.getOrderNumList().add(1, 4);

            controller.getOrderNameList().add(2,"너겟킹");
            controller.getOrderPriceList().add(2,2500);
            controller.getOrderNumList().add(2, 5);

            controller.getOrderNameList().add(3,"펩시");
            controller.getOrderPriceList().add(3,2000);
            controller.getOrderNumList().add(3, 1);


            controller.recalculateTotalPrice();

            // then
            assertEquals(29400,controller.getTotalPrice());
        }

        @DisplayName("삭제가 잘 되는지 확인하기")
        @Test
        void deleteOrder() {
            // when
            controller.getOrderNameList().add(0,"와퍼");
            controller.getOrderPriceList().add(0,6900);
            controller.getOrderNumList().add(0, 1);

            controller.getOrderNameList().add(1,"콜라");
            controller.getOrderPriceList().add(1,2000);
            controller.getOrderNumList().add(1, 4);

            // then
            assertEquals(List.of("와퍼","콜라"), controller.getOrderNameList());
            assertEquals(List.of(6900,2000),controller.getOrderPriceList());
            assertEquals(List.of(1,4),controller.getOrderNumList());

            // when
            controller.removeOrder(2);

            // then
            assertEquals(List.of("와퍼"), controller.getOrderNameList());
            assertEquals(List.of(6900),controller.getOrderPriceList());
            assertEquals(List.of(1),controller.getOrderNumList());
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



