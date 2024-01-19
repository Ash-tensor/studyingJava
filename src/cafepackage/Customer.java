package cafepackage;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Customer implements ISmartphone{
    List<Drink> hand = new ArrayList<>();
    public void setHand(Drink drink) {
        if (this.hand.size() < 2) {
            System.out.println(this.name + ":: " + drink.getName() + "을 받았다...");
        this.hand.add(drink);}
        else {
            System.out.println("손이 꽉 차있다...");
        }
    }

    public void visitCafe(Cafe cafe) {
        this.cafe = cafe;
        cafe.visited(this);
    }

    Cafe cafe;
    int dept = 0;
    int asset;
    App smartphone;
    String name;
    String address;
    CreditCard creditCard;

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void makeOrder(String menuName) {
        for (Drink drink : this.cafe.getMenu()) {
            if(drink.getName().equals(menuName)) {
                if (this.creditCard != null) {
                    System.out.println("신용카드로 결제합니다");
                    this.dept += drink.price;
                    Order order = new Order(this.cafe, this, this.cafe.getOrderNumber(), this.address,
                            drink);

                    //원래라면 CreditCard가 이 행동을 했겠지만 너무 프로젝트가 커지는것 같아서 그만둠
                    cafe.setSales(cafe.getSales() + drink.price);

                    Drink orderedDrink = this.cafe.getOrder(order);
                    this.setHand(orderedDrink);
                }
                else {
                    if(this.asset >= drink.price) {
                        this.asset -= drink.price;
                        System.out.println("현금으로 결제합니다.");
                        Order order = new Order(this.cafe, this, this.cafe.getOrderNumber(), this.address,
                                drink);

                        //원래라면 CreditCard가 이 행동을 했겠지만 너무 프로젝트가 커지는것 같아서 그만둠
                        cafe.setSales(cafe.getSales() + drink.price);

                        Drink orderedDrink = this.cafe.getOrder(order);
                        this.setHand(orderedDrink);

                    }
                    else {
                        System.out.println(this.name+ ":: 돈이 없다...");
                    }
                }
            }
        }
    }

    @Override
    public void installingApp(String name) {
        List<String> appNameList = new ArrayList<>();
        int appIndex;
        for (App app : App.getAppStore()){
            appNameList.add(app.toString());
        }
        for (String appName : appNameList) {
            if (appName.equals(name)) {
                appIndex = appNameList.indexOf(appName);
                this.appList.add(App.getAppStore().get(appIndex));
                System.out.println("App Instalization Complete");
            }
        }
    }
    @Override
    public void usingApp(App app) {
        if(this.appList.contains(app)) {
            System.out.println("환영합니다 :" + this.name + "님");
            this.smartphone = app;
            ((DeliveryApp)this.smartphone).setUser(this);
        }
    }
}
