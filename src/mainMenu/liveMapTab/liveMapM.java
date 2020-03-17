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
        list.add(new Map("Ali","Jenella","Freddie","Ellie"));
        list.add(new Map("Brandon","Andy","Dawid",""));
        list.add(new Map("Macy","Maxwell","",""));
        list.add(new Map("Chris","Erin","",""));
        list.add(new Map("Emily","Sam","",""));
        list.add(new Map("Daniel","Will","",""));
        list.add(new Map("Emilia","Talia","",""));
        list.add(new Map("Henry","","",""));
        list.add(new Map("Kiera","","",""));
        list.add(new Map("Miral","","",""));

         	
        //list.add(new Schedule("Of Human Bondage", "Somerset Maugham"));

        ObservableList data = FXCollections.observableList(list);

        return data;
    }
}
