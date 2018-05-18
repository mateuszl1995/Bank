import java.util.Date;

public abstract class BankOperation implements BankOperationInterface {
    BankOperation(BankProductAccount productSource){
        this.productSource = productSource;
        this.state = State.NEW;
    }


    protected State state;
    protected Date date;
    protected Type type;
    protected String description;
    protected BankProductAccount productSource;


    public void execute () throws DoubleExecutionException, BankProductAccountWithDebit.NotEnoughMoneyException {
        try {
            if (state == State.SUCCESS)
                throw new DoubleExecutionException();
            state = executeOperation();
            date = new Date();
            productSource.historyAdd(this);
        } catch (Exception e) {
            e.printStackTrace();
            state = State.FAIL;
        }
    }

    protected abstract State executeOperation() throws BankProductAccountWithDebit.NotEnoughMoneyException;

    public Date getDate() {
        return this.date;
    }
    public State getState() {
        return this.state;
    }
    public String getDescription() {
        return this.getState().toString() + "\t\t" + this.getDate().toString() + "\t\t" + this.getType().toString();
    }
}
