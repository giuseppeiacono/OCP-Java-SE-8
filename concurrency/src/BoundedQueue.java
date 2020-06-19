import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BoundedQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        try {
            queue.put(1);
            queue.put(2);
            queue.put(3);   // the queue is full

            queue.put(4);   // blocks until one value is removed
        } catch (InterruptedException ex) {
            // handle exception
        }
    }
}
