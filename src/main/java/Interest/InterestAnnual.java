package Interest;

import BankProduct.BankProductInterface;

public class InterestAnnual implements Interest {
    private float percentage; // TODO: change to more precise data-type
    public InterestAnnual(float percentage) {
        this.percentage = percentage/100;
    }

    @Override
    public float calculateInterest(BankProductInterface product) {
       return percentage*product.getBalance();
    }



}
