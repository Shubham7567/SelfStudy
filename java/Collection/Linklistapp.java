import java.util.LinkedList;

class Linklistapp extends Thread {
    public static LinkedList<Integer> timer = new LinkedList<>();
    public static void main(String[] args){
        for(int index=59;index>=0;index--){
            timer.add(index);
        }
        Linklistapp app = new Linklistapp();
        app.start();
    }    

    public void run(){
        try{
            while(timer != null){
                System.out.println(timer.remove());
                Thread.sleep(1000);
            }
        }catch(InterruptedException exc){

        }
    }
}
