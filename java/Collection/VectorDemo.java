import java.util.Vector;

class VectorDemo {
    public static void main(String[] args){
        Vector<Integer> vector = new Vector<>();
        for(int index = 1;index <= 5;index++){
            vector.add(index);
        }

        System.out.println(vector);
        vector.remove(2);
        System.out.println(vector);
        for(int index=0;index<vector.size();index++){
            System.out.print(vector.get(index) + " ");
        }
        System.out.println();
    }
}
