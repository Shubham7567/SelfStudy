package exception;

public class FinallyDemo {
    public static void main(String[] args){
        UseFinally uf = new UseFinally();
        for(int i=0;i<3;i++){
            uf.getException(i);
            System.out.println();
        }
    }
}