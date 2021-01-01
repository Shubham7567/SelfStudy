import java.util.HashMap;
import java.util.Scanner;

class Employee{
    private int id;
    private String name;
    private long salary;

    public void setID(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(long salary){
        this.salary = salary;
    }

    public int getID(){
        return id;
    }

    @Override
    public String toString() {
        return String.format("| %-3d | %20s | %6d |", id,name,salary);
    }
}

class HashMapDemo {
    public static Employee InsertData(){
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Enter ID:");
        employee.setID(sc.nextInt());
        System.out.println("Enter Name:");
        employee.setName(sc.next());
        System.out.println("Enter Salary:");
        employee.setSalary(sc.nextLong());
        return employee;
    }
    public static void main(String[] args) {
        HashMap<Integer,Employee> employeeMap = new HashMap<>();
        Employee employee = new Employee();
        employee = InsertData();
        employeeMap.put(employee.getID(), employee);

        employee = InsertData();
        employeeMap.put(employee.getID(), employee);

        employee = InsertData();
        employeeMap.put(employee.getID(), employee);

        employee = InsertData();
        employeeMap.put(employee.getID(), employee);
        for(Integer key : employeeMap.keySet()){
            System.out.println(employeeMap.get(key));
        }
    }
}
