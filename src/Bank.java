import java.util.ArrayList;

public class Bank {
    History history;
    ArrayList<BankProductInterface> accountsList;

    Bank() {
        this.history = new History();
    }

    public void execute(BankOperationInterface bankOperation) throws BankProductAccountWithDebit.NotEnoughMoneyException {
        try {
            bankOperation.execute();
            history.add(bankOperation);
            System.out.println(bankOperation.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
