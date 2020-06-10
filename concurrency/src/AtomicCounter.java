import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    // atomic field
    private AtomicInteger counter = new AtomicInteger();

    public void increment() {
        counter.getAndIncrement(); // atomic operation
    }

    public int getValue() {
        return counter.intValue();
    }
}
