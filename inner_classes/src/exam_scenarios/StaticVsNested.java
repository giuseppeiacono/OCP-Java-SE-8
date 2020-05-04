package exam_scenarios;

import java.util.Arrays;
import java.util.Comparator;

public class StaticVsNested {

    public static void main(String[] args) {
        String[] array = {"baby", "miki", "gianni"};

        // COMPILER ERROR: nested inner class MUST BE instantiated by an instance of the outer class
//        ReverseSorter reverseSorter = new ReverseSorter();
//        Arrays.sort(array, reverseSorter);
//        printArray(array);

        StaticVsNested.ReverseSorter reverseSorter = new StaticVsNested().new ReverseSorter();
        Arrays.sort(array, reverseSorter);
        printArray(array);

        Arrays.sort(array, new AlphabeticallySorter());
        printArray(array);
    }

    // Nested inner class
    class ReverseSorter implements Comparator<String> {
        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }

    // Static top-level class
    static class AlphabeticallySorter implements Comparator<String> {
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }

    private static void printArray(String[] array) {
        for (String s : array)
            System.out.print(s + " ");
        System.out.println();
    }
}
