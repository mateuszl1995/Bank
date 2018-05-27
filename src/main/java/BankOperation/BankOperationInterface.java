package BankOperation;

import BankProduct.BankProductAccount;
import BankProduct.Decorators.BankProductAccountWithDebit;

import java.util.Date;

public interface BankOperationInterface {
    public enum Type { DEPOSIT, WITHDRAW, TRANSFER, CREATE_INVESTMENT, BREAK_INVESTMENT, CREATE_CREDIT, CREDIT_PAY, INTEREST, END_INVESTMENT }
    public enum State {NEW, SUCCESS, FAIL}
    public class DoubleExecutionException extends Exception { }

    String getDescription();
    Date getDate();
    Type getType();
    State getState();
    void execute() throws DoubleExecutionException, BankProductAccountWithDebit.NotEnoughMoneyException;
    void setProductDestination(BankProductAccount productDestination);
    BankProductAccount getProductSource();
    Long getDestinationNumber();
}
