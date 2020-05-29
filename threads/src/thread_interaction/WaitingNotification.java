package thread_interaction;

public class WaitingNotification {

    public static void main(String[] args) {
        NotifyThread notifyThread = new NotifyThread();
        notifyThread.setName("notifyThread");
        notifyThread.start();

        synchronized (notifyThread) {
            try {
                System.out.println("\n" + Thread.currentThread().getName() + " thread is waiting for notifyThread to complete...");

                // 1. wait() is called from within a synchronized context
                // 2. the main thread acquired the lock of notifyThread instance and
                //    wait for the notification from notifyThread
                notifyThread.wait();
            }
            catch (InterruptedException e) {
                // do stuff
            }
            System.out.println(Thread.currentThread().getName()
                    + " thread received the notification from notifyThread \nTotal is: " + notifyThread.total);
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
            notify();   // called from within a synchronized context
        }
    }
}