import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 7, 3, 2, 6);

        /*
        * Using Streams -> to implement doubling every even number value and display the sum
        * (i) Using Functional interface concept
        * (ii) Using Lambda expression
        * */

        // (i) Using Functional interface concept
        Stream<Integer> s1 = nums.stream();

        // Creating Predicate reference object to filter all and get all even numbers from the nums List
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                if(num % 2 == 0) return true;
                return false;
            }
        };
        Stream<Integer> s2 = s1.filter(p);

        // Creating Function reference object to double the filtered values from s2 stream
        Function<Integer, Integer> fun = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer num) {
                return num*2;
            }
        };
        Stream<Integer> s3 = s2.map(fun);

        // Creating BinaryOperation reference to sum all the value double
        BinaryOperator<Integer> bi = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer num1, Integer num2) {
                return num1 + num2;
            }
        };
        int result1 = s3.reduce(0, bi);
        System.out.println("result1 >> "+result1);

        // (ii) Using Lambda expression
        int result2 =  nums.stream()
                .filter(num -> num%2==0)
                .map(num -> num*2)
                .reduce(0, (num1, num2) -> num1 + num2);
        System.out.println("result2 >> "+result2);


    }
}
