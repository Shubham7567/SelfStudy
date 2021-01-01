// package OperatorPrecedance;

// import java.util.*;
// import java.io.*;

// public class Operator {
//     static String table[][];
//     static Node root;
//     static int index;
//     public static void main(String[] args) throws IOException{
//         GetRules();
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter expression:");
//         String expression = sc.next();
//         expression = "|" + expression + "|";
//         index=0;
//         int row=0,col=0;
//         String operator,operand;
//         Node node;
//         operator=expression.charAt(index++)+"";
//         operand=expression.charAt(index)+"";
//         node = new Node(operand);
//         Stack stack[] = new Stack[20];
//         stack[++Stack.top] = new Stack();
//         stack[Stack.top].push(operator,node);
//         String precendance="";
//         while(expression.charAt(index) != '|'){
//             System.out.println(Stack.top);
//             index++;
//             row = GetRow(stack[Stack.top].operator);
//             col = GetCol(expression.charAt(index)+"");
//             if(row != -1 && col != -1){
//                 precendance = table[row][col];
//             }else{
//                 System.out.println("Error : Invalid expression");
//                 return;
//             }
//             if(precendance.equals("<")){
//                 operator = expression.charAt(index++)+"";
//                 operand = expression.charAt(index)+"";
//                 node = new Node(operand);
//                 stack[++Stack.top] = new Stack();
//                 stack[Stack.top].push(operator,node);   
//                 System.out.println(stack[Stack.top].operator);
//             }
//             else{
//                 System.out.println(stack[Stack.top].operator);
//                 pop(stack);
//                 index--;
//             }
//         }
//         root = stack[Stack.top].operand;
//         System.out.print("Expression : ");
//         root.PostOrder();
//         System.out.println();
//     }

//     static void pop(Stack[] stack){
//         Node n1=stack[Stack.top].operand;   //c
//         String op1=stack[Stack.top--].operator; //*
//         Node n2=stack[Stack.top].operand;   //b
//         String op2=stack[Stack.top--].operator; //+
//         Node node=new Node(op1,n2,n1);
//         stack[++Stack.top].push(op2,node);
//     }

//     static int GetRow(String str){
//         for(int index=0;index < table.length;index++){
//             if(str.equals(table[index][0])){
//                 return index;
//             }
//         }
//         return -1;
//     }

//     static int GetCol(String str){
//         for(int index=0;index < table[0].length;index++){
//             if(str.equals(table[0][index])){
//                 return index;
//             }
//         }
//         return -1;
//     }

//     static void GetRules() throws IOException{
//         table = new String[8][8];
//         BufferedReader br = new BufferedReader(new FileReader("OPRules.txt"));
//         int index=0;
//         String line = "";
//         String token[];
//         while((line = br.readLine()) != null){
//             token = line.split("[\t]");
//             for(int j_index =0;j_index < token.length;j_index++){
//                 table[index][j_index] = token[j_index];
//             }
//             index++;
//         }
//     }
// }
import java.util.*;
import java.io.*;
class Node{
    String data;
    Node left,right;
    Node(String data){
        this.data=data;
        left=null;
        right=null;
    }
    Node(String data,Node left,Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
    void postorder(){
        if(left!=null){
            left.postorder();
        }
        if(right!=null){
            right.postorder();
        }
        System.out.print(data);
    }
}
class Stack{
    String operator;
    Node operand;
    static int tos=-1;
    public void push(String operator,Node operand){
        this.operator=operator;
        this.operand=operand;
    }
}
public class Operator{
    static String table[][];
    static Node root;
    static int ssm;
    public static void main(String args[]) throws Exception{
        getRules();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Expression[|Expression|] : ");
        String expr=sc.nextLine();
        expr="|"+expr+"|";
        ssm=0;
        int row=0,col=0;
        String operator,operand;
        Node node;
        operator=expr.charAt(ssm++)+"";
        operand=expr.charAt(ssm)+"";
        node=new Node(operand);
        Stack stack[]=new Stack[20];
        stack[++Stack.tos]=new Stack();
        stack[Stack.tos].push(operator,node);    //operator= |, node=a
        String str=null;
        while(expr.charAt(ssm)!='|'){
            ssm++;  //4 6 6
            row=getRow(stack[Stack.tos].operator+""); //5  ->1
            col=getCol(expr.charAt(ssm)+"");    //+     ->2
            if(row!=-1 && col!=-1){
                str=table[row][col];    //< <   >
            }
            else{
                System.out.println("Error");
            }
            if(str.equals("<")){
                operator=expr.charAt(ssm++)+""; //+ now ssm=3 * 5
                operand=expr.charAt(ssm)+"";    //b c
                node=new Node(operand);
                stack[++Stack.tos]=new Stack();
                stack[Stack.tos].push(operator,node);
            }
            else if(str.equals(">")){
                pop(stack);
                ssm--;
            }
        }
        root=stack[Stack.tos].operand;
        System.out.println("Expression : ");
        root.postorder();
        System.out.println();
    }
    static void pop(Stack[] stack){
        Node n1=stack[Stack.tos].operand;   //c
        String op1=stack[Stack.tos--].operator; //*
        Node n2=stack[Stack.tos].operand;   //b
        String op2=stack[Stack.tos--].operator; //+
        Node node=new Node(op1,n2,n1);
        stack[++Stack.tos].push(op2,node);
    }
    static int getRow(String str){
        for(int i=0;i<table.length;i++){
            if(table[i][0].equals(str)){
                //System.out.println(i);
                return i;
            }
        }
        return -1;
    }
    static int getCol(String str){
        for(int i=0;i<table[0].length;i++){
            if(table[0][i].equals(str)){
                return i;
            }
        }
        return -1;
    }
    static void getRules() throws Exception{
        table=new String[8][8];
        BufferedReader br=new BufferedReader(new FileReader("OPRules.txt"));
        int i=0;
        String line;
        String token[];
        while((line=br.readLine())!=null){
            token=line.split("\t");
            for(int j=0;j<token.length;j++){
                table[i][j]=token[j];
            }
            i++;
        }
        System.out.println("Table : ");
        for(i=0;i<table.length;i++){
            for(int j=0;j<table[i].length;j++){
                System.out.print(table[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}