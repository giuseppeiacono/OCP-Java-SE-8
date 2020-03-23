import java.io.*;

/**
 * This class has the only purpose to show legal combinations of I/O classes used in the exam.
 */
public class IOClassesLegalCombinations {

    public static void main(String[] args) {
        try {
            // create file object
            File file = new File("file.txt");

            // create file on the disk
            file.createNewFile();

            combinationsToCreateReadersFrom(file);
            combinationsToCreateWritersFrom(file);
        }
        catch (IOException e) {
            // do stuff
        }
    }

    private static void combinationsToCreateReadersFrom(File file) throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
    }

    private static void combinationsToCreateWritersFrom(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    }
}
