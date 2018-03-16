public class BankOperationInterest extends BankOperation {

    BankProduct bankProduct;
/* TODO:
    BankOperationInterest(BankProduct bankProduct) {
        // TODO: super(productSource);
    }
*/

    @Override
    protected State executeOperation() {

    }

    @Override
    public Type getType() {
        return Type.INTEREST;
    }
}
