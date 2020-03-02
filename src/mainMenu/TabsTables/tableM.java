package mainMenu.TabsTables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainMenu.swapManagament.Swap;

import java.util.ArrayList;
import java.util.List;


public class tableM {
    public ObservableList getInitialTableData() {

        List list = new ArrayList();
        list.add(new tableTab("cat","Hannan","9:00","10:00"));

        ObservableList data = FXCollections.observableList(list);

        return data;
    }
}
