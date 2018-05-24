package Report;

import BankProduct.*;
import BankProduct.Decorators.BankProductAccountWithDebit;

import java.util.ArrayList;

public class ReportVisitorBankBalance implements ReportVisitorInterface {
    ReportVisitorBankBalance(){
        this.balance = 0.f;
    }

    protected float balance;

    public float getReport(ArrayList<BankProductAccount> inputList) {
        balance = 0;
        for (BankProductAccount product : inputList){
            product.acceptReport(this);
        }
        return balance;
    }

    public float getBalance() {
        return balance;
    }

    @Override
    public void visit(BankProductAccountWithoutDebit product) {
        balance+=product.getBalance();
    }

    @Override
    public void visit(BankProductAccountWithDebit product) {
        balance+=product.getBalance();
    }

}
