package CapgeminiInterviewQuestions;

public class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    private Integer salary;

    public Person(String name, Integer salary, Integer age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Person that) {
        // Sorting in descending order 
        if(this.getAge() < that.getAge()) return 1;
        return -1;
    }
}
