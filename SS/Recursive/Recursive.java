package RecursiveDecentParser;

public class Recursive {
    static int next_ptr = 0;
    TreeNode Proc_E(String expression){
        TreeNode a=null,b;
        a = Proc_T(expression);
        while(next_ptr<expression.length() && expression.charAt(next_ptr) == '+' && expression.charAt(0) != '+'){
            next_ptr++;
            b = Proc_T(expression);
            if(b == null){
                return null;
            }else{
                a = new TreeNode("+",a,b);
            }
        }
        return a;
    }

    TreeNode Proc_T(String expression){
        TreeNode a=null,b;
        a = Proc_V(expression);
        while(next_ptr < expression.length() && expression.charAt(next_ptr) == '*' && expression.charAt(0) != '*'){
            next_ptr++;
            b = Proc_V(expression);
            if(b == null){
                return null;
            }else{
                a = new TreeNode("*",a,b);
            }
        }
        return a;
    }

    TreeNode Proc_V(String expression){
        TreeNode a = null;
        if(next_ptr < expression.length() && expression.charAt(next_ptr) != '+' && expression.charAt(next_ptr) != '*'){
            a = new TreeNode(expression.charAt(next_ptr++)+"",null,null);
        }
        else{
            System.out.println("Error : Invalid Symbol");
			return null;
        }
        return a;
    }
}
