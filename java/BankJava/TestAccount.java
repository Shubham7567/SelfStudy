package Bank;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.*;


public class TestAccount {

    private static void display(Account[] accounts) {
        for (Account ac : accounts) {
            ac.display();
        }
    }
    public static void main(String[] args) throws NegativeAmountException {
        CurrentAccount ca = new CurrentAccount("Shubham",1_00_000);
        System.out.println("Before any transaction:");
        ca.display();
        ca.DisplayBook();
        ca.withdraw(20_000);
        ca.deposit(23_000);
        ca.withdraw(94_000);
        ca.setPenalty(Penalty.percent(0.10));
        ca.printPassbook();

        Account[] accounts = new Account[5];
        try {
            accounts[0] = new SavingsAccount(12321, "John", 1_00_000);
            accounts[1] = new CurrentAccount(23123, "jane", 1_00_000);
            accounts[2] = new CurrentAccount(12312, "John", 50_000);
            accounts[3] = new SavingsAccount(33411, "Joseph", 1_50_000);
            accounts[4] = new CurrentAccount(23344, "Janet", 75_000);
            System.out.println("before sorting");
            display(accounts);
        } catch (NegativeAmountException nae) {
            nae.printStackTrace();
        }

        Comparator<Account> nameComparator = Comparator.comparing(Account::getName);
        Arrays.sort(accounts,nameComparator);
        System.out.println("after sorting by name");
        display(accounts);

        Comparator<Account> balanceComparator = Comparator.comparing(Account::getBalance);
        Arrays.sort(accounts,balanceComparator);
        System.out.println("after sorting by balance");
        display(accounts);
    }
}
