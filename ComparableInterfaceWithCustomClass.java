import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
    private String name;
    int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Student that) {
        // Sorting the student object in descending order
        if(this.age < that.age) return 1;
        return -1;
    }
    
}
public class ComparableInterfaceWithCustomClass {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
            new Student("ABCD", 10),
            new Student("EFGH", 25),
            new Student("IJKL", 19),
            new Student("MNOP", 40),
            new Student("QRST", 20)
        );

        // Sorting based on age in descending order using Comparator interface with lambda function
        // Collections.sort(studentList, (stud1, stud2)->{
        //     if(stud1.age < stud2.age) return 1;
        //     return -1;
        // });
        
        // Sorting using the Comparable Interface which is implemented in the Student custom class
        Collections.sort(studentList);

        // Print the Student object
        for(Student stud:studentList){
            System.out.println(stud);
        }
    }
}
