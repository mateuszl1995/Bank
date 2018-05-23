package Report;

import BankProduct.BankProductAccountWithDebit;
import BankProduct.BankProductAccountWithoutDebit;
import BankProduct.BankProductCredit;
import BankProduct.BankProductInvestment;

public interface ReportVisitorInterface {

    void visit(BankProductAccountWithDebit product);
    void visit(BankProductAccountWithoutDebit product);
    void visit(BankProductCredit product);
    void visit(BankProductInvestment product);
}
