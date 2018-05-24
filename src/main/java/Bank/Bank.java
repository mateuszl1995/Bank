package Bank;

import BankOperation.BankOperationInterface;
import BankProduct.BankProductAccount;
import BankProduct.Decorators.BankProductAccountWithDebit;

import java.util.ArrayList;

public class Bank implements BankInterface{
    History history;
    ArrayList<BankProductAccount> accountsList;
    BankMediatorInterface mediator;

    public Bank(BankMediatorInterface mediator) {
        this.history = new History();
        this.mediator = mediator;
    }

    public ArrayList<BankProductAccount> getAccountsList() {
        return accountsList;
    }

    public void addAccount(BankProductAccount product){
        accountsList.add(product);
    }

    public BankProductAccount getBankProduct(long number){
        for (BankProductAccount bankProduct : accountsList){
            if (bankProduct.getNumber() == number){
                return bankProduct;
            }
        }
        return null;
    }

    @Override
    public void addToHistory(BankOperationInterface operation) {
        history.add(operation);
    }

    public void execute(BankOperationInterface bankOperation) throws BankProductAccountWithDebit.NotEnoughMoneyException {
        try {
            Long destinationNumber = bankOperation.getDestinationNumber();
            if (getBankProduct(destinationNumber) != null) {
                bankOperation.setProductDestination(getBankProduct(destinationNumber));
                bankOperation.execute();
                history.add(bankOperation);
            }
            else {
                mediator.executeOperation(bankOperation, this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
