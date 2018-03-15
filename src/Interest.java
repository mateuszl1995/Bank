//interest == odsetki;
//liabilities == zadłużenie



public interface Interest {
    void naliczOdsetki(BankProductInterface product);
    void countLiabilities(BankProductInterface product);

}
