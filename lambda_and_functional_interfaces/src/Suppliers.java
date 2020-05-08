import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Scenario: the supplier status is invoked depending on the logger Level
 */
public class Suppliers {

    public static void main(String[] args) {
        logByLevel(Level.SEVERE);
        logByLevel(Level.INFO);
        logByLevel(Level.FINE);
    }

    private static void logByLevel(Level logLevel) {
        String host = "coderanch.com";
        int port = 80;

        // set up logging
        Logger logger = Logger.getLogger("Status Logger");
        logger.setLevel(logLevel);
        System.out.println("\nLog by " + logLevel);

        // in case we need to check the status
        Supplier<String> status = () -> {
            int timeout = 1000;
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(host, port), timeout);
                return "up";
            } catch (IOException e) {
                return "down";  // Error; can't reach the system!
            }
        };

        try {
            // only calls the get() method of the status Supplier
            // if level is INFO or below
            logger.log(Level.INFO, status);

            throw new Exception();
        } catch (Exception e) {
            // calls the get() method of the status Supplier
            // if level is SEVERE or below
            logger.log(Level.SEVERE, status);
        }
    }
}
