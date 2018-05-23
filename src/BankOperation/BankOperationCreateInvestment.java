package BankOperation;

import BankProduct.Decorators.BankProductAccountWithDebit;
import BankProduct.Investment;
import Interest.Interest;

import java.util.Date;

public class BankOperationCreateInvestment extends BankOperation {
    float amount;
    Interest interest;
    Investment investment;
    BankProductAccount productSource;
    Date expires;

    public BankOperationCreateInvestment(BankProductAccount productSource, float amount, Interest interest, Date expires) {
        super(productSource);
        this.productSource = productSource;
        this.amount = amount;
        this.interest = interest;
        this.expires = expires;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "   " + this.amount + "     " + productSource.getBalance();
    }

    @Override
    public Type getType() {
        return Type.CREATE_INVESTMENT;
    }

    @Override
    protected State executeOperation() throws BankProductAccountWithDebit.NotEnoughMoneyException {
        if (productSource.getBalance() < amount)
            return State.FAIL;
        investment = new Investment(productSource, amount, interest, expires);
        BankOperation op = new BankOperationWithdraw(productSource, amount);
        op.executeOperation();
        productSource.addInvestment(investment);
        return State.SUCCESS;
    }
}
