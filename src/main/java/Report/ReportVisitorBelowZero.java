package Report;

import BankProduct.*;
import BankProduct.Decorators.BankProductAccountWithDebit;

import java.util.ArrayList;
import java.util.List;

public class ReportVisitorBelowZero implements ReportVisitorInterface {
    ReportVisitorBelowZero(){}

    protected List<BankProductAccount> matchingProducts;


    public List<BankProductAccount> getReport(List<BankProductAccount>inputList){
        matchingProducts = new ArrayList<>();
        for (BankProductAccount product : inputList) {
            product.acceptReport(this);
        }
        return matchingProducts;
    }

    @Override
    public void visit(BankProductAccountWithDebit product) {
        if (product.getBalance() < 0)
            matchingProducts.add(product);
    }

    @Override
    public void visit(BankProductAccountWithoutDebit product) {

    }

}
