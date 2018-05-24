package BankOperation;

import BankProduct.Credit;
import BankProduct.Decorators.BankProductAccountWithDebit;

public class BankOperationCreditPay extends BankOperation {
    Credit credit;
    BankProductAccount source;
    BankOperationCreditPay(Credit credit) {
        super(credit.getAccount());
        this.source = productSource;
        productSource = null;
        this.credit = credit;
    }

    @Override
    public Type getType() {
        return Type.CREDIT_PAY;
    }

    @Override
    protected State executeOperation() throws BankProductAccountWithDebit.NotEnoughMoneyException {
        credit.calculateInterest();
        try {
            productSource.changeBalance(-credit.getBalance());
            productSource.removeCredit(credit);
        } catch (Exception e) {
            return State.FAIL;
        }
        return State.SUCCESS;
    }
}
