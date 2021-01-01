package fileio;

import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.IOException;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        BufferedReader input = null;
        PrintWriter output = null;
        try{
            input = new BufferedReader(new FileReader("file.txt"));
            output = new PrintWriter(new FileWriter("output3.txt"));
            String line;
            while((line = input.readLine()) != null){
                output.print(line);
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