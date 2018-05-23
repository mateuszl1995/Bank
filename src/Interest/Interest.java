package Interest;//interest == odsetki;
//liabilities == zadłużenie
import BankProduct.BankProductInterface;

public interface Interest {
    float calculateInterest(BankProductInterface product);
}
