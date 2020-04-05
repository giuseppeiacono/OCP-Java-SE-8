package properties;

import java.io.*;
import java.util.Properties;

public class ReadWriteProperties {

    private static final File PROPERTIES_FILE = new File("dates_times_locales_and_resource_bundles/myProps.properties");

    public static void main(String[] args) throws IOException {
        Properties p1 = new Properties();
        p1.setProperty("a", "a");
        p1.setProperty("b", "b");
        p1.list(System.out);

        try {
            FileOutputStream outputStream = new FileOutputStream(PROPERTIES_FILE);
            // store properties on myProps.properties to be read later with load() method
            p1.store(outputStream, "test");
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("exception outputStream");
        }

        Properties p2 = new Properties();
        p2.setProperty("c", "c");

        try {
            FileInputStream inputStream = new FileInputStream(PROPERTIES_FILE);
            // read properties from myProps.properties that were previously set with method store()
            p2.load(inputStream);
            inputStream.close();
            p2.list(System.out);
        } catch (FileNotFoundException e) {
            System.out.println("exception inputStream");
        }

        PROPERTIES_FILE.delete();
    }
}
