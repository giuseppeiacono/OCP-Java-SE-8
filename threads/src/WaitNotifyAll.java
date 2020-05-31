public class WaitNotifyAll {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        new Reader(calculator).start();
        new Reader(calculator).start();
        new Reader(calculator).start();
        new Thread(calculator).start();
    }
}

class Reader extends Thread {
    Calculator calculator;

    public Reader(Calculator calc) {
        calculator = calc;
    }

    public void run() {
        synchronized (calculator) {
            try {
                System.out.println("Waiting for calculation...");
                calculator.wait();
            }
            catch (InterruptedException e) { }
            System.out.println("Total is: " + calculator.total);
        }
    }
}

class Calculator implements Runnable {
    int total;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                total += i;
            }
            notifyAll();
        }
    }
}
