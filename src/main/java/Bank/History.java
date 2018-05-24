package Bank;

import BankOperation.BankOperationInterface;

import java.util.ArrayList;
import java.util.List;

public class History {
    public History(){}

    public History(History toClone){
        for (int i=0; i<=toClone.size(); i++ ){
            this.add(toClone.get(i));
        }
    }


    private List<BankOperationInterface> list = new ArrayList<>();
    // <-- takie coś możnaby zrobić zamiast historii banku jako obiekt. minusem jest ze bank moglby byc tylko jeden
    //private static List<BankOperation.BankOperation> bankList = new ArrayList<>();

    public void add(BankOperationInterface operation) {
        list.add(operation);
    }

    public List<BankOperationInterface> getList() {
        return list;
    }

    public BankOperationInterface get(int index) {
        return list.get(index);
    }

    public int size(){
        return list.size();
    }
}
