public class Bank {
    History history;

    Bank() {
        this.history = new History();
    }

    public void execute(BankOperationInterface bankOperation) {
        try {
            bankOperation.execute();
            history.add(bankOperation);
            System.out.println(bankOperation.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
