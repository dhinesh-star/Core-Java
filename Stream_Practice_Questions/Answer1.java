package Stream_Practice_Questions;

import java.util.*;
import java.util.stream.Collectors;

public class Answer1 {
    public static void main(String[] args) {
        /**
         1. **Find Even Numbers in a List**
         Given a list of integers, filter out even numbers using the Stream API.
         */
        List<Integer> integersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 5, 8, 7, 6, 4, 1, 8);
        List<Integer> evenIntegerList = integersList.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Question 1 O/P -> "+evenIntegerList);

        /**
         2. **Convert Strings to Uppercase**
         Convert all elements of a list to uppercase using the Stream API.
         */
        List<String> stringsList = Arrays.asList("abcd", "efgh", "ijkl", "mn", "pqrs", "tuv", "wxyz", "abcdef", "defg", "ijkl", "mn", "pqrs", "tuv", "wxyz");
        List<String> upperStringList = stringsList.stream().map(str-> str.toUpperCase()).collect(Collectors.toList());
        System.out.println("Question 2 O/P -> "+upperStringList);

        /**
         3. **Find the Maximum Number**
         Find the maximum number in a given list using the Stream API.
         */
        int optionalMax = integersList.stream()
                .max((n1, n2) -> n1 > n2?1:-1)
                .orElse(Integer.MIN_VALUE);
        System.out.println("Question 3 O/P -> "+optionalMax);

        /**
         4. **Count Strings with Length > 3**
         Given a list of strings, count how many have a length greater than 3.
         */
        long countOfStringWithLengthGreaterThan3 = stringsList.stream().filter(str -> str.length() > 3).collect(Collectors.counting());
        System.out.println("Question 4 O/P -> "+countOfStringWithLengthGreaterThan3);

        /**
         5. **Sort a List of Integers**
         Sort a list of integers in ascending order using the Stream API.
         */
        List<Integer> sortedList = integersList.stream().sorted().collect(Collectors.toList());
        System.out.println("Question 5 O/P -> "+sortedList);

        /**
         6. **Find Duplicate Elements**
         Given a list of integers, find and return a list of duplicate elements.
         */
        List<Integer> duplicateValueList = integersList.stream()
                .collect(Collectors.groupingBy(num -> num,
                        Collectors.counting()))
                .entrySet().stream()
                .filter(value -> value.getValue() > 1)
                .map(value -> value.getKey())
                .collect(Collectors.toList());
        System.out.println("Question 6 O/P -> "+duplicateValueList);

        /**
         7. **Group Words by Their First Letter**
         Given a list of words, group them by their first letter using the Stream API.
         */
        Map<Character, List<String>> firstLetterMap = stringsList.stream()
                .collect(Collectors.groupingBy(str -> str.charAt(0),
                        HashMap::new, Collectors.toList()));
        System.out.println("Question 7 O/P -> "+firstLetterMap);

        /**
         8. **Find Second Highest Number**
         Find the second highest number from a list of integers using Streams.
         */
        int secondLargestNumber = integersList.stream()
                .sorted((n1, n2) -> n1 < n2?1:-1)
                .skip(1)
                .findFirst()
                .orElseThrow(RuntimeException::new);
        System.out.println("Question 8 O/P -> "+secondLargestNumber);

        /**
         9. **Concatenate Strings with a Delimiter**
         Given a list of strings, join them into a single string separated by commas.
         */
        String concatenatedString = stringsList.stream().collect(Collectors.joining(", "));
        System.out.println("Question 9 O/P -> "+concatenatedString);

        /**
         10. **Find the First Non-Repeating Character in a String**
         Given a string, find the first non-repeating character using the Stream API.
         */
        String requiredString = "abcdbace";
        List<Character> characterList = new LinkedList<>();
        for(char c : requiredString.toCharArray()) {
            characterList.add(c);
        }
        Character firstNonRepeatingChar = characterList.stream().collect(
                Collectors.groupingBy(character -> character,
                        Collectors.counting()))
                .entrySet().stream()
                .filter(value -> value.getValue() == 1)
                .map(key -> key.getKey())
                .findFirst()
                .orElse(null);
        System.out.println("Question 10 O/P -> "+firstNonRepeatingChar);
    }
}
