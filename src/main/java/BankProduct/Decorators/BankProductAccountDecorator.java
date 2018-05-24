package BankProduct.Decorators;

import Bank.Client;
import BankOperation.BankOperation;
import BankProduct.BankProductAccount;
import BankProduct.Credit;
import BankProduct.Investment;
import Interest.Interest;
import Report.ReportVisitorInterface;

public abstract class BankProductAccountDecorator implements BankProductAccount {

    protected BankProductAccount baseProduct;

    public BankProductAccountDecorator(BankProductAccount baseProduct){
        super();
        this.baseProduct = baseProduct;
    }
    public long getNumber(){return baseProduct.getNumber();}
    public Interest getInterest(){return baseProduct.getInterest();}
    public Client getClient(){return baseProduct.getClient();}
    public float getBalance(){return baseProduct.getBalance();}
    public void setBalance(float balance){baseProduct.setBalance(balance);}
    public void changeBalance(float amount) throws BankProductAccountWithDebit.NotEnoughMoneyException {
        try {
            baseProduct.changeBalance(amount);
        } catch (BankProductAccountWithDebit.NotEnoughMoneyException e){
            e.printStackTrace();
        }
    }

    public void historyAdd(BankOperation bankOperation){baseProduct.historyAdd(bankOperation);}

    public void addInvestment(Investment investment){baseProduct.addInvestment(investment);}
    public void eraseInvestment(Investment investment){baseProduct.eraseInvestment(investment);}
    public boolean containsInvestment(Investment investment){return baseProduct.containsInvestment(investment);}
    public Investment getInvestment(int index){return baseProduct.getInvestment(index);}

    public void addCredit(Credit credit){baseProduct.addCredit(credit);}
    public void removeCredit(Credit credit){baseProduct.removeCredit(credit);}
    public boolean containsCredit(Credit credit){return baseProduct.containsCredit(credit);}
    public void eraseCredit(Credit credit){baseProduct.eraseCredit(credit);}


    public void acceptReport(ReportVisitorInterface visitor){baseProduct.acceptReport(visitor);}

    public BankProductAccount getAccount(){return baseProduct.getAccount();}


}
