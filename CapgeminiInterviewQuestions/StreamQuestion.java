package CapgeminiInterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    Declare a Person Class with following variables
    name, age, salary.
    1. Get the name olded person(based on age) from the List of Person variables
*/
public class StreamQuestion {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
            new Person("abcd", 50000, 23),
            new Person("efgh", 150000, 28),
            new Person("ijkl", 100000, 30)
        );

        // 1st Approach using reduce method in stream API
        // Person maxAgePerson = personList.stream()
        //         .reduce(null, (p1, p2) ->{
        //             if(p1 != null && p1.getAge() > p2.getAge()) return p1;
        //             return p2;
        //         });

        // 2nd Approach using sorted function in stream API
        Comparator<Person> con = (person1, person2) -> {
            if(person1.getAge() > person2.getAge()) return -1;
            return 1;
        };
        // Person maxAgePerson = personList.stream()
        //                                 .sorted(con)
        //                                 .findFirst()
        //                                 .orElse(null);

        // 2nd Approach using sorted function but Comparable interface implemented in Student Class in stream API.
        Person maxAgePerson = personList.stream()
                                        .sorted()
                                        .findFirst()
                                        .orElse(null);

        System.out.println("maxAgePerson name >>"+maxAgePerson.getName());
    }
}
