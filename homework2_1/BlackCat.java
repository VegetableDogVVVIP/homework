package homework2_1;

public class BlackCat extends Cat{

    public BlackCat(){

    }

    public BlackCat(String name, int age, String gender, double price){
        super(name,age, gender,price);
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public String  toString(){
        return "name:"+this.name+"  age:"+this.age+"  gender:"+this.gender+"  price:"+this.price;
    }
}
