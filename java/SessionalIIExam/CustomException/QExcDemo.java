package custom.exception;

public class QExcDemo {
    public static void main(String[] args){
        FixedQueue q = new FixedQueue(10);
        char ch;
        int index;

        try{
            for(index = 0;index < 11;index++){
                System.out.print("Attempting to store: "+(char)('A'+index));
                q.put((char)('A'+index));
                System.out.println(" - OK");
            }
            System.out.println();
        }
        catch(QueueFullException exc){
            System.out.println(exc);
        }
        System.out.println();

        try{
            for(index = 0;index < 11; index++){
                System.out.print("Getting next char: ");
                ch = q.get();
                System.out.println(ch);
            }
        }
        catch(QueueEmptyException exc){
            System.out.println(exc);
        }
    }
}
