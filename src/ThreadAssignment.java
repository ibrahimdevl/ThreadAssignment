import java.lang.Thread;

public class ThreadAssignment {

    static class Counter {
        void count() {
                for(int i=350; i>0;i--){
                    System.out.println(i);
                }
            System.out.println("finish");
            }

    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            synchronized(counter){
                counter.count();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        MyThread myThread1;
        myThread1 = new MyThread(counter);
        MyThread myThread2;
        myThread2 = new MyThread(counter);
        myThread1.start();
        myThread1.join();
        myThread2.start();
        myThread2.join();
        System.out.println("Done");

    }
}
