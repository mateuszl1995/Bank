public class Bank {
    History history;

    Bank() {
        this.history = new History();
    }

    public void execute(BankOperationInterface bankOperation) {
        bankOperation.execute();
        history.add(bankOperation);
        System.out.println(bankOperation.getDescription());
    }
}
