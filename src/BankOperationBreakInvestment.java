public class BankOperationBreakInvestment extends BankOperation {
    BankProductInvestment investment;
    BankProductAccount productSource;
    BankOperationBreakInvestment(BankProductAccount account, BankProductInvestment investment) {
        super(account);
        this.productSource = account;
        this.investment = investment;
    }

    @Override
    public Type getType() {
        return Type.BREAK_INVESTMENT;
    }

    @Override
    protected State executeOperation() {
        if (!productSource.containsInvestment(investment))
            return State.FAIL;
        productSource.eraseInvestment(investment);
        return State.SUCCESS;
    }
}
