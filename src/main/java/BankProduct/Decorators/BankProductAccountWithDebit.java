package BankProduct.Decorators;

import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithoutDebit;
import Report.ReportVisitorInterface;

public class BankProductAccountWithDebit extends BankProductAccountDecorator {
    BankProductAccountWithDebit(BankProductAccount baseProduct, float limit){
        super(baseProduct);
        this.limit = limit;
    }

    private float limit;
    private float debit;

    public void changeBalance(float amount) throws NotEnoughMoneyException {
        float balance = baseProduct.getBalance() - debit;
        balance += amount;
        if (balance < -(baseProduct.getBalance() + limit)) {
            throw new NotEnoughMoneyException();
        }
        else if (balance < 0) {
            debit = -balance;
            baseProduct.setBalance(0.0f);
        } else {
            debit = 0;
            baseProduct.setBalance(balance);
        }
    }

    @Override
    public void calculateInterest() {
        baseProduct.calculateInterest();
    }

    public float getBalance() {
        return baseProduct.getBalance() - debit;
    }
    public void setBalance(float x) {baseProduct.setBalance(x); debit = 0;}

    public void acceptReport(ReportVisitorInterface visitor) {
        visitor.visit(this);
    }

    public class NotEnoughMoneyException extends Throwable {  }
}

