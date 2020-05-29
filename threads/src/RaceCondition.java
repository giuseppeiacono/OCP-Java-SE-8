import java.util.HashSet;
import java.util.Set;

public class RaceCondition {

    public static void main(String[] args) {
        RaceCondition testThreads = new RaceCondition();
        testThreads.go();
    }

    public void go() {
        Thread thread1 = new Thread(() -> {
            ticketAgentBooks("12A");
            ticketAgentBooks("12B");
        });

        Thread thread2 = new Thread(() -> {
            ticketAgentBooks("12A");
            ticketAgentBooks("12B");
        });

        thread1.start();
        thread2.start();
    }

    public void ticketAgentBooks(String seat) {
        Cinema show = Cinema.getInstance();
        System.out.println(Thread.currentThread().getName() + ": " + show.bookSeat(seat));
    }
}

class Cinema {

    // resource shared by threads
    private static Cinema INSTANCE;

    private Set<String> availableSeats;

    // the only one that access the shared resource
    public static Cinema getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Cinema();  // create a singleton instance
        }
        return INSTANCE;
    }

    private Cinema() {
        availableSeats = new HashSet<String>();
        availableSeats.add("12A");
        availableSeats.add("12B");
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}