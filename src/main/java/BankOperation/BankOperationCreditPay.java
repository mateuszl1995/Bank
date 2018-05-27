package BankOperation;

import BankProduct.BankProductAccount;
import BankProduct.BankProductInterface;
import BankProduct.Credit;
import BankProduct.Decorators.BankProductAccountWithDebit.*;

public class BankOperationCreditPay extends BankOperation {
    Credit credit;
    public BankOperationCreditPay(Credit credit) {
        super(credit.getAccount());
        this.credit = credit;
    }

    @Override
    public Type getType() {
        return Type.CREDIT_PAY;
    }

    @Override
    protected State executeOperation() throws NotEnoughMoneyException {
        try {
            if (credit.getAmount() > productSource.getBalance())
                return State.FAIL;
            productSource.changeBalance(-credit.getAmount());
            productSource.removeCredit(credit);
        } catch (Exception e) {
            return State.FAIL;
        }
        return State.SUCCESS;
    }
}
