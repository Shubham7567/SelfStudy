package Bank;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

public abstract class Account implements Comparable<Account> {
    private long accountNo;
    public String name;
    private long balance;

    public List<Transaction> passbook = new ArrayList<Transaction>();

    public Stream<Transaction> getTransactionStream() {
        return this.passbook.stream();
    }

    public class Transaction {
        private long date = System.currentTimeMillis();
        private String naration;
        private TransType transType;
        private long amount;
        private long runningBalance;
        
        public Transaction(String n, TransType transType,long amt) throws NegativeAmountException{
            if(amt < 0){
                throw new NegativeAmountException("Negative"+transType.toString().toLowerCase(),amt,Account.this);
            }
            this.naration = n;
            this.transType = transType;
            this.amount = amt;
            Account.this.balance += getNetAmount();
        }

        public long getDate() {
            return this.date;
        }

        public String getNaration() {
            return this.naration;
        }

        public String toString() {
            return "Transaction:"+String.format("%tF, %15s, %10s, %12d", this.date, this.naration, this.transType.toString(), this.amount);
        }

        public void displayRecord(){
            System.out.println(this);
        }

        public long getAmount() {
            return this.amount;
        }

        public long getNetAmount() {
            return this.transType.getSign()*this.getAmount();
        }

        public void setRunningBalance()
        {
            this.runningBalance = Account.this.balance;
        }

        public long getRunningBalance()
        {
            return this.runningBalance;
        }
    }

    public enum TransType {
        CREDIT(1),
        DEBIT(-1),
        ;
        private int sign;
        TransType(int sign) { 
            this.sign = sign; 
        }
        public int getSign() {
            return this.sign;
        }
    }

    public void printPassbook(){
        long runningBalance = 0;
        System.out.println("Passbook of " + name + " Account #"+accountNo);
        for(Transaction tr : passbook){
            runningBalance += tr.getNetAmount();
            System.out.println(tr + "," + runningBalance);
        }
        System.out.println("End of Passbook");
    }

    public List<Transaction> getPassbook(){
        return passbook;
    }

    public long getAccountNo(){
        return this.accountNo;
    }

    public String getName(){
        return this.name;
    }

    public long getBalance(){
        return this.balance;
    }

    public void deposit(long amt) throws NegativeAmountException {
        new Transaction("Deposit", TransType.CREDIT, amt);
    }

    public boolean withdraw(long amt) throws NegativeAmountException{
        if(this.balance < amt){
            return false;
        }
        new Transaction("Withdrawal", TransType.DEBIT, amt);
        return true;
    }

    public void display(){
        System.out.println(this);
    }

    private static long lastAccountNumber = 1000;

    public Account(long acno,String name,long openBal) throws NegativeAmountException{
        this.accountNo = acno;
        this.name = name;
        new Transaction("Opening Balance", TransType.CREDIT, openBal);
    }

    public Account(String name,long openBal) throws NegativeAmountException{
        this(++lastAccountNumber,name,openBal);
    }

    @Override
    public String toString(){
        return this.getClass().getName() + ":" + this.getAccountNo() + "," + this.getName() + "," + this.getBalance();
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
        return this.getAccountNo() == ((Account)obj).getAccountNo();
    }

    @Override
    public int hashCode(){
        return (int)this.getAccountNo();
    }

    @Override
    public int compareTo(Account ac){
        return ((Long)(this.getAccountNo())).compareTo(ac.getAccountNo());
    }

    public void DisplayBook(){
        passbook.forEach(Transaction::displayRecord);
    }
}
