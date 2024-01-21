package kiosk;

import java.util.Scanner;

public class Basket {
    Scanner sc = new Scanner(System.in);
    static int price = 0;
    static int[] burger = new int[]{0, 0, 0, 0, 0, 0};
    static int[] side = new int[]{0, 0, 0, 0, 0, 0};
    static int[] drink = new int[]{0, 0, 0, 0, 0, 0};

    public void printBasketMenu() {
        System.out.println("===== 장바구니 =====\n");
        printBurgerMenu();
        printSideMenu();
        printDrinkMenu();

        System.out.print("\n====================\n" + "1. 주문하기 \n" + "2. 수량 조절하기\n" + "3. 삭제하기 \n" + "\n" +
                "총 가격: " + price + "원" + "\n\n" + "메뉴선택 (0을 선택 시 홈으로): ");

        int option = sc.nextInt();
        basketOption(option);
    }

    public void basketOption(int n) {
        kiosk.KioskMenu kiosk = new KioskMenu();
        if (n >= 1 && n <= 3) {
            choosingBasketOption(n);
            kiosk.chooseKioskMenu();
        } else if (n == 0) {
            kiosk.chooseKioskMenu();
        } else {
            throw new IllegalArgumentException("장바구니 메뉴 중 하나를 골라야 합니다.");
        }
    }

    public void choosingBasketOption(int n) {
        if (n == 1) {
            order();
        } else if (n == 2) {
            changeOrder();
            printBasketMenu();
        } else if (n == 3) {
            deleteOrder();
            printBasketMenu();
        }
    }


    public void order() {
        System.out.println("주문해 주셔서 감사합니다. 총 " + price + "원 입니다.");
        System.exit(0);
    }

    public void changeOrder() {
        kiosk.HamburgerMenu burgerP = new HamburgerMenu();
        kiosk.SideMenu sideP = new SideMenu();
        kiosk.DrinkMenu drinkP = new DrinkMenu();

        System.out.println("수정할 메뉴를 선택해 주세요: ");
        int count;
        count = printChoices();
        System.out.print("바꿀 메뉴는?: ");
        int option = sc.nextInt();

        if (count <= option) {
            throw new IllegalArgumentException("담은 메뉴 중 하나를 골라야 합니다.");
        }

        System.out.print("바꿀 수량을 입력하시오 (1개 이상 50개 이하): ");
        int quantity = sc.nextInt();

        if (quantity > 50 || quantity < 1) {
            throw new IllegalArgumentException("메뉴는 1개에서 50개까지 선택할 수 있습니다.");
        }
        int count2 = 1;
        int difference = 0;

        for (int i = 0; i < 6; i++) {
            if (burger[i] != 0) {
                if (count2 == option) {
                    if (burger[i] < quantity) {
                        difference = quantity - burger[i];
                        price += burgerP.calculateBurgerPrice(i + 1) * difference;
                    } else if (burger[i] > quantity) {
                        difference = burger[i] - quantity;
                        price -= burgerP.calculateBurgerPrice(i + 1) * difference;
                    }
                    burger[i] = quantity;
                    count2++;
                } else if (count2 < option) {
                    count2++;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            if (side[i] != 0) {
                if (count2 == option) {
                    if (side[i] < quantity) {
                        difference = quantity - side[i];
                        price += sideP.calculateSidePrice(i + 1) * difference;
                    } else if (side[i] > quantity) {
                        difference = side[i] - quantity;
                        price -= sideP.calculateSidePrice(i + 1) * difference;
                    }
                    side[i] = quantity;
                    count2++;
                } else if (count2 < option) {
                    count2++;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            if (drink[i] != 0) {
                if (count2 == option) {
                    if (drink[i] < quantity) {
                        difference = quantity - drink[i];
                        price += drinkP.calculateDrinkPrice(i + 1) * difference;
                    } else if (drink[i] > quantity) {
                        difference = drink[i] - quantity;
                        price -= drinkP.calculateDrinkPrice(i + 1) * difference;
                    }
                    drink[i] = quantity;
                    count2++;
                } else if (count2 < option) {
                    count2++;
                }
            }
        }

    }

    public void deleteOrder() {
        kiosk.HamburgerMenu burgerP = new HamburgerMenu();
        kiosk.SideMenu sideP = new SideMenu();
        kiosk.DrinkMenu drinkP = new DrinkMenu();
        int count;
        count = printChoices();
        System.out.print("삭제할 항목을 선택하시오: ");
        int option = sc.nextInt();

        if (count <= option) {
            throw new IllegalArgumentException("담은 메뉴 중 하나를 골라야 합니다.");
        }

        int count2 = 1;
        for (int i = 0; i < 6; i++) {
            if (burger[i] != 0) {
                if (count2 == option) {
                    System.out.print("정말 삭제하시겠습니까? (1:예, 2:아니오): ");
                    int option2 = sc.nextInt();
                    if (option2 == 1) {
                        price -= burgerP.calculateBurgerPrice(i + 1) * burger[i];
                        burger[i] = 0;
                        printBasketMenu();
                    } else if (option2 == 2) {
                        printBasketMenu();
                    } else {
                        throw new IllegalArgumentException("잘못된입력입니다.");
                    }
                    count2++;
                } else if (count2 < option) {
                    count2++;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            if (side[i] != 0) {
                if (count2 == option) {
                    System.out.print("정말 삭제하시겠습니까? (1:예, 2:아니오): ");
                    int option2 = sc.nextInt();
                    if (option2 == 1) {
                        price -= sideP.calculateSidePrice(i + 1) * side[i];
                        burger[i] = 0;
                        printBasketMenu();
                    } else if (option2 == 2) {
                        printBasketMenu();
                    } else {
                        throw new IllegalArgumentException("잘못된입력입니다.");
                    }
                    count2++;
                } else if (count2 < option) {
                    count2++;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            if (drink[i] != 0) {
                if (count2 == option) {
                    System.out.print("정말 삭제하시겠습니까? (1:예, 2:아니오): ");
                    int option2 = sc.nextInt();
                    if (option2 == 1) {
                        price -= drinkP.calculateDrinkPrice(i + 1) * drink[i];
                        burger[i] = 0;
                        printBasketMenu();
                    } else if (option2 == 2) {
                        printBasketMenu();
                    } else {
                        throw new IllegalArgumentException("잘못된 입력입니다.");
                    }
                    count2++;
                } else if (count2 < option) {
                    count2++;
                }
            }
        }

    }

    public int printChoices() {
        int count = 1;
        kiosk.HamburgerMenu burgerP = new HamburgerMenu();
        for (int i = 0; i < 6; i++) {
            if (burger[i] != 0) {
                System.out.println(count + "." + burgerP.returnBurgerName(i) + " " + burger[i] + "개\n");
                count++;

            }
        }

        kiosk.SideMenu sideP = new SideMenu();
        for (int i = 0; i < 6; i++) {
            if (side[i] != 0) {
                System.out.println(count + "." + sideP.returnSideName(i) + " " + side[i] + "개\n");
                count++;

            }
        }

        kiosk.DrinkMenu drinkP = new DrinkMenu();
        for (int i = 0; i < 6; i++) {
            if (drink[i] != 0) {
                System.out.println(count + "." + drinkP.returnDrinkName(i) + " " + drink[i] + "개\n");
                count++;

            }
        }
        return count;
    }

    public void printBurgerMenu() {
        kiosk.HamburgerMenu burgerP = new HamburgerMenu();
        for (int i = 0; i < 6; i++) {
            if (burger[i] != 0) {
                System.out.println(burgerP.returnBurgerName(i) + " " + burger[i] + "개\n");
            }
        }
    }

    public void printSideMenu() {
        kiosk.SideMenu sideP = new SideMenu();
        for (int i = 0; i < 6; i++) {
            if (side[i] != 0) {
                System.out.println(sideP.returnSideName(i) + " " + side[i] + "개\n");
            }
        }
    }

    public void printDrinkMenu() {
        kiosk.DrinkMenu drinkP = new DrinkMenu();
        for (int i = 0; i < 6; i++) {
            if (drink[i] != 0) {
                System.out.println(drinkP.returnDrinkName(i) + " " + drink[i] + "개\n");
            }
        }
    }

    public void hambergerAdd(int num) {
        burger[num - 1]++;
        kiosk.HamburgerMenu burgerP = new HamburgerMenu();
        int p = burgerP.calculateBurgerPrice(num);
        price += p;
    }

    public void sideAdd(int num) {
        side[num - 1]++;
        kiosk.SideMenu sideP = new SideMenu();
        int p = sideP.calculateSidePrice(num);
        price += p;
    }

    public void drinkAdd(int num) {
        drink[num - 1]++;
        kiosk.DrinkMenu drinkP = new DrinkMenu();
        int p = drinkP.calculateDrinkPrice(num);
        price += p;
    }
}
