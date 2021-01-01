class TickTock{
    String state;
    
    synchronized void tick(boolean running){
        if(!running){
            state = "ticked";
            notify();
            return;
        }

        System.out.println("Tick");
        
        state = "ticked";

        notify();
        try{
            while(!state.equals("tocked")){
                wait();
            }
        }catch(InterruptedException exc){
            System.out.println("Interrupter");
            exc.printStackTrace(System.err);
        }
    }
    synchronized void tock(boolean running){
        if(!running){
            state = "tocked";
            notify();
            return;
        }

        System.out.println("Tock");
        state = "tocked";
        notify();
        try{
            while(!state.equals("ticked")){
                wait();
            }
        }catch(InterruptedException exc){
            System.out.println("Interrupter");
            exc.printStackTrace(System.err);
        }
    }
}

class MyThread implements Runnable{
    Thread thread;
    TickTock ttOb;

    MyThread(String name,TickTock tt){
        thread = new Thread(this,name);
        ttOb = tt;
        thread.start();
    }

    public void run(){
        if(thread.getName().compareTo("Tick") == 0){
            for(int iterator = 0;iterator < 5;iterator++){
                ttOb.tick(true);
            }
            ttOb.tick(false);
        }else{
            for(int iterator = 0;iterator < 5;iterator++){
                ttOb.tock(true);
            }
            ttOb.tock(false);
        }
    }
}

public class Threadcom {
    public static void main(String[] args){
        TickTock tt = new TickTock();
        MyThread m1 = new MyThread("Tick", tt);
        MyThread m2 = new MyThread("Tock", tt);
        try{
            m1.thread.join();
            m2.thread.join();
        }catch(InterruptedException exc){
            System.out.println("Main thread is interrupted.");
            exc.printStackTrace(System.err);
        }
    }
}
