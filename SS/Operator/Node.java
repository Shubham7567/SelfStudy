package OperatorPrecedance;

public class Node {
    String value;
    Node left_ptr,right_ptr;
    Node(){
        value = "";
        left_ptr = null;
        right_ptr = null;
    }
    Node(String value){
        this.value = value;
        left_ptr = null;
        right_ptr = null;
    }
    Node(String value,Node left_ptr,Node right_ptr){
        this.value = value;
        this.left_ptr = left_ptr;
        this.right_ptr = right_ptr;
    }

    void PostOrder(){
        if(left_ptr != null){
            left_ptr.PostOrder();
        }
        if(right_ptr != null){
            right_ptr.PostOrder();
        }
        System.out.print(value);
    }
}
