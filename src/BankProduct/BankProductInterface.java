package BankProduct;

import Report.ReportVisitorInterface;
import BankOperation.BankOperation;

public interface BankProductInterface {
    void historyAdd(BankOperation operation);
    BankProductAccount getAccount();
    public float getBalance();
    void acceptReport(ReportVisitorInterface visitor);
    long getNumber();
}
