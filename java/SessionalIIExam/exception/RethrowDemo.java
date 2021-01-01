package exception;

public class RethrowDemo{
    public static void genException(){
        int number[] = {4,8,16,32,64,128,256,512};
        int denom[] = {2,0,4,4,0,8};

        for(int i=0;i<number.length;i++){
            try{

            }
            catch(ArithmeticException exc){
                System.out.println("can't devide by zero");
            }
            catch(ArrayIndexOutOfBoundsException exc){
                System.out.println("No matching element found");
                throw exc;
            }
        }
    }

}