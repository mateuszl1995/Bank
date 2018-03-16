public class InterestZero implements Interest{
    @Override
    public float calculateInterest(BankProduct product) {
        return 0.0f;
    }
}
