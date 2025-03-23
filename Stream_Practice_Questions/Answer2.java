package Stream_Practice_Questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer2 {
    public static void main(String[] args) {
        /**
         1. **Find Odd Numbers in a List**
         Given a list of integers, filter out **odd numbers** using the Stream API.
         */
        List<Integer> integersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 5, 8, 7, 6, 4, 1, 8);
        List<Integer> oldIntegerList = integersList.stream()
                .filter(n -> n % 2 == 1)
                .collect(Collectors.toList());
        System.out.println("Question 1 O/P -> "+oldIntegerList);

        /**
         2. **Find the Total Length of All Strings**
         Given a list of strings, find the **sum of the lengths** of all strings.
         */
        List<String> stringsList = Arrays.asList("abcd", "efgh", "ijkl", "mn", "pqrs", "tuv", "wxyz", "abcdef", "defg", "ijkl", "mn", "pqrs", "tuv", "wxyz");
        int totalCharactersLength = stringsList.stream()
                .map(str -> str.length())
                .reduce(0, (n1, n2 )-> n1 + n2);
        System.out.println("Question 2 O/P -> "+totalCharactersLength);

        /**
         3. **Find the Most Frequent Element in a List**
         Given a list of integers, find the number that appears **most frequently** using the Stream API.
         */
        Integer mostFrequentNumber = integersList.stream().collect(Collectors.groupingBy(
                num -> num, Collectors.counting()))
                .entrySet().stream()
                .max((set1, set2) -> set1.getValue() > set2.getValue()?1:-1)
                .map(key -> key.getKey())
                .orElse(null);
        System.out.println("Question 3 O/P -> "+mostFrequentNumber);

        /**
         4. **Find the Longest String in a List**
         Given a list of strings, find the **longest string** using Streams.
         */
        String longestString = stringsList.stream()
                .max((str1, str2) -> str1.length() > str2.length()?1:-1)
                .orElse(null);
        System.out.println("Question 4 O/P -> "+longestString);

        /**
         5. **Sort a List of Employees by Salary (Descending) and Then by Name (Ascending)**
         Given a list of `Employee` objects (`name, salary`), **sort them first by salary (highest first), then by name (A-Z)**.
         */
        List<Employee> employeeList = Arrays.asList(
                new Employee("firstEmployee", 23, 50000),
                new Employee("secondEmployee", 24, 40000),
                new Employee("thirdEmployee", 25, 80000),
                new Employee("fourthEmployee", 26, 80000),
                new Employee("fifthEmployee", 27, 40000)
        );
        System.out.println("Question 5 O/P -> ");
        System.out.println("------------------");
        employeeList.stream().sorted(
                (emp1, emp2) -> {
                    if(emp1.getSalary() == emp2.getSalary()){
                        return emp1.getName().compareTo(emp2.getName());
                    }
                    return emp1.getSalary() < emp2.getSalary()?1:-1;
                }
        ).forEach(employee -> System.out.println(employee));
        System.out.println("------------------");
        /**
         6. **Find the Second Non-Repeating Character in a String**
         Given a string, find the **second non-repeating** character using the Stream API.
         */
        String reqStr = "abcdefabcf";
        Character secondNonRepeatingCharacter = reqStr.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(key -> key.getKey())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Question 6 O/P -> "+secondNonRepeatingCharacter);
    }
}
