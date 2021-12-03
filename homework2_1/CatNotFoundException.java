package homework2_1;

public class CatNotFoundException extends RuntimeException{
    public static final long serialVersionUID=1L;
    public CatNotFoundException(String message){
        super(message);
    }
}
