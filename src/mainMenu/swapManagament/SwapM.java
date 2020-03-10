package mainMenu.swapManagament;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SwapM {
    public ObservableList getInitialTableData() {

        List list = new ArrayList();
        list.add(new Swap("12:00", "Andy -> Max - VRS","Ali -> Brandon - NTR", "Jenella -> Will - VRS","Freddie -> Emily - Sky"));
        list.add(new Swap("12:30", "Max -> Erin - VRS","Brandon -> Macy - NTR", "Will -> Talia - VRS","Emily -> Henry - NTR"));
        list.add(new Swap("13:00", "Erin -> Mani - VRS","Macy -> Ed - NTR", "Talia -> Aprille - VRS","Henry -> Amber - NTR"));
        list.add(new Swap("13:30", "Mani -> Sam - VRS","Ed -> Chris - NTR", "Aprille -> Jenella - VRS","Amber -> Daniel - NTR"));
        list.add(new Swap("14:00", "Sam -> Andy - VRS","Chris -> Ali - NTR", "","Daniel -> Emilia - NTR"));
        list.add(new Swap("14:30", "","", "","Emilia -> Freddie - Sky"));


        ObservableList data = FXCollections.observableList(list);

        return data;
    }

}
