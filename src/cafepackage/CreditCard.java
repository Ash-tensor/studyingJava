package cafepackage;

public class CreditCard implements IOnlinePurchaseable{
    Customer Human;
    public boolean payLater(int price) {
        Human.dept += price;
        return true;
    }
    public CreditCard(Customer human) {
        Human = human;
    }
}
