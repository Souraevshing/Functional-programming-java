import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream {
    public static void main(String[] args) {
        String[] arr = {"hello", "functional", "programming"};
        List<String> wordsArr = new ArrayList<>(Arrays.asList(arr));

        List<String> newWords = wordsArr
                .parallelStream()
                .map((word) -> {
                    System.out.println("New Words" + word);
                    return word.toUpperCase();
                })
                .map((word) -> {
                    System.out.println("Add colon to " + word);
                    return word + ":";
                })
                .collect(Collectors.toList());

        System.out.println(newWords);
    }
}
