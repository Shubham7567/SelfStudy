import java.util.LinkedList;
import java.util.Scanner;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.*;


abstract class Employee implements Comparable<Employee> {
    private long employee_id;
    private String name;
    private String dob;
    private long salary;
    private static int count;

    Employee(){
        employee_id = ++count;
        name = "Sample";
        dob = "1/1/0001";
        salary = 0;
    }

    public void SetName(String name){
        this.name = name;
    }

    public void SetDob(String dob){
        this.dob = dob;
    }

    public void SetSalary(long salary){
        this.salary = salary;
    }

    public String toString() {
        return employee_id + " - " + name + " - " + dob + " - " + salary;
    }

    public void display(){
        System.out.println(this);
    }

    public long GetSalary(){
        return salary;
    }

    public String GetName(){
        return name;
    }

    public long GetEmployeeID(){
        return employee_id;
    }

    @Override
    public int compareTo(Employee emp){
        return ((Long)(this.GetEmployeeID())).compareTo(emp.GetEmployeeID());
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(obj.getClass() != this.getClass())
            return false;
        return this.GetEmployeeID() == ((Employee)obj).GetEmployeeID();
    }
}

class UserEmployee extends Employee{
    UserEmployee(){
        super();
    }
}

class TestEmployee {

    public static UserEmployee SetEmployee(){
        Scanner sc = new Scanner(System.in);
        UserEmployee employee = new UserEmployee();
        System.out.println("Enter name:");
        employee.SetName(sc.next());
        System.out.println("Enter salary:");
        employee.SetSalary(sc.nextLong());
        System.out.println("Enter DOB:");
        employee.SetDob(sc.next());
        return employee;
    }
    public static void main(String[] args){
        LinkedList<UserEmployee> employee_list = new LinkedList<>();
        employee_list.add(SetEmployee());
        employee_list.add(SetEmployee());
        employee_list.add(SetEmployee());
        employee_list.add(SetEmployee());
        employee_list.add(SetEmployee());
        employee_list.add(SetEmployee());

        Comparator<UserEmployee> nameComparator = Comparator.comparing(UserEmployee::GetName);
        Collections.sort(employee_list,nameComparator);
        employee_list.forEach(UserEmployee::display);

        System.out.println("\nAfter sort by salary");
        Comparator<UserEmployee> salaryComparator = Comparator.comparing(UserEmployee::GetSalary);
        Collections.sort(employee_list,salaryComparator);
        employee_list.forEach(UserEmployee::display);
    }
}
