// Eventhough it has two methods it is functional interface because it has only one abstract method
@FunctionalInterface
interface Demo{
    void show();
    default void defaultMethod(){
        System.out.println("This is default method interface");
    }
}

@FunctionalInterface
interface Demo1{
    void show();
}

//Since we have two same methods in the abstract class we should override the method
class DemoImp implements Demo, Demo1{
    @Override
    public void show() {
        System.out.println("We should override this method here to avoid the multiple inheritance problem");
    }
}

public class MultipleInterfaceInheritance {
    public static void main(String[] args) {
        Demo demo = new DemoImp();
        demo.show();
        demo.defaultMethod();

        Demo1 demo1 = () -> System.out.println("Implementating using lambda expression");
        demo1.show();
    }
}
