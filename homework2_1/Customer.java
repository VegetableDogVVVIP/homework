package homework2_1;

import java.time.LocalDate;

public class Customer  {
    String customer_name;
    int rua;
    LocalDate time;

    public Customer(){
    }

    public Customer( String customer_name,int rua,LocalDate time){
        this.customer_name=customer_name;
        this.rua=rua;
        this.time=time;
    }
    public LocalDate getTime() {
        return this.time;
    }
    @Override
    public String toString(){
        return "customer_name:"+customer_name+"   rua:"+rua+"   time:"+time;
    }

}
