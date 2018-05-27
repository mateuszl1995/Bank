package Bank;

import BankOperation.BankOperationInterface;
import BankProduct.BankProductAccount;
import BankProduct.Decorators.BankProductAccountWithDebit;

import java.util.ArrayList;

public class Bank implements BankInterface{
    private History history;
    private ArrayList<BankProductAccount> accountsList;
    private BankMediatorInterface mediator;

    public Bank(BankMediatorInterface mediator) {
        this();
        this.mediator = mediator;
    }

    public Bank() {
        this.history = new History();
        this.accountsList = new ArrayList<>();
    }

    public ArrayList<BankProductAccount> getAccountsList() {
        return accountsList;
    }

    public void addAccount(BankProductAccount product){
        accountsList.add(product);
    }

    public History getHistory() {
        return history;
    }

    public boolean acceptOperation(BankOperationInterface operation){
        if (operation.getDestinationNumber() == null &&  accountsList.contains(operation.getProductSource())) return true; //local bank
        if (getBankProduct(operation.getDestinationNumber()) != null) {
            //if (SomeConditions){
            operation.setProductDestination(getBankProduct(operation.getDestinationNumber()));
            return true;
            }
        return false;
    }

    private BankProductAccount getBankProduct(Long number){
        for (BankProductAccount bankProduct : accountsList) {
            if (bankProduct.getNumber() == number) {
                return bankProduct;
            }
        }
        return null;
    }

    @Override
    public void addToHistory(BankOperationInterface operation) {
        history.add(operation);
    }

    public void execute(BankOperationInterface bankOperation)
            throws  BankOperationInterface.DoubleExecutionException,
                    AccountNumberNotFoundException,
                    BankProductAccountWithDebit.NotEnoughMoneyException{
        try {
            if (!accountsList.contains(bankOperation.getProductSource())) throw new AccountNumberNotFoundException("Product source doesn't belong to this bank");
            if (acceptOperation(bankOperation)) {
                bankOperation.execute();
                history.add(bankOperation);
            }
            else if (mediator.acceptOperation(bankOperation, this)) {
                bankOperation.execute();
                history.add(bankOperation);
            }
            else throw new AccountNumberNotFoundException();
        } catch (BankProductAccountWithDebit.NotEnoughMoneyException
                | BankOperationInterface.DoubleExecutionException e) {
                    throw e;
        }
    }
}
