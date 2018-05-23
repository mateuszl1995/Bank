package Report;

import BankProduct.*;

import java.util.ArrayList;
import java.util.List;

public class ReportVisitorBelowZero implements ReportVisitorInterface {
    ReportVisitorBelowZero(){}

    protected List<BankProductInterface> matchingProducts;


    public List<BankProductInterface> getReport(List<BankProductInterface>inputList){
        matchingProducts = new ArrayList<>();
        for (BankProductInterface product : inputList) {
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

    @Override
    public void visit(BankProductInvestment product) {

    }

    @Override
    public void visit(BankProductCredit product) {

    }
}
