package BankOperation;

import BankProduct.BankProductAccount;
import BankProduct.Decorators.BankProductAccountWithDebit;
import BankProduct.Investment;

public class BankOperationEndInvestment extends BankOperation {
    Investment investment;
    public BankOperationEndInvestment(Investment investment) {
        super(investment.getAccount());
        this.investment = investment;
    }

    @Override
    public Type getType() {
        return Type.END_INVESTMENT;
    }

    @Override
    protected State executeOperation() throws BankProductAccountWithDebit.NotEnoughMoneyException {
        if (!productSource.containsInvestment(investment))
            return State.FAIL;
        try {
            productSource.changeBalance(investment.getAmount());
        } catch (BankProductAccountWithDebit.NotEnoughMoneyException e) {
            e.printStackTrace();
        }
        productSource.eraseInvestment(investment);
        return State.SUCCESS;
    }
}
