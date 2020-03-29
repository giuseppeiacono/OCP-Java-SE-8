/**
 * The simplest way to implement this pattern on Java 8+
 * It's not thread-safe, but we could fix it by adding synchronized to the method getInstance() or
 * with double checked locked pattern
 */
public class SingletonNewStyle {

    // this is the singleton
    private static final SingletonNewStyle INSTANCE = new SingletonNewStyle();

    private String singletonName;

    // return the singleton
    public static SingletonNewStyle getInstance() {
        return INSTANCE;
    }

    private SingletonNewStyle() {
        this.singletonName = "this is the simplest way to implement the Singleton pattern on Java 8";
    }
}

