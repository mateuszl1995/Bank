package Bank;

import BankOperation.BankOperationInterface;
import BankProduct.BankProductAccount;
import BankProduct.Decorators.BankProductAccountWithDebit;

public interface BankMediatorInterface {

    void addBank(BankInterface bank);
    boolean acceptOperation(BankOperationInterface operation, BankInterface hostBank);


}
