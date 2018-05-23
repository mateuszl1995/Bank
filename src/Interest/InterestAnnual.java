package Interest;

import BankProduct.BankProductInterface;

public class InterestAnnual implements Interest {
    private float percentage; // TODO: change to more precise data-type
    InterestAnnual(float percentage) {
        this.percentage = percentage/100;
    }

    @Override
    public float calculateInterest(BankProductInterface product) {
       float balance = product.getBalance();
       return percentage*product.getBalance();
    }


}
