package exception;

public class ThrowDemo {
    public static void main(String[] args){
        try{
            System.out.println("Before throw.");
            throw new ArithmeticException();
        }
        catch(ArithmeticException exc){
            System.out.println("Exception caught");
        }
        // finally{
        //     System.out.println("After try catch");
        // }
        System.out.println("After try catch");
    }
}
/*
Before throw.
Exception caught
Exception in thread "main" java.lang.ArithmeticException
        at exception.ThrowDemo.main(ThrowDemo.java:12)
    if we put throw in catch
*/