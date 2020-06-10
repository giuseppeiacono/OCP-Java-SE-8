import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSamples {

    public static void main(String[] args) {
        lock();
        tryLock();
        tryLockWithinTime();
    }

    private static void lock() {
        Lock lock = new ReentrantLock();
        lock.lock();    // blocks until acquire the lock
        try {
            // do stuff
        } finally {
            lock.unlock();  // must manually release
        }
    }

    private static void tryLock() {
        Lock lock = new ReentrantLock();
        boolean locked = lock.tryLock();    // acquire lock, else try again later
        if (locked) {
            try {
                // do stuff
            } finally {
                lock.unlock();  // must manually release
            }
        }
    }

    private static void tryLockWithinTime() {
        Lock lock = new ReentrantLock();
        try {
            boolean locked = lock.tryLock(3, TimeUnit.SECONDS);
            if (locked) {
                try {
                    // do stuff
                } finally {
                    lock.unlock();  // must manually release
                }
            }
        } catch (InterruptedException ex) {
            // handle
        }
    }
}
