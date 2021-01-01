package exception;

public class UseFinally {
    public void getException(int what){
        int t;
        int nums[] = new int[2];
        System.out.println("Recieving "+what);
        try{
            switch(what){
                case 0: t=10/what;
                    break;
                case 1:
                    nums[4] = 4;
                    break;
                case 2:
                    return;
            }
        }
        catch(ArithmeticException exc){
            System.out.println("Can't devide by Zero!");
            return;
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("No matching element found.");
            //throw new ArithmeticException();
        }
        finally{
            System.out.println("Leaving try.");
        }
    }
}
