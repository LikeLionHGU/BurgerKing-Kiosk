package kiosk;


public class Product {
    String name ;
    int quantities = 0;
    int price ;

    Product(String s, int n){
        ++quantities;
        this.name = s ;
        this.price = n ;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getTotalPrice() {return  price * quantities;}
    public int getQuantities() {return quantities;}
    public void increaseQuantities() {++quantities; return;}
    public void adjustQuantities(int n) {
        if(n < 1 || n > 50){
            throw new IllegalArgumentException("오류 : 잘못된 개수 입력");
        }
        quantities = n;
    }
    @Override
    public String toString() {
        return "Product Name: " + name;
    }

}

class Buger extends Product {
    Buger(String s, int n){
        super(s,n);
    }
    @Override
    public String toString() {
        return getName();
    }
}

class Side extends Product {
    Side(String s, int n){
        super(s,n);
    }
    @Override
    public String toString() {
        return getName();
    }
}

class Drink extends Product {
    Drink(String s, int n){
        super(s,n);
    }
    @Override
    public String toString() {
        return getName();
    }
}