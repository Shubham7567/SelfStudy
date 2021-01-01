import java.util.Scanner;

//@SuppressWarnings("unchecked")
class Student<T,U>{
    private T id;
    private U name;

    Student(T id, U name){
        this.id = id;
        this.name = name;
    }

    public void SetStudent(T id, U name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name;
    }
}

class GenDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student<Integer,String> student = new Student(Integer.parseInt(args[0]),args[1]);
        // int id;
        // String name;
        // System.out.print("Enter student id:");
        // id = sc.nextInt();
        // System.out.println("Enter name:");
        // name = sc.next();
        // student.SetStudent(id, name);
        System.out.println(student);
    }
}
