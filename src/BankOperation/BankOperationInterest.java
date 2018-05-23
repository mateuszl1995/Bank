package BankOperation;

import BankProduct.BankProduct;
import Interest.Interest;

public class BankOperationInterest extends BankOperation {

    BankProduct bankProduct;
    Interest interest;

    BankOperationInterest(BankProduct bankProduct, Interest interest) {
        super(bankProduct.getAccount());
        this.bankProduct = bankProduct;
        this.interest = interest;
    }


    @Override
    protected State executeOperation() {
        bankProduct.changeBalance(interest.calculateInterest(bankProduct));
        return State.SUCCESS;
    }

    @Override
    public Type getType() {
        return Type.INTEREST;
    }
}
