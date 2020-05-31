package thread_interaction;

public class WaitNotify {

    public static void main(String[] args) {
        NotifyThread notifyThread = new NotifyThread();
        notifyThread.setName("notifyThread");
        notifyThread.start();

        // this thread acquire the lock on notifyThread instance
        synchronized (notifyThread) {
            try {
                System.out.println("\n" + Thread.currentThread().getName() + " thread is waiting for notifyThread to complete...");

                // 1. called from within a synchronized context, as expected
                // 2. wait for the notification from notifyThread
                notifyThread.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()
                    + " thread received the notification from notifyThread \nTotal is: " + notifyThread.total);
        }

        try {
            // Runtime ERROR!!!
            // you can not invoke wait(), notify() or notifyAll() without first get the lock on the object
            notifyThread.wait();
        }
        catch (InterruptedException | IllegalMonitorStateException e) {
            if (e instanceof IllegalMonitorStateException){
                System.out.println("\nThe following runtime exception was thrown because this thread invoked wait() method without first get lock on the object");
                e.printStackTrace();
            }
        }
    }
}

class NotifyThread extends Thread {
    int total;

    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " started its work");
            for (int i = 0; i < 100; i++) {
                total += i;
            }

            // 1. called from within a synchronized context, as expected
            // 2. notify to the main thread that it has finished his job
            notify();
        }
    }
}