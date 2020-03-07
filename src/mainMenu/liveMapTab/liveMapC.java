package mainMenu.liveMapTab;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mainMenu.scheduleTab.Schedule;
import mainMenu.scheduleTab.SchedulingTabM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class liveMapC implements Initializable {
    //controller

    //table
    @FXML private TableView<Map> liveTermTable;
    @FXML private TableColumn<Map, String> vCo;
    @FXML private TableColumn<Map, String> nCo;
    @FXML private TableColumn<Map, String> sCo;
    @FXML private TableColumn<Map, String> dCo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        liveTermTable.setEditable(true);
        // position.setCellFactory(TextFieldTableCell.forTableColumn());

        vCo.setCellValueFactory(new PropertyValueFactory<Map, String>("vCo"));
        nCo.setCellValueFactory(new PropertyValueFactory<Map, String>("nCo"));
        sCo.setCellValueFactory(new PropertyValueFactory<Map, String>("sCo"));
        dCo.setCellValueFactory(new PropertyValueFactory<Map, String>("dCo"));

        liveMapM modelLiveMap=new liveMapM();
        ObservableList data = modelLiveMap.getInitialTableData();
        liveTermTable.setItems(data);
    }
}
