package exception;

public class ExcDemo2 {
    public static void main(String[] args){
        int number[] = {4,8,16,32,64,128};
        int denom[] = {2,0,4,4,0,8};

        for(int index = 0;index <number.length; index++){
            try{
                System.out.println(number[index] + " / " + denom[index] + " is " + number[index]/denom[index]);
            }
            catch(ArithmeticException exc){
                System.out.println("Can't devide by zero");
            }
        }
    }
}
