import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class CharacterStream {
    public static void main(String[] args) throws IOException{
        FileReader reader = null;
        FileWriter writer = null;
        try{
            reader = new FileReader("input.txt");
            writer = new FileWriter("output2.txt");
            int c;
            while((c=reader.read()) != -1){
                writer.write(c);
            }
        }finally{
            if(reader != null){
                reader.close();
            }
            if(writer != null){
                writer.close();
            }
        }
    }
}
