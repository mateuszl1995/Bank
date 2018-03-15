import java.util.Date;

public interface BankOperationInterface {
    String getDescription();
    Date getDate();
    String getType();
    boolean execute();
}
