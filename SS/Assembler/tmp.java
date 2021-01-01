if(result.equals("IS")){
    String regNo = "";
    String operand = "";
    if(!tokens[index].equals("STOP") && !tokens[index].equals("READ") && !tokens[index].equals("PRINT"))
    {
        regNo = mnemonic(tokens[index+1], "code");
        operand = tokens[index+2];
    }
    int addr=0;
    locationCounter++;
    if(tokens[index].equals("STOP")){
        System.out.println("IC=(IS,00)");
    }else if(tokens[index].equals("READ")){
        operand = tokens[index+1];
        symbolTable[symbolTabPtr][0] = operand;
        symbolTabPtr++;
        System.out.println("IC=(IS,"+ code +")(0)(S,"+ symbolTabPtr +")");
        index++;
    }else if(tokens[index].equals("PRINT")){
        index+=1;
    }else{
        if(!IsLiteral(operand)){
            if(GetSymbolIndex(operand) == -1){
                symbolTable[symbolTabPtr][0] = operand;
                symbolTabPtr++;
                System.out.println("IC=(IS,"+ code +")(" + regNo + ")(S,"+symbolTabPtr+")");
            }else{
                addr = GetSymbolIndex(operand)+1;
                System.out.println("IC=(IS,"+ code +")(" + regNo + ")(S,"+addr+")");
            }
        }else{
            char this_literal = operand.charAt(2);
            litTable[litTabPtr][0] = Character.toString(this_literal);
            litTabPtr++;
            System.out.println("IC=(IS,"+ code +")("+ regNo +")(L,"+litTabPtr+")");
        }
        index+=2;
    }
}
else if(result.equals("AD")){
    if(tokens[index].equals("START")){
        locationCounter = Integer.parseInt(tokens[index+1]);
        System.out.println("LC = "+locationCounter);
        index++;
    }
    else if(tokens[index].equals("EQU")){
        int addr = GetSymbolIndex(tokens[index+1]);
        System.out.println("IC=(AD,"+ code +")\t(S,"+ addr+1 +")");
        String address = symbolTable[addr][1];
        addr = GetSymbolIndex(tokens[index-1]);
        symbolTable[addr][1] = address;
        index++;
    }
    else if(tokens[index].equals("ORIGIN")){
        int addr = GetSymbolIndex(tokens[index+1]);//for finding address of loop
        int address = Integer.parseInt(symbolTable[addr][1]);
        locationCounter = address + Integer.parseInt(tokens[index+2].substring(1));
        index+=2; //to skip label and increment;
        System.out.println("IC=(AD,"+code+") (C,"+locationCounter+")");
    }
    else if(tokens[index].equals("LTORG") || (tokens[index].equals("END") && index < tokens.length))
    {
        //System.out.println("before"+poolTabPtr);
        for(int addr = poolTable[poolTabPtr]-1;addr<litTabPtr;addr++)
        {
            litTable[addr][1] = String.valueOf(locationCounter);
            System.out.println("IC=(AD,"+litTable[addr][0]+")(C,"+locationCounter+")");
            locationCounter++;
        }
        poolTabPtr++;
        poolTable[poolTabPtr] = litTabPtr+1;
    }
}
else if(result.equals("DL")){
    int addr = GetSymbolIndex(tokens[index-1])+1;
    code = mnemonic(tokens[index], "code");
    int size = 0;
    if(tokens[index+1].contains("\'")){
        size = Integer.parseInt(tokens[index+1].charAt(1)+"");
    }
    else{size = Integer.parseInt(tokens[index+1]);}
    if(addr != 0){
        symbolTable[addr-1][1] = String.valueOf(locationCounter);
    }
    System.out.println("IC=(DL,"+ code +")(C,"+ addr +")");
    locationCounter+=size;
    index++;
}
// else if(result.equals("REG")){

// }
// else if(result.equals("FLAG")){

// }
else if(result == "" && !IsLiteral(tokens[index])){
    int addr = GetSymbolIndex(tokens[index]);
    if(index<tokens.length-1 && mnemonic(tokens[index+1], "type").equals("IS")){
        if(addr == -1){
            symbolTable[symbolTabPtr][0] = tokens[index];
            symbolTable[symbolTabPtr][1] = String.valueOf(locationCounter);
            symbolTabPtr++;
        }else{
            symbolTable[addr][1] = String.valueOf(locationCounter);
        }
    }
}
// else if