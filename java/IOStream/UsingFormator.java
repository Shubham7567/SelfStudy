import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.text.Normalizer.Form;
import java.util.Formatter;

class UsingFormator {
    public static void main(String[] args){
        String[] phrases = {
            "Rome wasn't burned in a day.",
            "It's a bold mouse that sits in the cat's ear.",
            "An ounce of practice is worth a pound of instruction."
        };
        String dirName = "./phrasetxt";
        String fileName = "Phrase.txt";
        File dir = new File(dirName);
        if(!dir.exists()){
            if(!dir.mkdir()){
                System.out.println("Can not create directory: "+dirName);
                System.exit(1);
            }
        }else if(!dir.isDirectory()){
            System.err.println(dirName + " is not a directory.");
            System.exit(1);
        }

        File aFile = new File(dirName,fileName);
        FileOutputStream output = null;
        try{
            output = new FileOutputStream(aFile,true);
            System.out.println("File stream is created successfully");
        }catch(FileNotFoundException e){
            e.printStackTrace(System.err);
            System.exit(1);
        }
        FileChannel outputChannel = output.getChannel();
        ByteBuffer buf  = ByteBuffer.allocate(1024);
        System.out.println("\nByte buffer");
        System.out.printf("position = %2d Limit = %4d Capacity = %4d%n",buf.position(),buf.limit(),buf.capacity());
        
        CharBuffer charBuf  = buf.asCharBuffer();
        System.out.println("Char view buffer");
        System.out.printf("position = %2d Limit = %4d Capacity = %4d%n",charBuf.position(),charBuf.limit(),charBuf.capacity());
        Formatter formatter = new Formatter(charBuf);

        int number=0;
        for(String phrase : phrases){
            formatter.format("%nProverb%3d : %s", ++number,phrase);
            System.out.println("View buffer after loading");
            System.out.printf("%nposition = %2d Limit = %4d Length = %4d%n", charBuf.position(),charBuf.limit(),charBuf.capacity());
            charBuf.flip();
            System.out.println("\nView buffer after flip:");
            System.out.printf("position = %2d Limit = %4d length = %4d%n",charBuf.position(),charBuf.limit(),charBuf.capacity());
            buf.limit(2*charBuf.length());
            System.out.println("Byte buffer after limit update:");
            System.out.printf("position = %2d Limit = %4d length = %4d%n",buf.position(),buf.limit(),buf.capacity());
            try{
                outputChannel.write(buf);
                System.out.println("Buffer contents written to file.");
                buf.clear();
                charBuf.clear();
            }
            catch(IOException e){
                e.printStackTrace(System.err);
            }
        }
    }
}
