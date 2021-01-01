package RecursiveDecentParser;

public class TreeNode {
    String symbol;
    TreeNode left_node,right_node;

    TreeNode(){}

    TreeNode(String symbol,TreeNode left_node,TreeNode right_node){
        this.symbol = symbol;
        this.left_node = left_node;
        this.right_node = right_node;
    }

    void PostOrder(){
        if(left_node != null){
            left_node.PostOrder();
        }
        if(right_node != null){
            right_node.PostOrder();
        }
        System.out.print("" + symbol);
    }
}
