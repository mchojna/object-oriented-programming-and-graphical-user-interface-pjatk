public class Consumer implements Runnable {
    protected Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        while(true){
            System.out.println(this.buffer.get());
            // System.out.println("C: " + this.buffer);

            try {
                Thread.sleep((int)(Math.random() * 2000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
