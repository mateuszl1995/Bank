public class BankOperationBreakInvestment extends BankOperation {
    BankProductInvestment investment;
    BankOperationBreakInvestment(BankProductInvestment investment) {
        super(investment.getAccount());
        this.investment = investment;
    }

    @Override
    public Type getType() {
        return Type.BREAK_INVESTMENT;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "   " + productSource.getBalance();
    }

    @Override
    protected State executeOperation() {
        if (!productSource.containsInvestment(investment))
            return State.FAIL;
        if (investment.hasExpired()) {
            investment.getAmount();
        } else {
            investment.getInitialAmount();
        }
        productSource.changeBalance(investment.getAmount());
        productSource.eraseInvestment(investment);
        return State.SUCCESS;
    }
}
