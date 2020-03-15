package mainMenu.scheduleTab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SchedulingTabM {
    //model

    public ObservableList getInitialTableData() {

        List list = new ArrayList();
        list.add(new Schedule("Ninjago", "Operator", "Brandon", "Brandon","Brandon","Ali","Ali","Ali","Ali","Chris"));
        list.add(new Schedule("Ninjago", "CCTV", "Macy", "Macy","Macy","Macy","Brandon","Brandon","Brandon","Brandon"));
        list.add(new Schedule("Ninjago", "Load 1", "Ed", "Ed","Ed","Ed","Ed","Macy","Macy","Macy"));
        list.add(new Schedule("Ninjago", "Load 2", "Chris", "Chris","Chris","Chris","Chris","Chris","Ed","Ed"));
        list.add(new Schedule("Ninjago", "Preload", "Henry", "Henry","Henry","Henry","Emily","Emily","Emily","Emily"));
        list.add(new Schedule("Ninjago", "Offload 1", "Daniel", "Daniel","Daniel","Daniel","Daniel","Daniel","Amber","Amber"));
        list.add(new Schedule("Ninjago", "Offload 2", "Emilia", "Emilia","Emilia","Emilia","Emilia","Emilia","Emilia","Amber"));
        list.add(new Schedule("Ninjago", "QBOT", "Amber", "Amber","Amber","Amber","Amber","Henry","Henry","Henry"));
        list.add(new Schedule("Ninjago", "Glasses Cleaner", "Ellie", "Ellie","Ellie","Ellie","Kiera","Kiera","Kiera","Kiera"));
        list.add(new Schedule("Ninjago", "Glasses Distributor", "", "","","","","Miral","Miral","Miral"));
        //list.add(new Schedule("Of Human Bondage", "Somerset Maugham"));
        list.add(new Schedule("Viking", "Operator", "Will", "Will","Will","Jenella","Jenella","Jenella","Aprille","Aprille"));
        list.add(new Schedule("Viking", "Baywatch", "Maxwell", "Maxwell","Maxwell","Andy","Andy","Andy","Andy","Sam"));
        list.add(new Schedule("Viking", "Preload", "Erin", "Erin","Erin","Erin","Maxwell","Maxwell","Maxwell","Maxwell"));
        list.add(new Schedule("Viking", "Load 1", "Mani", "Mani","Mani","Mani","Mani","Erin","Erin","Erin"));
        list.add(new Schedule("Viking", "Offload", "Sam", "Sam","Sam","Sam","Sam","Sam","Mani","Mani"));
        list.add(new Schedule("Viking", "Height Check", "Talia", "Talia","Talia","Talia","Will","Will","Will","Will"));
        list.add(new Schedule("Viking", "QBOT", "Aprille", "Aprille","Aprille","Aprille","Aprille","Talia","Talia","Talia"));

        list.add(new Schedule("Destiny's", "Operator", "Kiera", "Kiera","Kiera","Michael","Michael","Ellie","Ellie","Ellie"));
        
        list.add(new Schedule("Sky Rider", "Operator", "Emily", "Emily","Emily","Freddie","Freddie","Freddie","Freddie","Freddie"));
        list.add(new Schedule("Sky Rider", "Offload", "Miral", "Miral","Miral","Miral","Dawid","Dawid","Dawid","Dawid"));

        
        ObservableList data = FXCollections.observableList(list);

        return data;
    }
}
