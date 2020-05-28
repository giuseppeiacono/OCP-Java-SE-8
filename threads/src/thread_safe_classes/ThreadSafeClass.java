package thread_safe_classes;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is thread-safe, although the list is not, because the methods that access the list are synchronized
 */
public class ThreadSafeClass {

    // NOT thread-safe, but modified by synchronized methods
    private List names = new LinkedList();

    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized String removeFirst() {
        if (names.size() > 0)
            return (String) names.remove(0);
        else
            return null;
    }
}
