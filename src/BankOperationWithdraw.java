import java.util.Date;

public class BankOperationWithdraw extends BankOperation {
    float amount;
    BankOperationWithdraw(BankProductAccount productSource, float amount) {
        super(productSource);
        this.amount = amount;
    }

    @Override
    protected State executeOperation() {
        float balance = productSource.getBalance();
        if (balance < amount)
            return State.FAIL;
        productSource.changeBalance(-amount);
        return State.SUCCESS;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "  " + this.amount + "     " + productSource.getBalance();
    }

    @Override
    public Type getType() {
        return Type.WITHDRAW;
    }
}
