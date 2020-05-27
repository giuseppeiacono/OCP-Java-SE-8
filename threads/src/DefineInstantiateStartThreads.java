public class DefineInstantiateStartThreads {

    public static void main(String[] args) {
        System.out.println("\nThread of the main() method = { ID = " + Thread.currentThread().getId()
                + ", NAME = " + Thread.currentThread().getName() + " }");

        MyOwnThread myOwnThread = new MyOwnThread();
        myOwnThread.setName("my own thread");
        myOwnThread.start();    // starts new thread

        MyOwnRunnable myOwnRunnable = new MyOwnRunnable();
        myOwnRunnable.run();    // it is executed on the same thread of the main method

        Runnable runnable = () -> {
            System.out.println("\nID = " + Thread.currentThread().getId()
                    + "\nNAME = " + Thread.currentThread().getName()
                    + "\nJOB = this thread was defined passing the target runnable to the Thread class");
        };
        Thread thread = new Thread(runnable);   // constructor generates the thread name
        thread.start();
    }
}

class MyOwnThread extends Thread {
    @Override
    public void run() {
        System.out.println("\nID = " + Thread.currentThread().getId()
                + "\nNAME = " + Thread.currentThread().getName()
                + "\nJOB = this thread was defined extending Thread class");
    }
}

class MyOwnRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("\nID = " + Thread.currentThread().getId()
                + "\nNAME = " + Thread.currentThread().getName()
                + "\nJOB = this thread was defined implementing Runnable interface");
    }
}