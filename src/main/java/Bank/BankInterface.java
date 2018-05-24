package Bank;

import BankOperation.BankOperationInterface;
import BankProduct.BankProductAccount;
import BankProduct.Decorators.BankProductAccountWithDebit;

import java.util.ArrayList;

public interface BankInterface {
    ArrayList<BankProductAccount> getAccountsList();
    void execute(BankOperationInterface bankOperation)
            throws BankOperationInterface.DoubleExecutionException, BankProductAccountWithDebit.NotEnoughMoneyException, AccountNumberNotFoundException;
    void addAccount(BankProductAccount product);
    void addToHistory(BankOperationInterface operation);
    boolean acceptOperation(BankOperationInterface operation);
    History getHistory();

    class AccountNumberNotFoundException extends Throwable{
        public AccountNumberNotFoundException(){super();}
        public AccountNumberNotFoundException(String message){super(message);}
    }


}
