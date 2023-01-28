import java.util.function.BiFunction;
public class BiFunctionDemo {
    /**
     * BiFunction takes 2 arg and returns result
     * BiFunction<Integer,Integer,Integer> represents following
     * 1st Integer: Type of first arg of function
     * 2nd Integer: Type of second arg of function
     * 3rd Integer: Type of result returned by function
     * apply() is called to send the arg to function and call at the same time
     */
    public static void main(String[] args) {
        //accept 2 arg
        BiFunction<Integer,Integer,Integer>multiply=(a,b)->{
            return a*b;
        };

        System.out.println(multiply.apply(5,2));

        //accept 3 arg
        TriFunction<Integer,Integer,Integer,Integer> addThreeNum = (a, b, c) -> a + b + c;
        System.out.println(addThreeNum.apply(1,2,3));

        //accept no arg
        NoArgFunction<String> displayName = () -> "Hi,";
        System.out.println(displayName.apply());
    }
}
