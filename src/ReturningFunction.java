import java.util.function.Function;

public class ReturningFunction {

    protected static class MyMath {

        //returning result as function from multiply() of type Integer globally
        public static Function<Integer, Integer> multiply(Integer a) {
            return (Integer b) -> a * b;
        }
    }

    /**
     * create() is returning function, ultimately a string is returned
     * */
    public static void main(String[] args) {
        //type of create function is of NoArgFunction interface
        NoArgFunction<NoArgFunction<String>> create = () -> () -> "Returned Value";

        //assigning returned value of create() to displayName of type NoArgFunction<String>
        NoArgFunction<String> displayName = create.apply();
        System.out.println(displayName.apply());

        Function<Integer,Integer> multiplyByTwo = MyMath.multiply(5);
        Function<Integer,Integer> multiplyByThree = MyMath.multiply(5);
        Function<Integer,Integer> multiplyByFour = MyMath.multiply(5);

        System.out.println(multiplyByTwo.apply(2));
        System.out.println(multiplyByThree.apply(3));
        System.out.println(multiplyByFour.apply(4));
    }
}
