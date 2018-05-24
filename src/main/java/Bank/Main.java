package Bank;

import BankOperation.*;
import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithoutDebit;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.InterestAnnual;
import Interest.InterestZero;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws BankProductAccountWithDebit.NotEnoughMoneyException {
        BankMediator mediator = new BankMediator();
        Bank bank2 = new Bank(mediator);
        Bank bank = new Bank(mediator);
        mediator.addBank(bank);
        mediator.addBank(bank2);

        Client client = new Client("Jan", "Kowalski");
        BankProductAccount account = new BankProductAccountWithoutDebit(client, new InterestAnnual(2.75f));
        BankProductAccount account2 = new BankProductAccountWithoutDebit(client, new InterestZero());


        BankOperationInterface operation;
    try {
        operation = new BankOperationDeposit(account, 5000.0f);
        bank.execute(operation);

        operation = new BankOperationDeposit(account, 530.0f);
        bank.execute(operation);

        operation = new BankOperationWithdraw(account, 5000.0f);
        bank.execute(operation);

        operation = new BankOperationWithdraw(account, 550.0f);
        bank.execute(operation);

        operation = new BankOperationTransfer(account, account2.getNumber(), 300.0f);
        bank.execute(operation);

        operation = new BankOperationWithdraw(account2, 250.0f);
        bank.execute(operation);

        operation = new BankOperationDeposit(account2, 200000.0f);
        bank.execute(operation);

        operation = new BankOperationTransfer(account2, account2.getNumber(), 300.0f);
        bank.execute(operation);

        operation = new BankOperationWithdraw(account2, 250.0f);
        bank.execute(operation);

        operation = new BankOperationCreateInvestment(account2, 100000.0f, new InterestAnnual(6.5f), new Date(2019, 3, 1));
        bank.execute(operation);

        operation = new BankOperationBreakInvestment(account2.getInvestment(0));
        bank.execute(operation);
    } catch (Throwable e){
        e.printStackTrace();
    }
    }
}
