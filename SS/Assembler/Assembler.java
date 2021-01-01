import java.util.*;
import java.io.*;

public class Assembler {
    static String[][] symbolTable=new String[20][2] ;//this is symbol table
    static String[][] litTable=new String[20][2] ;//this is literal table
    static int[] poolTable= new int[20];//this is literal table
    static int locationCounter =0;
    static int poolTabPtr = 0;//pooltable pointer
    static int litTabPtr = 0;//literaltable pointer
    static int symbolTabPtr=0;
    public static void main(String[] args){
        try{
            poolTable[0]=1;
            BufferedReader reader = new BufferedReader(new FileReader("semple_assembly.txt"));
            String line="";
            int addr=0;
            while((line=reader.readLine())!=null){
                String[] tokens = line.split("[\t|,]");
                for(int index=0;index<tokens.length;index++){
                    String code = mnemonic(tokens[index], "code");
                    String result = mnemonic(tokens[index], "type");
                    if(result == "" && !IsLiteral(tokens[index])){
                        addr = GetSymbolIndex(tokens[index]);
                        if(addr != -1){
                            symbolTable[symbolTabPtr][0] = tokens[index];
                            symbolTable[symbolTabPtr][1] = String.valueOf(locationCounter);
                            symbolTabPtr++;
                        }else{
                            symbolTable[addr][1] = String.valueOf(locationCounter);
                        }
                    }else if((tokens[index].equals("LTORG") || (tokens[index].equals("END")) && index < tokens.length)){
                        for(addr=poolTable[poolTabPtr]-1;addr<litTabPtr;addr++){
                            litTable[litTabPtr]
                        }
                    }
                }
            }

            System.out.println("\n\n==============================================");
            System.out.println("Literal Table");
            System.out.println("==============================================");
            for(int index=0;index<litTabPtr;index++){
                System.out.println(litTable[index][0] + ":" + litTable[index][1]);
            }
            System.out.println("==============================================");
            System.out.println("System Table");
            System.out.println("==============================================");
            for(int index=0;index<symbolTabPtr;index++){
                System.out.println(symbolTable[index][0] + " - " + symbolTable[index][1]);
            }
            System.out.println("==============================================");
            System.out.println("Pool Table");
            System.out.println("==============================================");
            for(int index=0;index<symbolTabPtr;index++){
                System.out.println(poolTable[index]);
            }
            System.out.println();
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
    }
    public static String mnemonic(String token,String type){
        String[][] codes = {{"00","STOP","IS"},{"01","ADD","IS"},{"02","SUB","IS"},{"03","MULT","IS"},{"04","MOVER","IS"},{"05","MOVEM","IS"}
                            ,{"06","COMP","IS"},{"07","BC","IS"},{"08","DIV","IS"},{"09","READ","IS"},{"10","PRINT","IS"},{"01","DC","DL"},
                            {"02","DS","DL"},{"01","START","AD"},{"02","END","AD"},{"03","ORIGIN","AD"},{"04","EQU","AD"},{"05","LTORG","AD"},
                            {"01","AREG","REG"},{"02","BREG","REG"},{"03","CREG","REG"},{"04","DREG","REG"},{"1","LT","FLAG"},{"2","LE","FLAG"},
                            {"3","EQ","FLAG"},{"4","GT","FLAG"},{"5","GE","FLAG"},{"6","ANY","FLAG"}};
        
        for(String[] code :codes){
            if(token.equals(code[1])){
                if(type.equals("type"))
                    return code[2];
                if(type.equals("code"))
                    return code[0];
            }
        }
        return "";
    }

    public static boolean IsLiteral(String token){
        if(token.startsWith("=") || token.startsWith("\'")){
            return true;
        }
        return false;
    }

    public static int  GetSymbolIndex(String token){
        for(int index=0;index<symbolTabPtr;index++){
            if(token.equals(symbolTable[index][0])){
                return index;
            }
        }
        return -1;
    }
}
