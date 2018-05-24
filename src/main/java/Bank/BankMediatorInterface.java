package Bank;

import BankOperation.BankOperationInterface;
import BankProduct.Decorators.BankProductAccountWithDebit;

public interface BankMediatorInterface {

    void addBank(BankInterface bank);
    void executeOperation(BankOperationInterface bankOperation, BankInterface bank) throws BankProductAccountWithDebit.NotEnoughMoneyException;
}
