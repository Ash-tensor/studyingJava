package nestedclasssample;

public abstract class Human {
    String name;
    String sex;
    String region;
    public Human(String name, String sex, String region){
        this.name = name;
        this.sex = sex;
        this.region = region;
    }
    void death() {
    };

    void eat() {};
}
