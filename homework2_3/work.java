package homework2_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class work {
    static volatile boolean flag;
    static volatile boolean sw = true;
    //判断是否有数组已输出完
    static volatile boolean over = false;

    public static void main(String[] args) {
        int[] arr1 = {1,3,4,5,6,7,8,9,10};
        int[] arr2 = {10,20,30,40,50,60,70,80,90,100,110,111,23};
        outNumber(arr1,arr2);

        String email1="31980322@qq.com";
        String email2="edrftg@163.com";
        String email3="df.dfg.com";
        System.out.print(isEmail(email1)+"\n");
        System.out.print(isEmail(email2)+"\n");
        System.out.print(isEmail(email3)+"\n");
    }

    public static void outNumber(int[] arr1,int[] arr2){

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                while (sw != true && over == false) {
                    //自旋；可以加睡眠时间
                }
                if (sw == true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1："+arr1[i]);
                    sw = false;
                }
            }
            over = true;
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                while (sw != false && over == false) {
                    //自旋
                }
                if (sw == false || over == true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2: "+arr2[i]);
                    sw = true;
                }
            }
            over = true;
        });
        t1.start();
        t2.start();
    }

    public static boolean isEmail(String email){
        boolean f=false;

        String regEx1="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p =Pattern.compile(regEx1);
        m=p.matcher(email);
        if(m.matches()){
            f=true;
        }

        else
            System.out.println("邮箱格式错误");
        return f;

    }

}

