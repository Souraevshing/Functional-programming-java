import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialApplication {
/**
 * partial are way of writing any function in which we can pass anyone argument at compile time
 * and all other arguments as we need
 *
 * */
    public static void main(String[] args) {
        TriFunction<Integer,Integer,Integer,Integer> add = (a, b, c) -> a + b + c;

        //here we are adding partial by passing 1 argument x and as a returned value it returns function having 2 arguments y,z and apply all 3 arguments to add()
        Function<Integer, BiFunction<Integer,Integer,Integer>> addPartial =
                (x) -> (y, z) -> add.apply(x, y, z);

        //here we are adding partial having 1 argument
        BiFunction<Integer,Integer,Integer> addAnotherNumber = addPartial.apply(10);
        //here we are adding another 2 arguments
        System.out.println(addAnotherNumber.apply(20, 30));
    }

}
