import java.util.Date;

public abstract class BankProduct implements BankProductInterface {
    BankProduct(){

        this.balance = 0;
        this.createDate = new Date();
        this.history = new History();
    }

    protected float balance;              //saldo
    protected Date createDate;
    protected History history;

    @Override
    public void historyAdd(BankOperation operation) {
        history.add(operation);
    }

    public void setBalance(float newBalance){
        this.balance = newBalance;
    }

    public void changeBalance(float ammount){
        balance = balance + ammount;
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
}
