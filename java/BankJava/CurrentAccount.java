package Bank;

public class CurrentAccount extends Account {
    private static final long minimumBalance = 10_000;

    private Penalty penalty = Penalty.DEFAULT_PENALTY;

    public CurrentAccount(long accountNo,String name,long openBal) throws NegativeAmountException{
        super(accountNo, name, openBal);
    }

    public CurrentAccount(String n, long openBal) throws NegativeAmountException {
        super(n, openBal);
    }

    public void setPenalty(Penalty p){
        this.penalty = p;
    }


    public boolean withdraw(long amt) throws NegativeAmountException {
        if (!super.withdraw(amt)) {
            return false;
        }
        if (this.getBalance() < minimumBalance) {
            long penalyAmount = penalty.compute(minimumBalance,this.getBalance());
            new Transaction("Penalty", TransType.DEBIT, penalyAmount);
        }
        return true;
    }
}
