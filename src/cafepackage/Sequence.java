package cafepackage;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
    public static void main(String[] args) {
        DeliveryApp yogiyo = new DeliveryApp("yogiyo");

        Customer who = new Customer("who", "outside");
        Customer me = new Customer("me", "home");

        CreditCard myCreditCard = new CreditCard(me, true);
        me.setCreditCard(myCreditCard);

        yogiyo.registerAppstore();

        List<Drink> haioMenu = new ArrayList<>();

        Coffee TIcedAmericano = new Coffee("Tall IcedAmericano", Size.TALL, 2500);
        Coffee MIcedAmericano = new Coffee("Mideum IcedAmericano", Size.MEDIUM, 2000);
        Coffee SIcedAmericano = new Coffee("Small IcedAmericano", Size.SMALL, 1500);

        haioMenu.add(TIcedAmericano);
        haioMenu.add(MIcedAmericano);
        haioMenu.add(SIcedAmericano);

        DeliveryCafe haioCafe = new DeliveryCafe("HAIO", "Seoul", haioMenu);

        yogiyo.register(haioCafe);

        List<Drink> mammothMenu = new ArrayList<>();

        Drink TGrapeAde = new Drink("Tall GrapeAde", Size.TALL, 3000);
        Drink MGrapeAde = new Drink("Medium GrapeAde", Size.MEDIUM, 2500);
        Drink SGrapeAde = new Drink("Small GrapeAde", Size.SMALL, 2000);
        mammothMenu.add(TGrapeAde);
        mammothMenu.add(MGrapeAde);
        mammothMenu.add(SGrapeAde);

        Cafe mammothCafe = new Cafe("MAMMOTH", "Seoul", mammothMenu);


        System.out.println(App.getAppStore());


        me.installingApp("yogiyo");
        me.usingApp(me.appList.get(0));

        ((DeliveryApp) me.smartphone).printRegisteredCafe();
        ((DeliveryApp) me.smartphone).choseCafe("HAIO");
        ((DeliveryApp) me.smartphone).makeOrder("Tall IcedAmericano");

        me.visitCafe(mammothCafe);
        me.makeOrder("Tall GrapeAde");

        who.visitCafe(mammothCafe);
        who.makeOrder("Tall GrapeAde");
    }
}
