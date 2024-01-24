package cafepackage;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryApp extends App {
    static Map<Order, Boolean> transaction = new HashMap<>();
    String name;
    List<Cafe> registeredCafe = new ArrayList<>();
    Cafe cafe;
    Customer user;

    public DeliveryApp(String name) {
        super(name);
        this.name = name;
    }

    public void setUser(Customer user) {this.user = user;}
    public void register(Cafe cafe) {
        if (cafe.deliveryServiceAvailable) {
            registeredCafe.add(cafe);
        }
        else {
            System.out.println("해당 카페는 배달 가능한 업장이 아닙니다.");
        }
    }
    public void printRegisteredCafe() {
        System.out.println("현재 배달 가능한 카페 리스트:");
        for(Cafe cafe : registeredCafe) {
            Cafe tempCafe = (Cafe) cafe;
            System.out.println(tempCafe.getName());
            System.out.println(cafe);
        }
    }

    public void choseCafe(String targetName) {
        for (Cafe cafe : registeredCafe){
            if(targetName.equals(cafe.getName())) {
                this.cafe = cafe;
                System.out.println("선택하신 카페 페이지는" + cafe.getName() + "입니다.");
                System.out.println("메뉴" + this.cafe.toString());
            }
            else {
                System.out.println("선택하신 카페는 주문가능한 리스트에 없습니다.");
            }
        }
    }
    public void makeOrder(String menuName) {
        for (Drink drink : this.cafe.getMenu()){
            if(drink.getName().equals(menuName)) {

                System.out.println(this.name + "::" + "등록된 신용카드로 결제하겠습니다.");

                if(this.user.creditCard.onlineServiceAvailable) {
                    if(this.user.creditCard.payLater(drink.price)) {
                        System.out.println(this.name + "::" + "정상결제되었습니다.");
                        this.cafe.setSales(this.cafe.getSales() + drink.price);

                        Order tempOrder = new Order(this.cafe, this.user,
                                cafe.getOrderNumber(), this.user.address, drink);

                        System.out.println(this.name + "::"+ "카페" + this.cafe.getName()+ "에 주문을 넣었습니다.");
                        DeliveryApp.transaction.put(tempOrder, false);
                        System.out.println("배달 앱의 현재 배송상황");
                        System.out.println(DeliveryApp.transaction.toString());

                        Drink orderedDrink = this.cafe.getDeliveryOrder(tempOrder);

                        this.user.setHand(orderedDrink);

                        DeliveryApp.transaction.put(tempOrder, true);
                        System.out.println("배달앱의 현재 배송상황");
                        System.out.println(DeliveryApp.transaction.toString());
                        break;

                    }
                    else {
                        System.out.println("결제가 실패하였습니다.");
                    }
                }
                else {
                    System.out.println("이 신용카드는 온라인에서 사용할 수 없습니다.");

                }
            }
        }
    }
}
