package BankOperation;

import BankProduct.BankProductAccount;
import BankProduct.BankProductInterface;
import BankProduct.Credit;
import BankProduct.Decorators.BankProductAccountWithDebit;

public class BankOperationCreditPay extends BankOperation {
    BankProductInterface bankProductInterface;
    BankProductAccount source;
    BankOperationCreditPay(Credit credit) {
        super(credit.getAccount());
        this.source = productSource;
        productSource = null;
        this.bankProductInterface = credit;
    }

    @Override
    public Type getType() {
        return Type.CREDIT_PAY;
    }

    @Override
    protected State executeOperation() throws BankProductAccountWithDebit.NotEnoughMoneyException {
        bankProductInterface.calculateInterest();
        try {
            productSource.changeBalance(-bankProductInterface.getBalance());
            productSource.removeCredit(bankProductInterface);
        } catch (Exception e) {
            return State.FAIL;
        }
        return State.SUCCESS;
    }
}
