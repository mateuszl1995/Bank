import java.util.ArrayList;

public interface ReportVisitorInterface {

    void visit(BankProductAccountWithDebit product);
    void visit(BankProductAccountWithoutDebit product);
    void visit(BankProductCredit product);
    void visit(BankProductInvestment product);
}
