package thread_safe_classes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class has a thread-safe list, but it's not enough to guarantee that the class is thread-safe
 * because the methods that access this field are NOT synchronized
 */
public class NonThreadSafeClass {

    // thread-safe
    private List<String> names = Collections.synchronizedList(
            new LinkedList<>()
    );

    // ISSUE: NOT synchronized!!!
    public void add(String name) {
        // add() is synchronized because the list is thread-safe
        names.add(name);
    }

    // ISSUE: NOT synchronized!!!
    public String removeFirst() {
        // size() is synchronized because the list is thread-safe
        if (names.size() > 0)
            return (String) names.remove(0);
        else
            return null;
    }
}
