import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Streams {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};

        /*
        * Streams in java are higher order function such as map(), filter(), reduce(), collect() that is used to handle List in java very easy
        * first, the list is converted to stream, and then we apply these functions to return data
        * */
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        Function<Integer,Integer> doubleNumber = (a) -> a * 2;

        //map()
        List<Integer> doubled = list
                .stream()
                .map(doubleNumber)
                .toList();

        System.out.println(doubled);

        //filter()
        List<Integer> evenNumber = list
                .stream()
                .filter((a) -> a % 2 == 0)
                .toList();

        System.out.println(evenNumber);

        //reduce()
        //reduce return 2 values accumulator & initial, so we use BinaryOperator<Integer>
        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer sum = acc + x;
            System.out.println(sum);
            return sum;
        };
        Integer result = list.stream().reduce(0,getSum);;

        //collect()
        //joining() more than 1 word together by a delimiter
        String[] ar = {"Hi","Admin"};
        List<String> words = new ArrayList<>(Arrays.asList(ar));

        String collectedString = words
                .stream()
                .filter((word) -> word.length()>1)
                .collect(Collectors.joining(","));

        //counting no of words using counting()
        Long len = words
                .stream()
                .filter((word) -> word.length()>1)
                .count();

        //group words using groupingBy()
        Map<Integer,List<String>> group = words
                .stream()
                .filter((word) -> word.length()>1)
                .collect(Collectors.groupingBy(
                        (word) -> word.length()
                ));

        //partition words using partitioningBy()
        Map<Boolean, List<String>> partition = words
                .stream()
                .collect(Collectors.partitioningBy(
                        (word) -> word.length()<5
                ));

        System.out.println(collectedString);
        System.out.println(len);
        System.out.println("Grouping according to length\n" + group);
        System.out.println("Partition words based on given condition\n" + partition);
    }
}
