package Interest;

import BankProduct.BankProductAccount;

public class InterestZero implements Interest{


    @Override
    public float calculateInterest(BankProductAccount product) {
        return 0;
    }
}
