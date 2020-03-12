package multi_catch;

public class RethrowingException {

    public static void main(String[] args) throws A, B {
        rethrowingExcJava6();
        rethrowingExcJava8WithDuplication();
        rethrowingExcJava8WithoutDuplication();
    }

    private static void rethrowingExcJava6() throws A, B {
        try {
            couldThrowExceptions();
        } catch (A e) {
            System.out.println("Caught A by rethrowingExcJava6()");
            throw e;
        } catch (B e) {
            System.out.println("Caught B by rethrowingExcJava6()");
            throw e;
        }
    }

    private static void rethrowingExcJava8WithDuplication() throws A, B {
        try {
            couldThrowExceptions();
        } catch (A | B e) {
            System.out.println("Caught A or B exception by rethrowingExcJava8WithDuplication()");
            throw e;
        }
    }

    private static void rethrowingExcJava8WithoutDuplication() throws A, B {
        try {
            couldThrowExceptions();
        } catch (Exception e) {
            System.out.println("Caught A or B exception by rethrowingExcJava8WithDuplication()");
            throw e;
        }
    }

    private static void couldThrowExceptions() throws A, B { }
}

class A extends Exception { }

class B extends Exception { }
