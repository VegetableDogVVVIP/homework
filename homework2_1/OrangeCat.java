package homework2_1;

import homework2_1.Cat;

public class OrangeCat extends Cat {
    boolean isFat;
    public OrangeCat(){

    }

    public OrangeCat(String name, int age, String gender, double price,boolean isFat){
        super(name,age, gender,price);
        this.isFat=isFat;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public String  toString(){
        return "name:"+this.name+"  age:"+this.age+"  gender:"+this.gender+"  price:"+this.price+"  isFat："+isFat;
    }
}

