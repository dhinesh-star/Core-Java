import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorInteface {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(43, 31, 29, 72);
        // Sorting the Elements in this list by comparing the last digit as the Logic
        // Using Comparator and anonymous  class
        Comparator<Integer> con = new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2){
                if(num1 % 10 > num2%10) return 1;
                else return -1; 
            }
        };
        // Collections.sort(nums, con);
        
        // Using Comparator and lambda function
        Comparator<Integer> con1 = (num1, num2) -> num1%10 > num2%10 ? 1:-1;
        // Collections.sort(nums, con1);

        // Using Lambda function inside the Collection function
        Collections.sort(nums, (num1, num2) -> num1%10 > num2%10 ? 1:-1);
        System.out.println(nums);
    }
}
