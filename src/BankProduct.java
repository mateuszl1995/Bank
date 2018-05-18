import java.util.Date;

public abstract class BankProduct implements BankProductInterface {
    BankProduct(Interest interest){

        this.balance = 0;
        this.createDate = new Date();
        this.history = new History();
        this.interest = interest;
    }

    protected float balance;              //saldo
    protected Date createDate;
    protected History history;
    protected Interest interest;


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
