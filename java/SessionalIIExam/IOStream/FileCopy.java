package iostream.filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileCopy {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("No file to copy. Apllication usage is:\n" + "java -classpath . FileCopy \"filepath\"");
            System.exit(1);
        }
        File fromFile = new File(args[0]);
        if(!fromFile.exists()){
            System.out.printf("File to copy, %s, does not exist.");
            System.exit(1);
        }

        File toFile = createBackupFile(fromFile);
        FileInputStream inFile = null;
        FileOutputStream outFile = null;
        try{
            inFile = new FileInputStream(fromFile);
            outFile = new FileOutputStream(toFile);
        }catch(FileNotFoundException e){
            e.printStackTrace(System.err);
            assert false;
        }

        FileChannel inChannel = inFile.getChannel();
        FileChannel outChannel = outFile.getChannel();

        try{
            int bytesWritten = 0;
            long byteCount = inChannel.size();
            while(bytesWritten < byteCount){
                bytesWritten += inChannel.transferTo(bytesWritten, byteCount-bytesWritten, outChannel);
            }
            System.out.printf("File copy completed, %d bytes copied to %s%n",byteCount,toFile.getAbsolutePath());
            inFile.close();
            outFile.close();
        }
        catch(IOException e){
            e.printStackTrace(System.err);
            System.exit(1);
        }
        System.exit(0);
    }

    public static File createBackupFile(File aFile){
        aFile = aFile.getAbsoluteFile();
        File parentDir = new File(aFile.getParent());
        String name = aFile.getName();
        int period = name.indexOf('.');
        if(period == -1){
            period = name.length();
        }
        String nameAdd = "_backup";
        File backup = aFile;
        while(backup.exists()){
            name = backup.getName();
            backup = new File(parentDir,name.substring(0, period) + nameAdd + name.substring(period));
            period += nameAdd.length();
        }
        return backup;
    }
}
