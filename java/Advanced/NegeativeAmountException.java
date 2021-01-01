package bank;

public class NegeativeAmountException extends Exception {
    private long amount;
    private Account account;
    NegeativeAmountException(String msg,long amt,Account ac){
        super(msg);
        this.account = ac;
        this.amount = amt;
    }

    public long GetAmount(){
        return this.amount;
    }

    public Account GetAccount(){
        return this.account;
    }

    public String toString(){
        return super.toString() + ":" + amount + ":" + account;
    }
}
