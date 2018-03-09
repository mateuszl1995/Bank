public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.execute(new BankOperation(new BankProduct(123)));
    }
}
