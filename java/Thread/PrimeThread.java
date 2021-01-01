package Thread;

import java.io.IOException;

import javax.xml.catalog.Catalog;

public class PrimeThread extends Thread {
    int no = 2;
    double divisor=2;
    long sleeptime = 0;
    Thread1 t1 = new Thread1();
    Thread1 t2 = new Thread1();

    PrimeThread(long prime_time,long time1,long time2){
        sleeptime = prime_time;
        t1.setSleepTime(time1);
        t2.setSleepTime(time2);
    }

    public void run(){
        boolean flag = true;
        int ch;
        t1.start();
        t2.start();
        try
        {
            while(no != 0){
                while(divisor <= Math.sqrt(no)){
                    if((no % divisor) == 0){
                        flag = false;
                        break;
                    }
                    divisor++;
                }
                if(flag){
                    System.out.println("Prime Thread - "+no);
                }
                flag = true;
                divisor = 2;
                no++;
                Thread.sleep(sleeptime);
            }
        }
        catch(InterruptedException exc){
            exc.printStackTrace(System.err);
        }

    }
}
