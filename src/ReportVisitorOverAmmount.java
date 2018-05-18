import java.util.ArrayList;
import java.util.List;

public class ReportVisitorOverAmmount implements ReportVisitorInterface {
    ReportVisitorOverAmmount(float amount){
        this.amount = amount;
    }
    protected float amount;
    protected List<BankProductInterface> matchingProducts;

    public List<BankProductInterface> getReport(ArrayList<BankProductInterface> inputList) {
        matchingProducts = new ArrayList<>();
        for (BankProductInterface product : inputList) {
            product.acceptReport(this);
        }
        return matchingProducts;
    }

    @Override
    public void visit(BankProductCredit product) {
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
    public void visit(BankProductInvestment product) {
        if (product.getBalance() > amount)
            this.matchingProducts.add(product);
    }
}
