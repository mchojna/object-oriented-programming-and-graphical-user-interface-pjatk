public class Producer implements Runnable {
    Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        while(true){
            this.buffer.put((int)(Math.random() * 3));
            // System.out.println("P: " + this.buffer);

            try {
                Thread.sleep((int)(Math.random() * 2000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}