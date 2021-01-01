package RecursiveDecentParser;

import java.util.Scanner;

import RecursiveDecentParser.Recursive;

public class RecursiveDecent
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression:");
        String expression = sc.next();

        TreeNode treeroot = new TreeNode();
        Recursive r = new Recursive();
        treeroot = r.Proc_E(expression);

        if(treeroot == null || r.next_ptr != expression.length()){
            System.out.println("Error : Invalid Expression!");
        }else{
            treeroot.PostOrder();
            System.out.println();
        }
    }
}