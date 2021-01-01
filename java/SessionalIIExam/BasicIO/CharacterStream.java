package fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {
    public static void main(String[] args) throws IOException{
        FileReader input = null;
        FileWriter output = null;

        try{
            input = new FileReader("file.txt");
            output = new FileWriter("output2.txt");
            int c;

            while((c = input.read()) != -1){
                output.write(c);
            }
        }
        finally{
            if(input != null){
                input.close();
            }
            if(output != null){
                output.close();
            }
        }
    }
}
