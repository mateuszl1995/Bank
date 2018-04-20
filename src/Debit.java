public class Debit extends BankProduct {
    BankProductAccount account;
    Debit(float limit, BankProductAccount account, Interest interest){
        super(interest);
        this.limit = limit;
        this.account = account;
    }
    private float limit;

    @Override
    public BankProductAccount getAccount() {
        return this.account;
    }
}
