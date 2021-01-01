import java.io.FileReader;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Employee{
    private int id;
    private String name;
    private long salary;
    private LocalDate doj;

    public void setID(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(long salary){
        this.salary = salary;
    }

    public void SetDoj(LocalDate doj){
        this.doj = doj;
    }

    @Override
    public String toString() {
        return String.format("| %-3d | %20s | %6d | %s", id,name,salary,doj.toString());
    }
}

class CopyData {

    public static Employee InsertData(){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int day,month,year;
        Employee employee = new Employee();
        System.out.println("Enter ID:");
        employee.setID(sc.nextInt());
        System.out.println("Enter Name:");
        employee.setName(sc.next());
        System.out.println("Enter Salary:");
        employee.setSalary(sc.nextLong());
        System.out.println("Enter Date Of Joining:");
        employee.SetDoj(LocalDate.parse(sc.next(),dateFormat));
        return employee;
    }
    public static void main(String[] args){
        PrintWriter writer = null;
        try{
            ArrayList<Employee> employeeList = new ArrayList<>();
            employeeList.add(InsertData());
            employeeList.add(InsertData());
            employeeList.add(InsertData());
            employeeList.add(InsertData());
            employeeList.add(InsertData());
            writer = new PrintWriter(new FileWriter("output.txt"));
            for(Employee employee : employeeList){
                writer.println(employee);
            }
            if(writer != null){
                writer.close();
            }
        }catch(FileNotFoundException exc){
            exc.printStackTrace(System.err);
        }catch(IOException exc){
            exc.printStackTrace(System.err);
        }
    }
}
