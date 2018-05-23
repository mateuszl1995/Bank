package BankOperation;

import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithDebit;

public class BankOperationDeposit extends BankOperation {
    float amount;
    BankOperationDeposit(BankProductAccount productSource, float amount) {
        super(productSource);
        this.amount = amount;
    }

    @Override
    protected State executeOperation() throws BankProductAccountWithDebit.NotEnoughMoneyException {
        float balance = productSource.getBalance();
        productSource.changeBalance(amount);
        return State.SUCCESS;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "   " + this.amount + "     " + productSource.getBalance();
    }

    @Override
    public Type getType() {
        return BankOperationInterface.Type.DEPOSIT;
    }
}