package exception;

public class ExcDemo {
    public static void main(String[] args){
        int nums[] = new int[4];

        try{
            System.out.println("Before exception is generated.");
            nums[7] = 10;
            System.out.println("this won't be displayed");
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("Index out of bound.");
        }
        finally{
            System.out.println("After cach statement.");
        }
        
    }
}
