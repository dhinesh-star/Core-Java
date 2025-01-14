import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class forEach {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 7, 3, 2);

        // Creating the reference of Consumer interface with anonymous class
        System.out.println("------------------------------------");
        Consumer<Integer> con1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {
                System.out.println(num);
            }
        };
        nums.forEach(con1);
        System.out.println("------------------------------------");

        // Creating the reference of Consumer interface with lambda expression
        Consumer<Integer> con2 = num  -> System.out.println(num);
        System.out.println("------------------------------------");
        nums.forEach(con2);
        System.out.println("------------------------------------");

        // Directly using con2 statements inside forEach loop
        System.out.println("------------------------------------");
        nums.forEach((n) -> System.out.println(n));
        System.out.println("------------------------------------");

    }
}
