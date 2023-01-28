import java.util.function.Function;


public class FunctionInterfaceDemo {

    /**
     * Function is an interface that accepts one argument and returns result
     * Function<Integer,Integer> represents following
     * 1st Integer: Type of input of function
     * 2nd Integer: Type of result returned by function
     * apply() is called to send the arg to function and call at the same time
     */

    protected static  class MyMath{
        public static Integer triple(Integer x){
            return x*3;
        }
    }

    public static void main(String[] args) {
        Function<Integer,Integer>calcTriple=MyMath::triple;
        Integer result=calcTriple.apply(5);
        System.out.println(result.intValue());
    }
}