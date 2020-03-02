package mainMenu.TabsTables;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainMenu.swapManagament.Swap;
import mainMenu.swapManagament.SwapM;

import java.net.URL;
import java.util.ResourceBundle;

public class vikingTab implements Initializable {
    //table
    private tableM modelV;
    @FXML private TableView<tableTab> VOpTable;
    @FXML private TableColumn<tableTab, String> Ocat;
    @FXML private TableColumn<tableTab, String> Oname;
    @FXML private TableColumn<tableTab, String> Ostart;
    @FXML private TableColumn<tableTab, String> Oend;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ocat.setCellValueFactory(new PropertyValueFactory<tableTab, String>("Category"));
        Oname.setCellValueFactory(new PropertyValueFactory<tableTab, String>("Name"));
        Ostart.setCellValueFactory(new PropertyValueFactory<tableTab, String>("Start"));
        Oend.setCellValueFactory(new PropertyValueFactory<tableTab, String>("End"));


        modelV=new tableM();
        ObservableList data = modelV.getInitialTableData();
        VOpTable.setItems(data);
    }
}
