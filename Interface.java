// Normal Interface
interface NormalInterface {
    // public abstract here is completely optional added it for purpose of learning and further understanding
    public abstract void method1OfNormalInterface();
    // As mentioned in above comment the public abstract is optional. 
    // By Default all the function in the interface are public abstract. To show this is the below 
    // without public abstract method
    void method2OfNormalInterface();
}

// Interface with static and default method
// Advantage of using static, default access modifiere is we can have declaration and definition
interface DefaultAndStaticMethodInterface{
    // Instead of abstract access modifier if we using default we can also have function declaration.
    default void defaultMethod(){
        System.out.println("Inside the default Method of DefaultAndStaticMethodInterface interface");
    }
    // By using static keyword instead of default we can have function declaration
    // Advantage of static over default object of class creation is not required
    static void staticMethod(){
        System.out.println("Inside the static Method of DefaultAndStaticMethodInterface interface");
    }
}

// Interface with only one abstract method is called functional interfaces
// With the help of functional interface we can write lambda expression
@FunctionalInterface
interface functionalInterface{
    void functionalInterfaceAbstractMethod();
}

class InterfaceImplementation implements NormalInterface, DefaultAndStaticMethodInterface {
    @Override
    public void method1OfNormalInterface() {
        System.out.println("Inside the method1OfNormalInterface overrided inside the InterfaceImplementation Class");
    }

    @Override
    public void method2OfNormalInterface() {
        System.out.println("Inside the method2OfNormalInterface overrided inside the InterfaceImplementation Class");
    }
}
public class Interface {
    public static void main(String[] args) {
        // Implementing the NormalInterface with anonymous class
        NormalInterface normalInterfaceObj1 = new NormalInterface() {
            @Override
            public void method1OfNormalInterface() {
                System.out.println("Inside the method1OfNormalInterface overrided inside the anonymous class");
            }

            @Override
            public void method2OfNormalInterface() {
                System.out.println("Inside the method2OfNormalInterface overrided inside the anonymous class");
            }
        };
        normalInterfaceObj1.method1OfNormalInterface();
        normalInterfaceObj1.method2OfNormalInterface();


        // Implementing the NormalInterface
        NormalInterface normalInterfaceObj2 = new InterfaceImplementation();
        normalInterfaceObj2.method1OfNormalInterface();
        normalInterfaceObj2.method2OfNormalInterface();
        
        // Implementing the default and static
        DefaultAndStaticMethodInterface defaultAndStaticMethodInterface = new InterfaceImplementation();
        defaultAndStaticMethodInterface.defaultMethod();
        DefaultAndStaticMethodInterface.staticMethod();

        // Function Interface implementation with lambda expression
        functionalInterface functionalinterface = () -> {
            System.out.println("This is method of inside the functional interface");
        };

        // This line is used to implement the functional interface print method
        functionalinterface.functionalInterfaceAbstractMethod();
    }
}
