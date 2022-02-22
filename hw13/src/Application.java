import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    public static volatile AtomicInteger number = new AtomicInteger(0);

    public static synchronized int incrementNumber(){
        return number.getAndIncrement();
    }


    static class NewThread extends Thread {
        private final byte colorId;

        public NewThread(String name, byte colorId) {
            this.colorId = colorId;
            setName(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(TextColorUtils.getInColor("" + i + ": " + getName() + ": " + incrementNumber(), colorId));
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread[] boxOfThreads = {
                new NewThread("Stream 1", ColorIds.CYAN),
                new NewThread("Stream 2", ColorIds.YELLOW),
                new NewThread("Stream 3", ColorIds.RED)
        };
        runAllThreads(boxOfThreads);
        for (int i = 0; i < 20; i++) {
            System.out.println(TextColorUtils.getInColor("" + i + ": Main stream: " + incrementNumber(), ColorIds.WHITE));
        }
    }

    private static void runAllThreads(Thread[] threads) throws InterruptedException {
        for (Thread curThread: threads) {
            curThread.start();
            curThread.join();
        }
    }
}
