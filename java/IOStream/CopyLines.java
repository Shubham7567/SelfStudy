import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.IOException;

class CopyLines {
    public static void main(String[] args) throws IOException{
        BufferedReader breader = null;
        PrintWriter pwriter = null;
        try{
            breader = new BufferedReader(new FileReader("ByteStream.java"));
            pwriter = new PrintWriter(new FileWriter("output2.txt"));
            String line = "";
            while((line = breader.readLine())!= null)
            {
                pwriter.println(line);
            }
        }finally{
            if(breader != null){
                breader.close();
            }
            if(pwriter != null){
                pwriter.close();
            }
        }
    }
}
