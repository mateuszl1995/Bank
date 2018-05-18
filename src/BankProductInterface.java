public interface BankProductInterface {
    void historyAdd(BankOperation operation);
    BankProductAccount getAccount();
    public float getBalance();
    void acceptReport(ReportVisitorInterface visitor);
}
