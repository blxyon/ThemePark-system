package mainMenu.liveMapTab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainMenu.scheduleTab.Schedule;

import java.util.ArrayList;
import java.util.List;

public class liveMapM {
    //model

    public ObservableList getInitialTableData() {

        List list = new ArrayList();
        list.add(new Map("asf","saf","saf","asf"));
        //list.add(new Schedule("Of Human Bondage", "Somerset Maugham"));

        ObservableList data = FXCollections.observableList(list);

        return data;
    }
}
