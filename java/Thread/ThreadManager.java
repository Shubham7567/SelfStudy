package Thread;

import java.io.IOException;

public class ThreadManager {
    public static void main(String[] args){
        PrimeThread thread = new PrimeThread(Long.parseLong(args[0]),Long.parseLong(args[1]),Long.parseLong(args[2]));
        thread.start();
        try{
            System.in.read();
        }catch(IOException e){
            e.printStackTrace(System.err);
        }
    }
}
