import java.util.function.Function;

public class LambdaExp {
    public static void main(String[] args) {
        Function<Integer,Integer>absoluteValue=(num)->{
            if(num<0){
                return -num;
            }
            else{
                return num;
            }
        };
        System.out.println(absoluteValue.apply(1));
    }
}
