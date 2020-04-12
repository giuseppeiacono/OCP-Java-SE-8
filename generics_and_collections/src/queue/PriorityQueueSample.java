package queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueSample {

    /**
     * Orders elements in the opposite of natural order
     */
    static class InverseSorting implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }

    public static void main(String[] args) {
        int[] intArray = {1,5,3,7,6,9,8};
        System.out.println("\nintArray = " + Arrays.toString(intArray));
        priorityQueueSortedByNaturalOrder(intArray);
        priorityQueueSortedByComparator(intArray);
    }

    private static void priorityQueueSortedByNaturalOrder(int[] intArray) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : intArray)
            pq.offer(i);
        printQueue(pq, "PriorityQueue sorted by natural order", intArray.length);
    }

    private static void priorityQueueSortedByComparator(int[] intArray) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new InverseSorting());
        for (int i : intArray)
            pq.offer(i);
        printQueue(pq, "PriorityQueue sorted by Comparator", intArray.length);
    }

    private static void printQueue(PriorityQueue<Integer> pq, String queueLabel, int elements) {
        System.out.print("\n" + queueLabel + " = [ ");
        for (int i = 0; i < elements; i++)
            System.out.print(pq.poll() + " ");
        System.out.println("]");
    }
}


