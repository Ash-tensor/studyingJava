package cafepackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryCafe extends Cafe implements IDeliveryServiceAvailable {
    String name;

    public DeliveryCafe(String name, String location, List<Drink> menu) {
        super(name, location, menu);
        this.name = name;
    }

    @Override
    public Drink makeDrink(Order order) {
        DeliveryApp.transaction.put(order, true);
        return super.makeDrink(order);
    }

    @Override
    public void makeDeliveryService(Order order) {
        // 주문이 완성되었으면
        if (DeliveryApp.transaction.get(order)) {
        System.out.println("주문하신 " + order.orderCode + "를 " +
                        order.customer.address + "로 배송 시작합니다");

//        order.customer.setHand();

        }
        else {
            System.out.println("아직 주문하신 음료가 완성되지 않았습니다.");
        }
    }
    @Override
    public Drink getDeliveryOrder(Order order) {
        Drink orderedDrink = super.getOrder(order);
        return orderedDrink;
    }
}
