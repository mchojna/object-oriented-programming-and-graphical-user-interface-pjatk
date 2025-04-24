public class Letters {

    protected String text;
    protected Thread[] textThreads;

    public Letters(String text){
        this.text = text;

        this.textThreads = new Thread[this.text.length()];

        for(int i = 0; i < this.textThreads.length; i++){

            char letter = this.text.charAt(i);
            int letterIndex = i;

            this.textThreads[i] = new Thread(
                () -> {

                    Thread.currentThread().setName("Thread " + letter);

                    while(true){
                        System.out.print(text.charAt(letterIndex));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            );
        }
    }

    public Thread[] getThreads(){
        return this.textThreads;
    }
}