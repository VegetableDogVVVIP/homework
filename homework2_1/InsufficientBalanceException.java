package homework2_1;
public class InsufficientBalanceException  extends RuntimeException{
    public static final long serialVersionUID=1L;
    public InsufficientBalanceException(String message){
        super(message);
    }

}
