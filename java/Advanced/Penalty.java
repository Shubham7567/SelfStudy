package bank;

@FunctionalInterface
public interface Penalty {
    public long Compute(long min_balance,long balance);
    public static final Penalty ZERO_PENALTY = (min_balance,balance) -> 0;
    public static final Penalty DEFAULT_PENALTY = (min_balance,balance) -> balance < min_balance ? 100 : 0;
    public static Penalty Fixed(long penalty_amount){
        return (min_balance,balance) -> {
            return balance < min_balance ? penalty_amount : 0;
        };
    }
    public static Penalty Percentage(double percentage){
        return (min_balance,balance) -> {
            long diff = min_balance - balance;
            if(diff >= 0) return 0;
            return (long)(diff * percentage);
        };
    }
}
