package BankProduct.Decorators;

import Bank.History;
import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithoutDebit;
import BankProduct.Credit;
import Report.ReportVisitorInterface;

import java.util.Date;

public class BankProductAccountWithDebit extends BankProductAccountDecorator {
    public BankProductAccountWithDebit(BankProductAccount baseProduct, float limit){
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
    public Credit getCredit(int index) {
        return baseProduct.getCredit(0);
    }

    @Override
    public void calculateInterest() {
        baseProduct.calculateInterest();
    }

    @Override
    public Date getCreateDate() {
        return baseProduct.getCreateDate();
    }

    public float getBalance() {
        return baseProduct.getBalance() - debit;
    }
    public void setBalance(float x) {baseProduct.setBalance(x); debit = 0;}

    public void acceptReport(ReportVisitorInterface visitor) {
        visitor.visit(this);
    }

    @Override
    public History getHistory() {
        return baseProduct.getHistory();
    }

    public class NotEnoughMoneyException extends Throwable {  }
}

