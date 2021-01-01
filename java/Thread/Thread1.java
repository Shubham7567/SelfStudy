package Thread;

public class Thread1 extends Thread {
    int index = 0;
    long sleeptime;

    public void setSleepTime(long time) {
        sleeptime = time;
    }

    public synchronized void operation(){
        try{
            for(index=0;index<100;index++){
                System.out.println("Thread" + this.getId() + " - " + index);
                Thread.sleep(sleeptime);
            }
        }
        catch(InterruptedException exc){
            exc.printStackTrace(System.err);
        }
    }

    public void run(){
        operation();
    }
}
