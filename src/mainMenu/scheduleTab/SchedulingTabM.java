package mainMenu.scheduleTab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SchedulingTabM {
    //model

    public ObservableList getInitialTableData() {

        List list = new ArrayList();
        list.add(new Schedule("Ninjago", "Operator", "Brandon", "Brandon","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Ninjago", "CCTV", "Macy", "Macy","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Ninjago", "Load 1", "Ed", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Ninjago", "Load 2", "Chris", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Ninjago", "Preload", "Henry", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Ninjago", "Offload 1", "Daniel", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Ninjago", "Offload 2", "Emilia", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Ninjago", "QBOT", "Amber", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Ninjago", "Glasses Cleaner", "Ellie", "","BOSS","michae;","john","bva","asf","ass"));
        //list.add(new Schedule("Of Human Bondage", "Somerset Maugham"));
        list.add(new Schedule("Viking", "Operator", "Will", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Viking", "Baywatch", "Maxwell", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Viking", "Preload", "Erin", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Viking", "Load 1", "Mani", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Viking", "Offload", "Sam", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Viking", "Height Check", "Talia", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Viking", "QBOT", "Aprille", "","BOSS","michae;","john","bva","asf","ass"));

        list.add(new Schedule("Destiny's", "Operator", "Kiera", "","BOSS","michae;","john","bva","asf","ass"));
        
        list.add(new Schedule("Sky Rider", "Operator", "Emily", "","BOSS","michae;","john","bva","asf","ass"));
        list.add(new Schedule("Sky Rider", "Offload", "Miral", "","BOSS","michae;","john","bva","asf","ass"));

        
        ObservableList data = FXCollections.observableList(list);

        return data;
    }
}
