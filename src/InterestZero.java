public class InterestZero implements Interest{


    @Override
    public float calculateInterest(BankProductInterface product) {
        return 0;
    }
}
