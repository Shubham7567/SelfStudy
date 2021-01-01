class Threaded{
    double no=2;
    public void GenratePrime(){
        double divisor=2;
        boolean flag=true;
        synchronized(this){
            try{
                while(no != 0){
                    while(divisor <= Math.sqrt(no)){
                        if(no % divisor == 0)
                            flag = false;
                        divisor++;
                    }
                    divisor = 2;
                    if(flag){
                        System.out.print("PrimeThread - "+no);
                    }
                    Thread.sleep(300);
                    no++;
                }
            }
            catch(InterruptedException exc){
                exc.printStackTrace(System.err);
            }
        }
    }
    public void Thread1Call(){
        synchronized(this){
            try{
                for(int index=0;index<300;index++){
                    System.out.println("Thread1 - " + index);
                    Thread.sleep(200);
                    if(no == 13){
                        wait();
                    }
                }
            }
            catch(InterruptedException exc){
                exc.printStackTrace(System.err);
            }
        }
    }
    public void Thread2Call(){
        synchronized(this){
            try{
                for(int index=0;index<300;index++){
                    System.out.println("Thread2 - " + index);
                    Thread.sleep(200);
                }
            }
            catch(InterruptedException exc){
                exc.printStackTrace(System.err);
            }
        }
    }
}

class Waiter {
    public static void main(String[] args){
        Threaded th = new Threaded();
        Thread prime = new Thread(new Runnable(){
           @Override
           public void run(){
                    th.GenratePrime();
           } 
        });
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run(){
                     th.Thread1Call();
            } 
         });
         Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run(){
                     th.Thread2Call();
            } 
         });
        
        try{
         prime.start();
         thread1.start();
         thread2.start();
          prime.join();
          thread1.join();
          thread2.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
