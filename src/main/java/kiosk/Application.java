package kiosk;

public class Application {
    public static void main(String[] args) {
        program();
    }

    static void program() {
        kiosk.KioskMenu kioskInput = new KioskMenu();
        kioskInput.chooseKioskMenu();
    }
}