package iostream.custom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteAStringAsBytes{
    public static void main(String[] args){
        String phrase = new String("Garbage in, garbage out\n");
        String dirName = "D:/JAVA_Practice/SessionalIIExam/IOStream/txt";
        //String dirName = "txt/file1";
        String fileName = "byteData.txt";

        File aFile = new File(dirName,fileName);
        FileOutputStream file = null;

        try{
            file = new FileOutputStream(aFile, true);
        }catch(FileNotFoundException exc){
            exc.printStackTrace(System.err);
        }

        FileChannel outChannel = file.getChannel();
        ByteBuffer buff = ByteBuffer.allocate(phrase.length());
        byte[] bytes = phrase.getBytes();

        buff.put(bytes);
        buff.flip();

        try{
            outChannel.write(buff);
            file.close();
        }catch(IOException exc){
            exc.printStackTrace(System.err);
        }
    }
}