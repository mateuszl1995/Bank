package Report;

import BankProduct.*;
import BankProduct.Decorators.BankProductAccountWithDebit;

import java.util.ArrayList;
import java.util.List;

public class ReportVisitorOverAmmount implements ReportVisitorInterface {
    ReportVisitorOverAmmount(float amount){
        this.amount = amount;
    }
    protected float amount;
    protected List<BankProductAccount> matchingProducts;

    public List<BankProductAccount> getReport(ArrayList<BankProductAccount> inputList) {
        matchingProducts = new ArrayList<>();
        for (BankProductAccount product : inputList) {
            product.acceptReport(this);
        }
        return matchingProducts;
    }

    @Override
    public void visit(BankProduct.Credit product) {
        if (product.getBalance() > amount)
            this.matchingProducts.add(product);
    }

    @Override
    public void visit(BankProductAccountWithDebit product) {
        if (product.getBalance() > amount)
            this.matchingProducts.add(product);
    }

    @Override
    public void visit(BankProductAccountWithoutDebit product) {
        if (product.getBalance() > amount)
            this.matchingProducts.add(product);
    }

    @Override
    public void visit(BankProduct.Investment product) {
        if (product.getBalance() > amount)
            this.matchingProducts.add(product);
    }
}
