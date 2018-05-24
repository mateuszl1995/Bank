package Bank;

import BankOperation.BankOperationInterface;
import BankProduct.Decorators.BankProductAccountWithDebit;

import java.util.ArrayList;
import java.util.List;

public class BankMediator implements BankMediatorInterface {
    List<BankInterface> bankList;

    public BankMediator(){
        this.bankList = new ArrayList<>();
    }


    public void addBank(BankInterface bank){
        bankList.add(bank);
    }

    @Override
    public void executeOperation(BankOperationInterface bankOperation, BankInterface hostBank) throws BankProductAccountWithDebit.NotEnoughMoneyException {
        try {
            for (BankInterface bank : bankList) {
                if (bank != hostBank) {
                    if (bank.getBankProduct(bankOperation.getDestinationNumber()) != null) {
                        bankOperation.setProductDestination(bank.getBankProduct(bankOperation.getDestinationNumber()));
                        bankOperation.execute();
                        hostBank.addToHistory((bankOperation));
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

