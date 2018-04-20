import java.util.Date;

public class BankOperationTransfer extends BankOperation {
    float amount;
    BankProductAccount productDestination;
    BankOperationTransfer(BankProductAccount productSource, BankProductAccount productDestination, float amount) {
        super(productSource);
        this.productDestination = productDestination;
        this.amount = amount;
    }

    @Override
    protected State executeOperation() {
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
