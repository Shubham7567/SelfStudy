package iostream.custom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteAString {
    public static void main(String[] args){
        String phrase = new String("Garbage in, garbage out\n");
        String dirName = "D:/JAVA_Practice/SessionalIIExam/IOStream/txt";
        //String dirName = "txt/file1";
        String fileName = "charData.txt";

        File dir = new File(dirName);

        //Now checkout the directory
        if(!dir.exists()){
            if(!dir.mkdir()){
                System.out.println("Cannot create directory "+ dirName);
                System.exit(1);
            }
        }else if(!dir.isDirectory()){
            System.err.println(dirName + " is not a directory");
            System.exit(1);
        }

        //Create the filestream
        File aFile = new File(dir,fileName);
        FileOutputStream output = null;
        try{
            output = new FileOutputStream(aFile,true);
            System.out.println("File stream created successfully.");
        }catch(FileNotFoundException exc){
            exc.printStackTrace(System.err);
        }

        //Create the fileoutput stream  channel and the buffer
        FileChannel outputChannel = output.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("New Buffer position: " + buf.position() + "\tLimit = " + buf.limit() + "\tCapacity = " + buf.capacity());

        //Load the data to buffer
        for(char ch : phrase.toCharArray()){
            buf.putChar(ch);
        }

        System.out.println("Buffer after loading: position = "+buf.position() + 
        "\tLimit = " + buf.limit() + "\tcapacity = " + buf.capacity());

        buf.flip();
        System.out.println("Buffer after flip: position = "+buf.position() + 
        "\tLimit = " + buf.limit() + "\tcapacity = " + buf.capacity());

        try{
            outputChannel.write(buf);
            output.close();
            System.out.print("Buffer contents written to file.");
        }
        catch(IOException exc){
            exc.printStackTrace(System.err);
        }
        System.exit(0);
    }
}
