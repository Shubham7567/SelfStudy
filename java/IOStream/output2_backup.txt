import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ByteStream {
    public static void main(String[] args){
        FileInputStream input = null;
        FileOutputStream output = null;
        try{
            input = new FileInputStream("input.txt");
            output = new FileOutputStream("output.txt");
            int c;
            while((c=input.read()) != -1){
                output.write(c);
            }
            if(input != null){
                input.close();
            }
            if(output != null){
                output.close();
            }
        }catch(IOException exc){
            exc.printStackTrace(System.err);
        }finally{
            
        }
    }
}
