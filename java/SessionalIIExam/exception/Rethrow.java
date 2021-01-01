class RethrowDemo{
    public static void genException(){
        int number[] = {4,8,16,32,64,128,256,512};
        int denom[] = {2,0,4,4,0,8};

        for(int index=0;index<number.length;index++){
            try{
                System.out.println(number[index] + " / " + denom[index] + " is " + number[index]/denom[index]);
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
class Rethrow {
    public static void main(String[] args){
        try{
            RethrowDemo.genException();
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("Fatal error - " + "program terminated");
        }
    }
}
