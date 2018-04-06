public class InterestAnnual implements Interest {
    private float percentage; // TODO: change to more precise data-type
    InterestAnnual(float percentage) {
        this.percentage = percentage/100;
    }

    @Override
    public void calculateInterest(BankProduct product) {
       float balance = product.getBalance();
       product.setBalance(percentage*product.getBalance());
    }
}
