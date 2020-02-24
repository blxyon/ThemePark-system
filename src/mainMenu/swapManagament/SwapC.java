package mainMenu.swapManagament;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SwapC implements Initializable {
    //table
    private SwapM modelSw;
    @FXML private TableView<Swap> SwapTable;
    @FXML private TableColumn<Swap, String> time;
    @FXML private TableColumn<Swap, String> T1;
    @FXML private TableColumn<Swap, String> T2;
    @FXML private TableColumn<Swap, String> T3;
    @FXML private TableColumn<Swap, String> T4;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        time.setCellValueFactory(new PropertyValueFactory<Swap, String>("time"));
        T1.setCellValueFactory(new PropertyValueFactory<Swap, String>("T1"));
        T2.setCellValueFactory(new PropertyValueFactory<Swap, String>("T2"));
        T3.setCellValueFactory(new PropertyValueFactory<Swap, String>("T3"));
        T4.setCellValueFactory(new PropertyValueFactory<Swap, String>("T4"));


        modelSw=new SwapM();
        ObservableList data = modelSw.getInitialTableData();
        SwapTable.setItems(data);
    }
}
