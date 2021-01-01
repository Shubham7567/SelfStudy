class Threader
{
    double no=2;
    int divisor=2;
    boolean flag=true;
     
    synchronized void prime(){
        try{
        while(no>0){
            divisor = 2;
            while(divisor < Math.sqrt(no)){
                if(no % divisor == 0){
                    flag = false;
                    break;
                }
                divisor++;
            }
            if(flag){
                System.out.println(no);
            }
            no++;
            if(no == 79){
                notify();
            }
            Thread.sleep(300);
        }
        }
        catch(InterruptedException e){
            e.printStackTrace(System.err);
        }
    }

    synchronized void thread2() throws InterruptedException {
        while(no>0){
            System.out.println("#Thread2");
            Thread.sleep(400);
        }
    }

    synchronized void thread1() throws InterruptedException {
        while(no>0){
            System.out.println("#Thread1");
            Thread.sleep(200);
            if(no == 13){
                wait();
            }
        }
    }
}

class MyThread implements Runnable{
    Threader th;
    Thread thrd;

    MyThread(String name,Threader th)
    {
        thrd = new Thread();
        this.th= th;
        thrd.start();
    }

    public void run(){
        try{
            if(thrd.getName().compareTo("Prime") == 0){
                th.prime();
            }
            else if(thrd.getName().compareTo("Thread1") == 0){
                th.thread1();
            }
            else if(thrd.getName().compareTo("Thread2") == 0){
                th.thread2();
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}

class Multithreading {
    public static void main(String[] args){
        Threader th = new Threader();
        MyThread mt1 = new MyThread("Prime", th);
        MyThread mt2 = new MyThread("Thread1", th);
        MyThread mt3 = new MyThread("Thread2", th);
        try{
            mt1.thrd.join();
            mt2.thrd.join();
            mt3.thrd.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
