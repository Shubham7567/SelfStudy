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
package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<Account>();
        String choice = "";
        System.out.println("=> To create new account type new\n=>To see all the accounts type list.");
        while(!choice.equals("quit")){
            System.out.println("Enter your choice:");
            choice = sc.next();
            if(choice.equals("new")){
                Account account = CreateAccount();
                accounts.add(account);
            }else if(choice.equals("list")){
                GetList(accounts);
            }else if(!choice.equals("quit")){
                System.out.println("Message : Your choice is wrong");
            }
        }
    }
    public static Account CreateAccount(){
        Account account = new Account();
        account.SetName();
        account.SetBalance();
        return account;
    }
    public static void GetList(ArrayList<Account> list){
        list.forEach(Account::display);
        // for (Account account : list) {
        //     System.out.println(account);
        // }
    }
}
