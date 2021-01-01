package iostream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class AvoidOverWriting {
    public static void main(String[] args){
        String filePath = "D:/JAVA_Practice/SessionalIIExam/IOStream/ShowFile.java";
        File aFile = new File(filePath);
        FileOutputStream outputFile = null;

        if(aFile.isFile()){
            File newFile = aFile;
            do{
                String name = aFile.getName();
                int period = name.indexOf('.');
                newFile = new File(newFile.getParent(),name.substring(0, period) + "_old" + name.substring(period));

            }while(newFile.exists());
            aFile.renameTo(newFile);
        }

        try{
            outputFile = new FileOutputStream(aFile);
            System.out.println("ShowFile.java output stream created");
        }catch(FileNotFoundException exc){
            exc.printStackTrace(System.err);
        }
        System.exit(0);
    }
}