public class BankOperationPayCreditRate extends BankOperation {
    BankProductCredit credit;
    BankOperationPayCreditRate(BankProductCredit credit) {
        super(credit.getAccount());
        this.credit = credit;
    }

    @Override
    public Type getType() {
        return Type.PAY_CREDIT_RATE;
    }

    @Override
    protected State executeOperation() {
        return State.FAIL;
    }
}
