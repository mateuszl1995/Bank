import java.util.Date;

public abstract class BankOperation implements BankOperationInterface {

    BankOperation(BankProductInterface productSource){
        this.productSource = productSource;
    }

    protected Date date;
    protected String type;
    protected String description;
    protected BankProductInterface productSource;


    public void execute(){
        date = new Date();
        productSource.historyAdd(this);
    }
}
