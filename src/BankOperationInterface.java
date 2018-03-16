import java.util.Date;

public interface BankOperationInterface {
    public enum Type { DEPOSIT, WITHDRAW, TRANSFER, CREATE_INVESTMENT }
    public enum State {NEW, SUCCESS, FAIL}
    String getDescription();
    Date getDate();
    Type getType();
    State getState();
    void execute();
}
