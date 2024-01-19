package cafepackage;

public class Coffee extends Drink implements ISyrupAdd{
    int addedSyrup;
    @Override
    public void addSyrup(int number) {
        this.addedSyrup = number;
    }
    public Coffee(String name, Size size, int price) {
        super(name, size, price);
    }
    @Override
    public Size getSize() {
        return super.getSize();
    }
    @Override
    public String getName() {
        return super.getName();
    }
}

