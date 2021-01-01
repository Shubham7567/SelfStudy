class Tasks implements Runnable{
    double no;
    double divisor;
    boolean flag;
    Thread th;

    Tasks(){
        th = new Thread();
        no = 2;
        divisor = 2;
        flag = true;
        th.start();
    }

    synchronized void primer(){
        try{
            while(no > 0){
                divisor = 2;
                flag = true;
                while(divisor <= Math.sqrt(no)){
                    if((no%divisor) == 0){
                        flag = false;
                        break;
                    }
                    divisor++;
                }
                if(flag){
                    System.out.println(no);
                }
                if(no == 79){
                    notify();
                }
                no++;
                Thread.sleep(200);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized void thread1(){
        try{
            while(no > 0){
                System.out.println("#Thread1");
                Thread.sleep(300);
                if(no == 13){
                    wait();
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}



class ThreadCom{
    public static void main(String[] args){
        Tasks tt = new Tasks();
        try{
            tt.th.join();
        }catch(Exception e){

        }
    }
}