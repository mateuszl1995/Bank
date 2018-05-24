package BankProduct;

import Interest.Interest;

public interface BankProductInterface {
    Interest getInterest();

    float getBalance();

    void calculateInterest();
}
