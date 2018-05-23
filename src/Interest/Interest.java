package Interest;//interest == odsetki;
//liabilities == zadłużenie
import BankProduct.BankProductAccount;

public interface Interest {
    float calculateInterest(BankProductAccount product);
}
