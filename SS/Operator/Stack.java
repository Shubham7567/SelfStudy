package OperatorPrecedance;

public class Stack {
    String operator;
    Node operand;
    static int top = -1;
    void push(String value,Node n){
        operand = n;
        operator = value;
    }
}
