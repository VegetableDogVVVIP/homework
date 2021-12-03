package homework2_1;

public abstract class Cat {

    String name;
    int age;
    String gender;
    double price;

    public Cat(){
    }

    public Cat(String name, int age, String gender, double price) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
    }
    public abstract double getPrice();
    public abstract void setPrice(double price);

    public abstract String toString();
}
