import static Enums.TaskState.*;

import Enums.TaskState;

public class StringTask implements Runnable {

    protected String text;
    protected int multiplcator;
    protected TaskState state;
    protected String result;
    protected Thread task;

    public StringTask(String text, int multiplcator){
        this.text = text;
        this.multiplcator = multiplcator;
        this.state = CREATED;
        this.result = "";

        this.task = new Thread(this);
    }

    public String getTxt(){
        return this.text;
    }

    public TaskState getState(){
        return this.state;
    }

    public boolean isDone(){
        return !this.task.isAlive();
    }

    public void abort(){
        this.state = ABORTED;
        this.task.interrupt();
    }
    
    public String getResult(){
        return this.result;
    }

    public void start() {
        this.task.start();
    }

    @Override
    public void run() {
        this.state = RUNNING;

        for(int i = 0; i < multiplcator; i++){

            String reversedString = "";
            for(int j = (this.text.length() - 1); j >= 0; j--){
                reversedString += this.text.charAt(j);

                if (this.task.isInterrupted()){
                    return;
                }
            }
            this.result = this.result + reversedString;
        }
        this.state = READY;
    }
}