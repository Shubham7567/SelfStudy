import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

class FileCopyNew {
    public static void main(String[] args){
        if(args.length < 2){
            System.out.println("Please provide two files.");
            System.exit(0);
        }
        File fromFile = new File(args[0]);
        File toFile = new File(args[1]);

        FileInputStream inFile = null;
        FileOutputStream outFile = null;
        try{
            inFile = new FileInputStream(fromFile);
            outFile = new FileOutputStream(toFile);
        }catch(FileNotFoundException exc){
            exc.printStackTrace(System.err);
            System.exit(0);
        }
        FileChannel inChannel = inFile.getChannel();
        FileChannel outChannel = outFile.getChannel();
        try{
            int bytesWritten = 0;
            long byteCount = inChannel.size();
            while(bytesWritten < byteCount){
                bytesWritten += inChannel.transferTo(bytesWritten, byteCount-bytesWritten, outChannel);
            }
            System.out.printf("%d bytes copied from %s to %s",byteCount,fromFile.getName(),toFile.getName());
            inFile.close();
            outFile.close();
        }catch(IOException exc){
            exc.printStackTrace(System.err);
            System.exit(1);
        }
        System.exit(0);
    }
}
