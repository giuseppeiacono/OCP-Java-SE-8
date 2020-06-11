import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockSample {

    public static void main(String[] args) {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();

        loop:
        while (true) {
            boolean aq2 = l2.tryLock();
            boolean aq1 = l1.tryLock();
            try {
                if (aq1 && aq2) {
                    // do stuff
                    break loop;
                }
            }
            finally {
                if (aq2) l2.unlock();
                if (aq1) l1.unlock();
            }
        }
    }
}
