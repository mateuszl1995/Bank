package Interest;//interest == odsetki;
//liabilities == zadłużenie
import BankProduct.BankProductAccount;
import BankProduct.Credit;
import BankProduct.Investment;

public interface Interest {
    float calculateInterest(BankProductAccount product);
    float calculateInterest(Credit credit);
    float caltulateInterest(Investment investment);
}
