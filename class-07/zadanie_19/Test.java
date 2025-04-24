public class Test {
    public static void main(String[] args){
        Buffer buffer = new Buffer(10);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();


    new Thread(
        () -> {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {

            }

            producerThread.interrupt();
            consumerThread.interrupt();
        }
    ).start();

    }
}
