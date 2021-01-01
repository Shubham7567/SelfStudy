package iostream.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args){
        int i;
        FileInputStream fin;

        if(args.length != 1){
            System.out.println("Usage: ShowFile File");
            return;
        }
        
        try{
            fin = new FileInputStream(args[0]);
        }catch(FileNotFoundException exc){
            System.out.println("File not found");
            return;
        }

        try{
            do{
                i = fin.read();
                if(i != -1) System.out.println((char)i);
            }while(i != -1);
        }catch(IOException exc) {
            System.out.println("Error reading file.");
        }

        try{
            fin.close();
        }
        catch(IOException exc){
            System.out.println("Error closing file.");
        }
    }
}
