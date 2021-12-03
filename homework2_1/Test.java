package homework2_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main (String [] args){
        ArrayList<Cat> cats=new ArrayList<>();//空猫咪列表
        ArrayList<Customer> customers=new ArrayList<>();//空顾客列表
        Random ran=new Random();
        for(int i=0;i<8;i++){
            String name1=String.valueOf(ran.nextInt(100));
            int age1= ran.nextInt(12);
            String gender1;
            if(ran.nextInt(20)%2==0)   gender1="boy";
            else gender1="girl";
            double price1=200.0;
            boolean fat;
            if(i%2==0) fat=true;
            else fat=false;
            OrangeCat orangecat=new OrangeCat(name1,age1,gender1,price1,fat);
            cats.add(orangecat);
        }//添加橘猫

        for(int i=1;i<9;i++){
            String name2=String.valueOf(ran.nextInt(100));
            int age2= ran.nextInt(10);
            String gender2;
            if(ran.nextInt(20)%2==0)   gender2="boy";
            else gender2="girl";
            double price2=350.0;
            BlackCat blackcat=new BlackCat(name2,age2,gender2,price2);
            cats.add(blackcat);
        }//添加黑猫

        //猫咖实例
        double  money=1;
        MyCatCafe cafe=new MyCatCafe(money,cats,customers);

        //招待顾客
        System.out.printf("招待顾客的信息\n");
        for(int i=1;i<=30;i++){
            String cus_name=String.valueOf(111+ran.nextInt(100));
            int rua= ran.nextInt(10)+3;
            LocalDate date=LocalDate.of(2021,11,ran.nextInt(10)+1);
            Customer cus1=new Customer(cus_name,rua,date);
            try{
                cafe.show(cus1,customers,cats);
            }catch (CatNotFoundException e){
                System.out.println("Exception:"+e);
            }

        }
        //买入猫猫
        System.out.printf("买入的猫猫信息\n");
        ArrayList<Cat> cs=new ArrayList<>();//买入猫猫实例
        cs.add(new BlackCat("袁花花",2,"女",350.0));
        cs.add(new BlackCat("郭富贵",1,"男",350.0));
        cs.add(new BlackCat("奶油",3,"男",350.0));
        cs.add(new BlackCat("泡芙",5,"女",350.0));
        cs.add(new OrangeCat("元宝",1,"女",200.0,true));
        cs.add(new OrangeCat("可乐",4,"男",200.0,false));
        cs.add(new OrangeCat("大白酱",6,"男",200.0,true));
        cs.add(new OrangeCat("鲁大头",5,"女",200.0,true));
        for(int i=0;i<cs.size();i++){
            try{
                cafe.buyCat(cs.get(i),cats);
            }catch (InsufficientBalanceException e){
                System.out.println("Exception thrown:"+e);
            }

        }
        //歇息
        System.out.printf("歇息信息\n");
        for(int i=0;i<10;i++){
            cafe.rest(LocalDate.of(2021,11,ran.nextInt(5)+2));
        }
    }
}
