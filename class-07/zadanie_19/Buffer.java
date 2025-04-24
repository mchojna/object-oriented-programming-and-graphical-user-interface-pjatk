import java.util.Arrays;

public class Buffer {
    
    protected int[] bufferArr;
    protected int index;

    public Buffer(int size){
        this.bufferArr = new int[size];
        index = 0;
    }

    public synchronized void put(int n){
        while(this.index == (this.bufferArr.length - 1)){
            try {
                wait();
            } catch (InterruptedException e) {
                
            }
        }
        notify();
        this.bufferArr[this.index++] = n;
    }
    
    public synchronized int get(){
        while(this.index == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                
            }
        }
        notify();

        int number = this.bufferArr[--this.index];

        this.bufferArr[this.index] = 0;

        return number;
    }

    @Override
    public String toString(){
        return Arrays.toString(this.bufferArr);
    }
}
