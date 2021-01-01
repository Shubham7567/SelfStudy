package iostream.proverbs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteProverbs {
    public static void main(String[] args){
        String dirName = "D:/JAVA_Practice/SessionalIIExam/IOStream/txt";
        String fileName = "proverbs.txt";
        String[] sayings = {
            "Indecision maximizes flexibility.",
            "Only the mediocre are always at their best.",
            "A little knowledge is a dangerous thing.",
            "Many a mickle makes a muckle.",
            "Who begins too much achieves a little.",
            "Who knows most says least.",
            "A wise man sits on the hole in the carpet."
        };
        File aFile = new File(dirName,fileName);

        FileOutputStream outputFile = null;
        try{
            outputFile = new FileOutputStream(aFile,true);
        }catch(FileNotFoundException e){
            e.printStackTrace(System.err);
            System.exit(1);
        }
        FileChannel outChannel = outputFile.getChannel();

        int maxLength = 0;
        for(String saying : sayings){
            if(maxLength < saying.length())
                maxLength = saying.length();
        }

        ByteBuffer buf = ByteBuffer.allocate(2*maxLength + 4);
        
        try{
            for(String saying : sayings){
                buf.putInt(saying.length()).asCharBuffer().put(saying);
                buf.position(buf.position() + 2*saying.length()).flip();
                outChannel.write(buf);
                buf.clear();
            }
            outputFile.close();
            System.out.println("Proverbs written to file.");
        }
        catch(IOException e){
            e.printStackTrace(System.err);
            System.exit(1);
        }
        System.exit(0);
    }
}
