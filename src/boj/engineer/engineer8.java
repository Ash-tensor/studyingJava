package boj.engineer;

public class engineer8 {
    public static void main(String[] args) {
        vehicle obj = new Car("Spark");
        System.out.println(obj.getName());
        System.out.println(obj.getName("temp"));

    }
}

abstract class vehicle {
    private String name;
    abstract public String getName(String val);
    public String getName() {
        return "Vehicle name :" + name;
    }
    public void setName(String val) {
        name = val;
    }
}
class Car extends vehicle {
    public Car(String val) {
        setName(val);
    }
    @Override
    public String getName(String val) {
        return "Car name :" + val;
    }
}

