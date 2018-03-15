import java.util.ArrayList;
import java.util.List;

public class History {
    History(){}

    History(History toClone){
        for (int i=0; i<=toClone.size(); i++ ){
            this.add(toClone.get(i));
        }
    }


    private List<BankOperation> list = new ArrayList<>();
    // <-- takie coś możnaby zrobić zamiast historii banku jako obiekt. minusem jest ze bank moglby byc tylko jeden
    //private static List<BankOperation> bankList = new ArrayList<>();

    public void add(BankOperation operation) {
        list.add(operation);
    }

    public BankOperation get(int index) {
        return list.get(index);
    }

    public int size(){
        return list.size();
    }
}
