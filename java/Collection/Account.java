package Collection;

import java.util.Scanner;

public class Account implements Comparable<Account> {
    public static Scanner sc = new Scanner(System.in);
    private long account_no;
    private String name;
    private long balance;
    private static final long min_balance = 500;
    private static long last_account_no;

    Account(){
        SetAccountNo();
    }

    public void SetAccountNo(){
        account_no = ++last_account_no;
    }

    public long GetAccountNumber(){
        return this.account_no;
    }

    public void SetName(){
        System.out.print("Enter name:");
        name = sc.next();
    }

    public void SetBalance(){
        System.out.println("Enter balance:");
        balance = sc.nextLong();
    }

    public String toString(){
        return account_no + " : " + name + " : " + balance;
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
        return this.GetAccountNumber() == ((Account)obj).GetAccountNumber();
    }

    public void display(){
        System.out.println(this);
    }

    @Override
    public int compareTo(Account ac){
        return ((Long)(this.GetAccountNumber())).compareTo(ac.GetAccountNumber());
    }
}
