public class InterestAnnual implements Interest {
    private float percentage; // TODO: change to more precise data-type
    InterestAnnual(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public float calculateInterest(BankProduct product) {
        float balance = product.getBalance();
        return percentage*balance / 100;
    }
}
