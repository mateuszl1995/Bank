package BankOperation;

import BankProduct.Decorators.BankProductAccountWithDebit;
import BankProduct.Investment;

public class BankOperationBreakInvestment extends BankOperation {
    Investment investment;
    public BankOperationBreakInvestment(Investment investment) {
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
        try {
            productSource.changeBalance(investment.getAmount());
        } catch (BankProductAccountWithDebit.NotEnoughMoneyException e) {
            e.printStackTrace();
        }
        productSource.eraseInvestment(investment);
        return State.SUCCESS;
    }
}
