package iostream.randomaccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

public class RandomReadWrite {
    public static void main(String[] args){
        File aFile = new File("D:/JAVA_Practice/SessionalIIExam/IOStream/txt/phrase.txt");
        FileInputStream inFile = null;
        FileOutputStream outFile = null;

        try{
            inFile = new FileInputStream(aFile);
            outFile = new FileOutputStream(aFile,true);
        }catch(FileNotFoundException e){
            e.printStackTrace(System.err);
            System.exit(1);
        }
        FileChannel inChannel = inFile.getChannel();
        FileChannel outChannel = outFile.getChannel();
        
        final int PERMISSIONREQUIRED = 10;
        ByteBuffer buf = ByteBuffer.allocate(8);
        long[] primes = new long[PERMISSIONREQUIRED];
        int index = 0;
        final long REPLACEMENT = 99999L;

        try{
            final int PRIMECOUNT = (int)inChannel.size()/8;
            System.out.println("Prime count = "+ PRIMECOUNT);
            for(int i=0;i<PERMISSIONREQUIRED; i++){
                index = 8 * (int)(PERMISSIONREQUIRED*Math.random());
                inChannel.read(buf,index);
                buf.flip();
                primes[i] = buf.getLong();
                buf.flip();
                buf.putLong(REPLACEMENT);
                outChannel.write(buf,index);
                buf.clear();
            }
            int count=0;
            for(long prime : primes){
                System.out.printf("%12d",prime);
                if(++count%5 == 0){
                    System.out.println();
                }
            }
            inFile.close();
            outFile.close();
        }
        catch(IOException e){
            e.printStackTrace(System.err);
            System.exit(1);
        }
        System.exit(0);
    }
}
