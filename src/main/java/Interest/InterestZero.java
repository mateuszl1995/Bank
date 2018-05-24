package Interest;

import BankProduct.BankProductAccount;
import BankProduct.Credit;
import BankProduct.Investment;

public class InterestZero implements Interest{


    @Override
    public float calculateInterest(BankProductAccount product) {
        return 0;
    }
    public float calculateInterest(Credit credit) {
        return 0;
    }
    public float caltulateInterest(Investment investment) {
        return 0;
    }
}
