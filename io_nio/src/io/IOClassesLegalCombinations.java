package io;

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
            file.delete();
            boolean fileCreated = file.createNewFile();

            if (fileCreated) {
                combinationsToCreateReadersFrom(file);
                combinationsToCreateWritersFrom(file);
            }
        }
        catch (IOException e) {
            // do stuff
        }
    }

    private static void combinationsToCreateReadersFrom(File file) throws FileNotFoundException {
        System.out.println("\n--------------- READERS ---------------");
        FileReader fileReader = new FileReader(file);
        System.out.println("\u25E6 FileReader from File");
        FileInputStream fileInputStream = new FileInputStream(file);
        System.out.println("\u25E6 FileInputStream from File");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println("\u25E6 BufferedReader from FileReader");
    }

    private static void combinationsToCreateWritersFrom(File file) throws IOException {
        System.out.println("\n--------------- WRITERS ---------------");
        FileWriter fileWriter = new FileWriter(file);
        System.out.println("\u25E6 FileWriter from File");
        PrintWriter printWriter = new PrintWriter(file);
        System.out.println("\u25E6 PrintWriter from File");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        System.out.println("\u25E6 FileOutputStream from File");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        System.out.println("\u25E6 BufferedWriter from FileWriter");
    }
}
