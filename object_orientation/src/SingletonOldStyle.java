/**
 * The older version of the pattern as enum. Sometimes you still need it
 */
public enum SingletonOldStyle {

    // this is the singleton
    INSTANCE;

    private String singletonName;

    private SingletonOldStyle() {
        this.singletonName = "this is the old style of Singleton pattern implementation (e.g. on Java 5)";
    }
}
