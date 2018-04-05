public class BankOperationInterest extends BankOperation {

    BankProduct bankProduct;

    BankOperationInterest(BankProductAccount account) {
        super(account);
        // TODO: super(productSource);
    }

    @Override
    protected State executeOperation() {
        // TODO: execute
        return null;
    }

    @Override
    public Type getType() {
        return Type.INTEREST;
    }
}
