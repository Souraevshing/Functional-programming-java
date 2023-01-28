import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunction {

    public static void main(String[] args) {
        BiFunction<Float, Float, Float> divide = (a, b) -> a / b;

        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> checkDivide = (function) -> (x, y) -> {
            if (y == 0f) {
                System.out.println("Can't Divide by 0");
                return 0f;
            }
            return function.apply(x, y);
        };
        BiFunction<Float, Float, Float> divideSafely = checkDivide.apply(divide);
        System.out.println(divideSafely.apply(0f,0f));
    }

}
