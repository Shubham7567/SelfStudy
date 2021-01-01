package exception;

public class CustomException {
    public static void main(String[] args){
        int number[] = {4,8,15,32,64,127,256,512};
        int denom[] = {2,0,4,4,0,8};

        for(int i=0;i<number.length;i++){
            try{
                if(number[i]%2 != 0){
                    throw new NonIntException(number[i], denom[i]);
                }
                System.out.println(number[i] + " / " + denom[i] + " is " + number[i]/denom[i]);
            }
            catch(ArithmeticException exc)
            {
                System.out.println("Can't devide by zero!");
            }
            catch(ArrayIndexOutOfBoundsException exc){
                System.out.println("No matching element found!");
            }
            catch(NonIntException exc){
                System.out.println(exc);
            }
        }
    }
}
