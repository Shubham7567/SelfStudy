import java.util.*;
import java.io.*;

class Node{
    String value;
    Node left,right;
    Node(String value){
        this.value=value;
        left=null;
        right=null;
    }
    Node(String value,Node left,Node right){
        this.value=value;
        this.left=left;
        this.right=right;
    }
    void PostOrder(){
        if(left!=null){
            left.PostOrder();
        }
        if(right!=null){
            right.PostOrder();
        }
        System.out.print(value);
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
    static String rule_table[][];
    static Node root_node;
    static int index;
    public static void main(String args[]) throws Exception{
        getRules();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Expression[|Expression|] : ");
        String expr=sc.nextLine();
        expr="|"+expr+"|";
        index=0;
        int row=0,col=0;
        String operator,operand;
        Node node;
        operator=expr.charAt(index++)+"";
        operand=expr.charAt(index)+"";
        node=new Node(operand);
        Stack stack[]=new Stack[20];
        stack[++Stack.tos]=new Stack();
        stack[Stack.tos].push(operator,node);    //operator= |, node=a
        String str=null;
        while(expr.charAt(index)!='|'){
            index++;  //4 6 6
            row=GetRow(stack[Stack.tos].operator+""); //5  ->1
            col=GelCol(expr.charAt(index)+"");
            if((expr.charAt(index) == '*' || expr.charAt(index) == '+' || expr.charAt(index) == '-') &&
             (expr.charAt(index+1) == '*' || expr.charAt(index+1) == '+' || expr.charAt(index+1) == '-')){
                System.out.println("Error : Invalid Expression");
                return;
             }    //+     ->2
            if(row!=-1 && col!=-1){
                str=rule_table[row][col];    //< <   >
            }
            else{
                System.out.println("Error");
            }
            if(str.equals("<")){
                operator=expr.charAt(index++)+""; //+ now index=3 * 5
                operand=expr.charAt(index)+"";    //b c
                node=new Node(operand);
                stack[++Stack.tos]=new Stack();
                stack[Stack.tos].push(operator,node);
            }
            else if(str.equals(">")){
                Pop(stack);
                index--;
            }
        }
        root_node=stack[Stack.tos].operand;
        System.out.println("Expression : ");
        root_node.PostOrder();
        System.out.println();
    }
    static void Pop(Stack[] stack){
        Node n1=stack[Stack.tos].operand;   //c
        String op1=stack[Stack.tos--].operator; //*
        Node n2=stack[Stack.tos].operand;   //b
        String op2=stack[Stack.tos--].operator; //+
        Node node=new Node(op1,n2,n1);
        stack[++Stack.tos].push(op2,node);
    }
    static int GetRow(String str){
        for(int index=0;index<rule_table.length;index++){
            if(rule_table[index][0].equals(str)){
                return index;
            }
        }
        return -1;
    }
    static int GelCol(String str){
        for(int index=0;index<rule_table[0].length;index++){
            if(rule_table[0][index].equals(str)){
                return index;
            }
        }
        return -1;
    }
    static void getRules() throws Exception{
        rule_table=new String[5][5];
        BufferedReader br=new BufferedReader(new FileReader("OPRules.txt"));
        int i=0;
        String line;
        String token[];
        while((line=br.readLine())!=null){
            token=line.split("\t");
            for(int j=0;j<token.length;j++){
                rule_table[i][j]=token[j];
            }
            i++;
        }
        System.out.println("rule_table : ");
        for(i=0;i<rule_table.length;i++){
            for(int j=0;j<rule_table[i].length;j++){
                System.out.print(rule_table[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}