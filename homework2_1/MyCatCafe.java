package homework2_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

interface CatCafe{
    public void  buyCat(Cat cat,ArrayList<Cat> cats);
    public void show(Customer customer,ArrayList<Customer> customers,ArrayList<Cat> cats);
    public void rest(LocalDate date);
}
public class MyCatCafe implements CatCafe {
    double balance;
    ArrayList<Cat> cats=new ArrayList<>();
    ArrayList<Customer> customers=new ArrayList<>();

    public MyCatCafe(){
    }

    public MyCatCafe(double balance,ArrayList<Cat> cats,ArrayList<Customer> customers){
        this.cats=cats;
        this.balance=balance;
        this.customers=customers;
    }

    public void buyCat(Cat cat,ArrayList<Cat> cats) throws InsufficientBalanceException{
        if(balance<cat.getPrice()){
            throw new InsufficientBalanceException("店内余额不足！\n");
        }
        else{
            cats.add(cat);
            System.out.printf(cats.get(cats.size()-1).toString()+"\n");
            balance-=cat.getPrice();
        }
    }
    //一个顾客rua3次
    public void show(Customer customer,ArrayList<Customer> customers,ArrayList<Cat> cats) throws CatNotFoundException{

        if(cats.size()>0){
            balance+=15.0*3;
            customers.add(customer);
            Random rand=new Random();
            int k=rand.nextInt(cats.size());
            System.out.printf(cats.get(k).toString()+"\n");
        }
        if(cats.size()<0){
            throw new CatNotFoundException("无猫可rua!\n");
        }
    }
    public void rest(LocalDate date){
        int sum=0;
        for(int i=1;i<customers.size();i++){
            if(customers.get(i).getTime().equals(date)){
                System.out.printf(customers.get(i).toString()+"\n");
                sum+=45;
            }
        }
        System.out.println(sum);

    }
}
