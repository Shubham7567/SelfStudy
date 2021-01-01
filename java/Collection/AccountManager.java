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
