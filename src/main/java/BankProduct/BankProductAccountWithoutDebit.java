package BankProduct;

import Bank.Client;
import Bank.History;
import BankOperation.BankOperation;
import Interest.InterestZero;
import Interest.Interest;
import Report.ReportVisitorInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankProductAccountWithoutDebit extends BankProduct implements BankProductAccount {
    public BankProductAccountWithoutDebit(Client client) {
        this(client, new InterestZero());
    }
    public BankProductAccountWithoutDebit(Client client, Interest interest){
        super(interest);
        this.client = client;
        this.investments = new ArrayList<Investment>();
        this.credits = new ArrayList<Credit>();
        createDate = new Date();
        history = new History();
    }

    private Client client;
    Date createDate;

    List<Investment> investments;
    List<Credit> credits;

    History history;

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    public Interest getInterest() {
        return interest;
    }

    public Client getClient() {
        return client;
    }

    public void acceptReport(ReportVisitorInterface visitor) {
        visitor.visit(this);
    }

    @Override
    public void historyAdd(BankOperation bankOperation) {
        history.add(bankOperation);
    }

    @Override
    public History getHistory() {
        return history;
    }

    @Override
    public void changeBalance(float amount) {
        super.changeBalance(amount);
    }

    public void addInvestment(Investment investment) {
        investments.add(investment);
    }
    public void eraseInvestment(Investment investment) {
        investments.remove(investment);
    }
    public boolean containsInvestment(Investment investment) {
        return investments.contains(investment);
    }
    public Investment getInvestment(int index) { return investments.get(index); }
    public void addCredit(Credit credit) { credits.add(credit); }
    public void removeCredit (Credit credit) { credits.remove(credit); }
    public boolean containsCredit(Credit credit) {
        return credits.contains(credit);
    }
    public void eraseCredit(Credit credit) {
        credits.remove(credit);
    }

    @Override
    public Credit getCredit(int index) {
        return credits.get(0);
    }

    public BankProductAccount getAccount() {
        return this;
    }
}
