package Report;

import BankProduct.Decorators.BankProductAccountWithDebit;
import BankProduct.BankProductAccountWithoutDebit;
import BankProduct.Credit;
import BankProduct.Investment;

public interface ReportVisitorInterface {

    void visit(BankProductAccountWithDebit product);
    void visit(BankProductAccountWithoutDebit product);
}
