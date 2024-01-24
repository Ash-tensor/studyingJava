package cafepackage;

import java.util.*;

public class Cafe {
    Customer customer;
    public boolean deliveryServiceAvailable = false;
    private int sales = 0;
    private int orderNumber;
    private String name;
    private String location;
    private List<Drink> menu = new LinkedList<>();
    Map<Order, Boolean> cafeTransaction = new HashMap<>();

    public void visited(Customer customer) {
        this.customer = customer;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
    public int getSales() {
        return sales;
    }
    public Cafe(String name, String location, List<Drink> menu) {
        this.name = name;
        this.location = location;
        this.menu = menu;
    }
    @Override
    public String toString(){
        System.out.println(this.name + " menu");
        StringBuilder menuList = new StringBuilder();
        for(Drink drink : this.menu) {
            menuList.append("::");
            menuList.append(drink.getName());
            menuList.append("\n");
        }
        String answer = menuList.toString();
        return answer;
    }

    public List<Drink> getMenu() {
        return menu;
    }

    protected Drink makeDrink(Order order) {
        System.out.println(this.name + "::" + "주문받은 " + order.orderCode + " 완성했습니다.");
        Drink orderedDrink = new Drink(order.orderCode,
                order.menu.getSize(), order.menu.price);
        this.cafeTransaction.put(order, true);
        System.out.println("카페의 현재 주문상황");
        System.out.println(this.cafeTransaction.toString());

//        DeliveryApp.transaction.put(order, true);

        return orderedDrink;
    }

    public int getOrderNumber() {return orderNumber;}
    public String getName() {
        return name;
    }
    protected String getLocation() {
        return location;
    }

    protected Drink getOrder(Order order) {
        System.out.println("카페" + this.getName() + "::" + order.orderCode + "주문받았습니다.");
        this.cafeTransaction.put(order, false);

        System.out.println("카페의 현재 주문상황");
        System.out.println(this.cafeTransaction.toString());

        Drink orderedDrink = this.makeDrink(order);

        return orderedDrink;
    }

    public Drink getDeliveryOrder(Order order) {
        if (this.deliveryServiceAvailable) {
            Drink orderedDrink = this.getOrder(order);
            return orderedDrink;
        }
        else {
            System.out.println("이 가게는 배달을 하지 않습니다.");
            return null;
        }
    }
}
