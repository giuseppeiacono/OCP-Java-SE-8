package deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class ArrayDequeSample {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 9, 8, 7, 6, 5);
        ArrayDeque<Integer> a = new ArrayDeque<>();
        ArrayDeque<Integer> b = new ArrayDeque<>();
        ArrayDeque<Integer> c = new ArrayDeque<>();
        ArrayDeque<Integer> d = new ArrayDeque<>();
        ArrayDeque<Integer> e = new ArrayDeque<>();

        addElements(nums, a, b, c, d, e);
        returnElements(e);
        returnAndRemoveElements(a, c);
    }

    private static void addElements(List<Integer> nums, ArrayDeque<Integer> a, ArrayDeque<Integer> b, ArrayDeque<Integer> c, ArrayDeque<Integer> d, ArrayDeque<Integer> e) {
        System.out.println("\n----------------- Add elements to the ArrayDeque -----------------");

        for (Integer i : nums) {
            a.offer(i);
            b.add(i);
            c.offerFirst(i);
            d.push(i);
            e.addFirst(i);
        }

        System.out.println("\nlist nums = " + nums);
        System.out.println("\nadd(e) and offer(e) add the element to the END of the ArrayDeque");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("\nofferFirst(e), push(e) and addFirst(e) add the element to the FRONT of the ArrayDeque");
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
    }

    private static void returnElements(ArrayDeque<Integer> arrayDeque) {
        System.out.println("\n----------------- Return elements from the ArrayDeque without remove it -----------------");
        System.out.println("\narrayDeque = " + arrayDeque);
        System.out.println("peek() returns the first element of the ArrayDeque: " + arrayDeque.peek());
        System.out.println("arrayDeque hasn't changed: " + arrayDeque);
    }

    private static void returnAndRemoveElements(ArrayDeque<Integer> a, ArrayDeque<Integer> b) {
        System.out.println("\n----------------- Return and remove elements from the ArrayDeque -----------------");
        System.out.println("\na = " + a);
        System.out.println("poll() returns and removes the FIRST element: " + a.poll());
        System.out.println("a has been modified: " + a);
        System.out.println("pop() returns and removes the FIRST element: " + a.pop());
        System.out.println("a has been modified: " + a);

        System.out.println("\nb = " + b);
        System.out.println("pollLast() returns and removes the LAST element: " + b.pollLast());
        System.out.println("b has been modified: " + b);
        System.out.println("removeLast() returns and removes the LAST element: " + b.removeLast());
        System.out.println("b has been modified: " + b);
    }
}
