package Interest;

import BankProduct.BankProductAccount;
import BankProduct.Credit;
import BankProduct.Investment;

public class InterestAnnual implements Interest {
    private float percentage; // TODO: change to more precise data-type
    public InterestAnnual(float percentage) {
        this.percentage = percentage/100;
    }

    @Override
    public float calculateInterest(BankProductAccount product) {
       return percentage*product.getBalance();
    }

    @Override
    public float calculateInterest(Credit credit) {
        return percentage*credit.getBalance();
    }

    @Override
    public float caltulateInterest(Investment investment) {
        return percentage*investment.getBalance();
    }


}
