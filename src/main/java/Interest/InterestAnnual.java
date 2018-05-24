package Interest;

import BankProduct.BankProductAccount;

public class InterestAnnual implements Interest {
    private float percentage; // TODO: change to more precise data-type
    public InterestAnnual(float percentage) {
        this.percentage = percentage/100;
    }

    @Override
    public float calculateInterest(BankProductAccount product) {
       float balance = product.getBalance();
       return percentage*product.getBalance();
    }


}
