package mainMenu.swapManagament;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SwapM {
    public ObservableList getInitialTableData() {

        List list = new ArrayList();
        list.add(new Swap(9, "S1->P1","S2->P2", "S1->P1","S2->P2"));
        list.add(new Swap(10, "S1->P1","S2->P2", "S1->P1","S2->P2"));
        list.add(new Swap(11, "S1->P1","S2->P2", "S1->P1","S2->P2"));
        list.add(new Swap(12, "S1->P1","S2->P2", "S1->P1","S2->P2"));


        //list.add(new Schedule("Of Human Bondage", "Somerset Maugham"));


        ObservableList data = FXCollections.observableList(list);

        return data;
    }
}
