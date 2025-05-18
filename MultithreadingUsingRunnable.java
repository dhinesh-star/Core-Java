public class MultithreadingUsingRunnable {
    public static void main(String[] args) {
        // Creating object that implements the Runnable interface - obj1, obj2
        Runnable obj1 = () -> {
            for(int i = 0; i < 10; i++) {
                System.out.println("Hi");
                try{
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable obj2 = () -> {
            for(int i = 0; i < 10; i++) {
                System.out.println("Hello");
                try{
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        /*
        Creating Threading object class having the Runnable object created before as parameter
        Note - We are thread object because it contains the start method which will run the thread simultaneously
         */
        Thread thread1 = new Thread(obj1);
        Thread thread2 = new Thread(obj2);

        // Starting the thread
        thread1.start();
        thread2.start();
    }
}
