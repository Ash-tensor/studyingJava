package cafepackage;

public class Drink {
    String name;
    Size size;
    int price;
    public Drink(String name, Size size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public Size getSize() {
        return size;
    }
}
