package cafepackage;

public class CreditCard {
    Customer customer;
    boolean onlineServiceAvailable;
    public boolean payLater(int price) {
        customer.dept += price;
        return true;
    }
    public CreditCard(Customer human, boolean onlineServiceAvailable) {
        this.customer = human;
        this.onlineServiceAvailable = onlineServiceAvailable;
    }
}
