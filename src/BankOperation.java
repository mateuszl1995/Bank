import java.util.Date;

public abstract class BankOperation implements BankOperationInterface {

    BankOperation(BankProduct productSource){
        this.productSource = productSource;
    }

    protected Date date;
    protected String type;
    protected String description;
    protected BankProduct productSource;

    public boolean execute(){
        date = new Date();
        return true;
    }
}
