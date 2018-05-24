package Bank;

import BankOperation.BankOperationInterface;
import BankProduct.BankProductAccount;
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

    public boolean acceptOperation(BankOperationInterface operation, BankInterface hostBank){
        boolean success = false;
        for (BankInterface bank : bankList){
            if (bank != hostBank){
                if (bank.acceptOperation(operation)){
                    success = true;
                }
            }
        }
        return success;
    }

//    @Override
//    public void executeOperation(BankOperationInterface bankOperation, BankInterface hostBank)
//        throws BankOperationInterface.DoubleExecutionException, NumberNotFoundException, BankProductAccountWithDebit.NotEnoughMoneyException {
//        try {
//            boolean found = false;
//            for (BankInterface bank : bankList) {
//                if (bank != hostBank) {
//                    if (bank.getBankProduct(bankOperation.getDestinationNumber()) != null) {
//                        bankOperation.setProductDestination(bank.getBankProduct(bankOperation.getDestinationNumber()));
//                        bankOperation.execute();
//                        hostBank.addToHistory((bankOperation));
//                        found = true;
//                        break;
//                    }
//                }
//            }
//            if (!found) throw new NumberNotFoundException();
//        } catch (BankProductAccountWithDebit.NotEnoughMoneyException | BankOperationInterface.DoubleExecutionException e){
//            throw e;
//        }
//    }


}

