package mainMenu.scheduleTab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SchedulingTabM {
    //model

    public ObservableList getInitialTableData() {

        List list = new ArrayList();
        list.add(new Schedule(1, 1, "sTAFF1", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule(1, 1, "sTAFF1", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule(1, 1, "sTAFF1", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule(1, 1, "sTAFF1", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule(1, 1, "sTAFF1", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule(1, 1, "sTAFF1", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule(1, 1, "sTAFF1", "","BOSS","michae;","john","bva","asf","ass"));
        //list.add(new Schedule("Of Human Bondage", "Somerset Maugham"));


        ObservableList data = FXCollections.observableList(list);

        return data;
    }
}
