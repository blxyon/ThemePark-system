package mainMenu.scheduleTab;

import javafx.collections.FXCollections;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class SchedulingTabC implements Initializable {
    //controller
    SchedulingTabM modelSc;
    @FXML
    private Label label;
    @FXML
    private Button swapsM;
    @FXML
    private Button printing;
    @FXML
    private Button logOut;

    //table
    @FXML private TableView<Schedule> scheduleTable;
    @FXML private TableColumn<Schedule, Integer> position;
    @FXML private TableColumn<Schedule, Integer> ride;
    @FXML private TableColumn<Schedule, String> st1;
    @FXML private TableColumn<Schedule, String> st2;
    @FXML private TableColumn<Schedule, String> st3;
    @FXML private TableColumn<Schedule, String> st4;
    @FXML private TableColumn<Schedule, String> st5;
    @FXML private TableColumn<Schedule, String> st6;
    @FXML private TableColumn<Schedule, String> st7;
    @FXML private TableColumn<Schedule, String> st8;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        position.setCellValueFactory(new PropertyValueFactory<Schedule, Integer>("position"));
        ride.setCellValueFactory(new PropertyValueFactory<Schedule, Integer>("ride"));
        st1.setCellValueFactory(new PropertyValueFactory<Schedule, String>("st1"));
        st1.setCellValueFactory(new PropertyValueFactory<Schedule, String>("st2"));
        st3.setCellValueFactory(new PropertyValueFactory<Schedule, String>("st3"));
        st4.setCellValueFactory(new PropertyValueFactory<Schedule, String>("st4"));
        st5.setCellValueFactory(new PropertyValueFactory<Schedule, String>("st5"));
        st6.setCellValueFactory(new PropertyValueFactory<Schedule, String>("st6"));
        st7.setCellValueFactory(new PropertyValueFactory<Schedule, String>("st7"));
        st8.setCellValueFactory(new PropertyValueFactory<Schedule, String>("st8"));

        modelSc=new SchedulingTabM();
        ObservableList data = modelSc.getInitialTableData();
        scheduleTable.setItems(data);
    }
    public void schedule()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("mainMenu/view/swapping.fxml"));
        Stage swapStage=new Stage();
        swapStage.initModality(Modality.WINDOW_MODAL);
        swapStage.initOwner(scheduleTable.getScene().getWindow());

        Parent root;
        try {
            root = loader.load();
            swapStage.setTitle("Swapping management");
            swapStage.setScene(new Scene(root));
            swapStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printOut()
    {
        System.out.println("print");

    }
}
