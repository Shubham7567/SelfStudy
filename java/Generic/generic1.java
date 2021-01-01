import java.util.Scanner;

class Test<T,U>{
    T o1;
	U o2;
	Test(T o1,U o2){
	   this.o1 = o1;
	   this.o2 = o2;
	   }
	 
	 public void print(){
		 System.out.print(o1);
		 System.out.println(o2);
	 }
}

@SuppressWarnings("unchecked")
public class generic1{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Test<Integer,String> student = new Test(Integer.parseInt(args[0]),args[1]);
		Test rawbox = student;
		
		student.print();
	}
}