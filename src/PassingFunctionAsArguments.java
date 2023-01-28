import java.util.function.BiFunction;

public class PassingFunctionAsArguments {
    protected  static class MyMath {
        public static  Integer add(Integer a, Integer b) {
            return a + b;
        }

        public static  Integer sub(Integer a, Integer b) {
            return a - b;
        }

        /**returning result from combine BiFunction function as argument
         * and returning result using apply() function
         */
        public static Integer combineAddSub(BiFunction<Integer, Integer, Integer> combine) {
            return combine.apply(1,2);
        }
    }
    public static void main(String[] args) {
        System.out.println(MyMath.combineAddSub(MyMath::sub)); //passing sub function
        System.out.println(MyMath.combineAddSub(MyMath::add)); //passing add function
        System.out.println(MyMath.combineAddSub((a, b) -> 1 * a + 2 * b));
    }
}