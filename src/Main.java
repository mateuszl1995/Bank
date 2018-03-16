import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Client client = new Client("Jan", "Kowalski");
        BankProductAccount account = new BankProductAccount(client.getId(), new InterestAnnual(2.75f));
        BankProductAccount account2 = new BankProductAccount(client.getId(), new InterestZero());

        BankOperationInterface operation;

        operation = new BankOperationDeposit(account, 5000.0f);
        bank.execute(operation);

        operation = new BankOperationDeposit(account, 530.0f);
        bank.execute(operation);

        operation = new BankOperationWithdraw(account, 5000.0f);
        bank.execute(operation);

        operation = new BankOperationWithdraw(account, 550.0f);
        bank.execute(operation);

        operation = new BankOperationTransfer(account, account2, 300.0f);
        bank.execute(operation);

        operation = new BankOperationWithdraw(account2, 250.0f);
        bank.execute(operation);

        operation = new BankOperationDeposit(account2, 200000.0f);
        bank.execute(operation);

        operation = new BankOperationTransfer(account2, account, 300.0f);
        bank.execute(operation);

        operation = new BankOperationWithdraw(account2, 250.0f);
        bank.execute(operation);

        operation = new BankOperationCreateInvestment(account2, 100000.0f, new InterestAnnual(6.5f), new Date(2019, 3, 1));
        bank.execute(operation);
    }
}
