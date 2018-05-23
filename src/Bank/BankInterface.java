package Bank;

import BankOperation.BankOperationInterface;
import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithDebit;

import java.util.ArrayList;

public interface BankInterface {
    ArrayList<BankProductAccount> getAccountsList();
    void execute(BankOperationInterface bankOperation) throws BankProductAccountWithDebit.NotEnoughMoneyException;
    void addAccount(BankProductAccount product);
    BankProductAccount getBankProduct(long number);
    void addToHistory(BankOperationInterface operation);
}
