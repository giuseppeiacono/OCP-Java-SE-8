package try_catch_with_resources;

import java.io.IOException;

public class SuppressedExcpetions {

    public static void main(String[] args) {
        mainExceptionThrownByTryBlock();
        mainExceptionThrownByResource();
    }

    private static void mainExceptionThrownByTryBlock() {
        try (MyAutoCloseable myResource = new MyAutoCloseable("resource 1")) {
            throw new IOException("mainExceptionThrownByTryBlock() : try");
        } catch (Exception e) {
            System.err.println((e.getMessage()));
            for (Throwable t : e.getSuppressed()) {
                System.err.println("suppressed: " + t + "\n");
            }
        }
    }

    private static void mainExceptionThrownByResource() {
        try ( MyAutoCloseable myResource1 = new MyAutoCloseable("resource 1");
              MyAutoCloseable myResource2 = new MyAutoCloseable("resource 2");
              MyAutoCloseable myResource3 = new MyAutoCloseable("resource 3") ) {
            // do stuff
        } catch (Exception e) {
            System.err.println("mainExceptionThrownByResource() : " + e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.err.println("suppressed: " + t);
            }
        }
    }
}

class MyAutoCloseable implements AutoCloseable {

    String name;

    MyAutoCloseable(String name) {
        this.name = name;
    }

    @Override
    public void close() throws Exception {
        throw new IOException(name);
    }
}