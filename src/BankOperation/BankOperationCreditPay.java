package BankOperation;

import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithDebit;
import BankProduct.BankProductCredit;

public class BankOperationCreditPay extends BankOperation {
    BankProductCredit credit;
    BankProductAccount source;
    BankOperationCreditPay(BankProductCredit credit) {
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
