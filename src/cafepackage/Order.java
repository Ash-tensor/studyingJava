package cafepackage;

public class Order {
    public static int number = 0;
    public String orderCode;
    public String destination;
    String SellerName;
    String StartingPoint;
    Drink menu;
    Customer customer;
    public Order(Cafe cafe, Customer customer, int orderCode, String destination, Drink drink) {
        this.destination = destination;
//        Cafe tempCafe = (Cafe)cafe;
        this.customer = customer;
        this.menu = drink;
        this.SellerName = cafe.getName();
        String location = cafe.getLocation();
        this.StartingPoint = cafe.getLocation();
        this.orderCode = SellerName + location + menu + orderCode;
    }

    public Order(Cafe cafe, int orderCode, String destination) {}
    @Override
    public String toString() {
        return "Order{" +
                "orderCode='" + orderCode + '\'' +
                ", destination='" + destination + '\'' +
                ", SellerName='" + SellerName + '\'' +
                ", StartingPoint='" + StartingPoint + '\'' +
                '}';
    }
}
