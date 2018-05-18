import java.util.Date;

public class BankOperationCreateCredit extends BankOperation {

    float amount;
    Interest interest;
    BankProductCredit credit;
    BankProductAccount productSource;
    Date expires;

    BankOperationCreateCredit(BankProductAccount productSource, float amount, Interest interest, Date expires) {
        super(productSource);
        this.productSource = productSource;
        this.amount = amount;
        this.interest = interest;
        this.expires = expires;
    }

    @Override
    public Type getType() {
        return Type.CREATE_CREDIT;
    }

    //    public void addCredit(BankProductCredit credit) {
//        credits.add(credit);
//    }

    @Override
    protected State executeOperation() throws BankProductAccountWithDebit.NotEnoughMoneyException {
        credit = new BankProductCredit(productSource, amount, interest, expires);
        BankOperation op = new BankOperationDeposit(productSource, amount);
        op.executeOperation();
        productSource.addCredit(credit);
        return State.SUCCESS;
    }
}
