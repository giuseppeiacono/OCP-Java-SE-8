public class DefiningThreads {

    public static void main(String[] args) {
        printCurrentThreadDetails();

        MyOwnThread myOwnThread = new MyOwnThread();
        myOwnThread.setName("my own thread");
        myOwnThread.start();    // start a new thread

        MyOwnRunnable myOwnRunnable = new MyOwnRunnable();
        myOwnRunnable.run();    // it is executed on the same thread of the main method

        Runnable runnable = () -> {
            printCurrentThreadDetails();
            System.out.println("This thread was defined passing the target runnable to the Thread class");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    protected static void printCurrentThreadDetails() {
        System.out.println("current thread = { ID = " + Thread.currentThread().getId()
                + ", NAME = " + Thread.currentThread().getName() + " }");
    }
}

class MyOwnThread extends Thread {

    @Override
    public void run() {
        DefiningThreads.printCurrentThreadDetails();
        System.out.println("This thread was defined extending Thread class");
    }
}

class MyOwnRunnable implements Runnable {

    @Override
    public void run() {
        DefiningThreads.printCurrentThreadDetails();
        System.out.println("This thread was defined implementing Runnable interface");
    }
}