package BankProduct;

import Bank.History;
import BankOperation.BankOperation;
import Interest.Interest;

import java.util.Date;

public abstract class BankProduct implements BankProductInterface {
    BankProduct(Interest interest){
        this.balance = 0;
        this.createDate = new Date();
        this.history = new History();
        this.interest = interest;
        generateAccountNumber();
    }

    protected long number;
    protected float balance;              //saldo
    protected Date createDate;
    protected History history;
    protected Interest interest;
    static long maxNumber =  1000000000;

    protected synchronized void generateAccountNumber(){
        this.number = ++maxNumber;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public void historyAdd(BankOperation operation) {
        history.add(operation);
    }

    public void setBalance(float newBalance){
        this.balance = newBalance;
    }

    public void changeBalance(float amount){
        balance = balance + amount;
    }

    public Date getDate(){
        return createDate;
    }

    public float getBalance(){
        return balance;
    }

    public History getHistory(){
        return new History(history);
    }

    public void setInterestType(Interest interest) { this.interest = interest; }

    public void calculateInterest() { interest.calculateInterest(this); }

}
