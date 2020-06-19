import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueSample {

    public static void main(String[] args) {
        TransferQueue<Integer> tq = new LinkedTransferQueue<>(); // not bounded

        addElemToLinkedTransferQueue(tq);
        accessValueOfLinkedTransferQueue(tq);
    }

    private static void addElemToLinkedTransferQueue(TransferQueue<Integer> tq) {
        // returns true if added or throws IllegalStateException if full
        boolean resultAdd = tq.add(1);

        try {
            // blocks if bounded and full
            tq.put(2);

            // returns true if added within the given time false if bound and full
            boolean resultOffer = tq.offer(4, 10, TimeUnit.MILLISECONDS);

            // blocks until this element is consumed
            tq.transfer(5);

            // will wait the given time for a consumer
            boolean resultTryTransfer = tq.tryTransfer(7, 10, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // returns true if added or false if bounded and full
        // recommended over add
        boolean resultOffer = tq.offer(3);

        // returns true if consumed by an awaiting thread or
        // returns false without adding if there was no awaiting consumer
        boolean resultTryTransfer = tq.tryTransfer(6);
    }

    private static void accessValueOfLinkedTransferQueue(TransferQueue<Integer> tq) {
        // gets without removing
        // throws NoSuchElementException if empty
        Integer i1 = tq.element();

        // gets without removing
        // returns null if empty
        Integer i2 = tq.peek();

        // removes the head of the queue
        // returns null if empty
        Integer i3 = tq.poll();

        // removes the head of the queue throws NoSuchElementException if empty
        Integer i4 = tq.remove();

        try {
            // removes the head of the queue, waits up to the time specified before returning null if empty
            Integer i5 = tq.poll(10, TimeUnit.MILLISECONDS);

            // removes the head of the queue blocks until an element is ready
            Integer i6 = tq.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
