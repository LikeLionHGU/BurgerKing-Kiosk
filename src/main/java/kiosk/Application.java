package kiosk;
//프로그램을 시작함
//처음 키오스크에서 입력받은 것 토대로 if 믄으로 할당 (나중에 키오스크 클래스로 옮겨도 무방할듯)
public class Application {
    public static void main(String[] args) {

    program();

    }

    static void program(){
        kiosk.KioskMenu kioskInput = new KioskMenu();
        kioskInput.chooseKioskMenu();
    }




}