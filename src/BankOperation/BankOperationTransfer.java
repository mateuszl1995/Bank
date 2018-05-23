package BankOperation;

import BankProduct.Decorators.BankProductAccountWithDebit;

public class BankOperationTransfer extends BankOperation {

    float amount;

    public BankOperationTransfer(BankProductAccount productSource, long destinationNumber, float amount) {
        super(productSource);
        this.destinationNumber = destinationNumber;
        this.amount = amount;
    }

    @Override
    protected State executeOperation() throws BankProductAccountWithDebit.NotEnoughMoneyException {
        BankOperationWithdraw op1 = new BankOperationWithdraw(productSource, amount);
        if (op1.executeOperation() == State.SUCCESS) {
            BankOperationDeposit op2 = new BankOperationDeposit(productDestination, amount);
            op2.executeOperation();
            return State.SUCCESS;
        }
        return State.FAIL;

    }

    @Override
    public String getDescription() {
        return super.getDescription() + "   " + this.amount + "     " + productSource.getBalance() + "   " + productDestination.getBalance();
    }

    @Override
    public Type getType() {
        return Type.TRANSFER;
    }
}
