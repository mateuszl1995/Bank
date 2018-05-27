package BankOperation;

import BankProduct.BankProductAccount;
import BankProduct.BankProductInterface;
import BankProduct.Credit;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.Interest;

import java.util.Date;

public class BankOperationCreateCredit extends BankOperation {

    float amount;
    Interest interest;
    Credit credit;
    BankProductAccount productSource;

    public BankOperationCreateCredit(BankProductAccount productSource, float amount, Interest interest) {
        super(productSource);
        this.productSource = productSource;
        this.amount = amount;
        this.interest = interest;
    }

    @Override
    public Type getType() {
        return Type.CREATE_CREDIT;
    }

    //    public void addCredit(BankProduct.Credit credit) {
//        credits.add(credit);
//    }

    @Override
    protected State executeOperation() throws BankProductAccountWithDebit.NotEnoughMoneyException {
        credit = new Credit(productSource, amount, interest);
        BankOperation op = new BankOperationDeposit(productSource, amount);
        op.executeOperation();
        productSource.addCredit(credit);
        return State.SUCCESS;
    }
}
