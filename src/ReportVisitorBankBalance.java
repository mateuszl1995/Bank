import java.util.ArrayList;

public class ReportVisitorBankBalance implements ReportVisitorInterface {
    ReportVisitorBankBalance(){
        this.balance = 0.f;
    }

    protected float balance;

    public float getReport(ArrayList<BankProductInterface> inputList) {
        balance = 0;
        for (BankProductInterface product : inputList){
            product.acceptReport(this);
        }
        return balance;
    }

    @Override
    public void visit(BankProductInvestment product) {
        balance+=product.getBalance();
    }

    @Override
    public void visit(BankProductAccountWithoutDebit product) {
        balance+=product.getBalance();
    }

    @Override
    public void visit(BankProductAccountWithDebit product) {
        balance+=product.getBalance();
    }

    @Override
    public void visit(BankProductCredit product) {
        balance+=product.getBalance();
    }
}
