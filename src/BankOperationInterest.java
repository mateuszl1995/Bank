public class BankOperationInterest extends BankOperation {

    BankProduct bankProduct;

    BankOperationInterest(BankProductAccount account) {
        super(account);
        // TODO: super(productSource);
    }

    @Override
    protected State executeOperation() {
        this.productSource.calculateInterest();
        return State.SUCCESS;
    }

    @Override
    public Type getType() {
        return Type.INTEREST;
    }
}
