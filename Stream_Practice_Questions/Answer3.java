package Stream_Practice_Questions;

import java.util.Map;
import java.util.stream.Collectors;

public class Answer3 {
    public static void main(String[] args) {
        /*
            1. Write a stream code to find the number of character count in the string given.
         */
        String str = "alphabets";
        Map<Integer, Long> freqMap = str.chars()
                .boxed()
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));
    }
}
