import java.util.Date;

public abstract class BankOperation implements BankOperationInterface {
    BankOperation(BankProduct productSource){
        this.productSource = productSource;
        this.state = State.NEW;
    }

    protected State state;
    protected Date date;
    protected Type type;
    protected String description;
    protected BankProduct productSource;


    public void execute() {
        try {
            state = executeOperation();
            date = new Date();
            productSource.historyAdd(this);
        } catch (Exception e) {
            e.printStackTrace();
            state = State.FAIL;
        }
    }

    protected abstract State executeOperation();

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
