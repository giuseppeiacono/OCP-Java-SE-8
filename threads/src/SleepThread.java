public class SleepThread {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            int counter = 1;
            for (int n = 1; n < 101; n++) {
                System.out.print(counter + " ");
                try {
                    Thread.sleep(100L);    // thread sleep at least 100 millisecond before to print the next number
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (n != 0 && n % 10 == 0)
                    System.out.println("...the thread printed 10 numbers...");
                counter++;
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }
}
