package jan22nd;

public class InstanceOfSample {

    public static void main(String[] args) {
        Shape myShape1 = new Shape();
        Shape myShape2= new Circle();
        Shape myShape3 = new Square();


        if (myShape1 instanceof Shape) {
            System.out.println("Shape 입니다.");
        }

        if (myShape2 instanceof Circle) {
            System.out.println("Shape 입니다.");
        } else if (myShape2 instanceof Shape) {
            System.out.println("Shape 입니다2.");
        }






    }
}
