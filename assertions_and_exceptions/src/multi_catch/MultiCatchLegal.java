package multi_catch;

import java.io.IOException;

public class MultiCatchLegal {

    public static void main(String[] args) {
        legalMultiCatch();
        equivalentMultiCatch();
    }

    private static void legalMultiCatch() {
        try {
            String s = "This is a legal multi-catch statement";
            int codePoint = s.codePointAt(2);
            throw new IOException();
        } catch (IndexOutOfBoundsException | IOException e) {
            System.out.println("Caught exception by legalMultiCatch()");
        }
    }

    private static void equivalentMultiCatch() {
        try {
            String s = "This multi-catch statement is equivalent to that of legalMultiCatch() method";
            int codePoint = s.codePointAt(2);
            throw new IOException();
        } catch (IOException | IndexOutOfBoundsException e) {
            System.out.println("Caught exception by equivalentMultiCatch()");
        }
    }
}
