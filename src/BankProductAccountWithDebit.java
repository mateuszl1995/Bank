//public class BankProductAccountWithDebit extends BankProduct {
//    BankProductAccount account;
//    BankProductAccountWithDebit(float limit, BankProductAccount account, Interest interest){
//        super(interest);
//        this.limit = limit;
//        this.account = account;
//    }
//    private float limit;
//
//    @Override
//    public BankProductAccount getAccount() {
//        return this.account;
//    }
//}
public class BankProductAccountWithDebit implements BankProductInterface {
    BankProductAccountWithDebit(BankProductAccount account, float limit){
        this.account = account;
        this.limit = limit;
    }

    private float limit;
    private float debit;
    private BankProductInterface account;



    public void setLimit(float limit) {
        this.limit = limit;
    }


    public float changeBalance(float amount) {



        return balance;
    }
//    @Override
//    protected State executeOperation() {
//        float balance = productSource.getBalance();
//        if (balance < amount)
//            return State.FAIL;
//        productSource.changeBalance(-amount);
//        return State.SUCCESS;




}

BankProduktInterface product = new BankProductAccountWithDebit(BankProductAccount account, float limit);
product.withdrow();
product.deposit();

