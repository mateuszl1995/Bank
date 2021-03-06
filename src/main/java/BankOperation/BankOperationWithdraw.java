package BankOperation;

import BankProduct.BankProductAccount;
import BankProduct.Decorators.BankProductAccountWithDebit;

public class BankOperationWithdraw extends BankOperation {
    float amount;
    public BankOperationWithdraw(BankProductAccount productSource, float amount) {
        super(productSource);
        this.amount = amount;
    }

    @Override
    protected State executeOperation() throws BankProductAccountWithDebit.NotEnoughMoneyException {
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

    public Type getType() {
        return Type.WITHDRAW;
    }
}
