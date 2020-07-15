package mainMenu.swapManagament;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

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
    @FXML private Button removeB;
    @FXML private Button addB;
    @FXML private TextField vF;
    @FXML private TextField nF;
    @FXML private TextField timeF;
    @FXML private TextField dF;
    @FXML private TextField sF;


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
        SwapTable.setEditable(true);
        time.setCellFactory(TextFieldTableCell.forTableColumn());
        T1.setCellFactory(TextFieldTableCell.forTableColumn());
        T2.setCellFactory(TextFieldTableCell.forTableColumn());
        T3.setCellFactory(TextFieldTableCell.forTableColumn());
        T4.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void removeFromTable(ActionEvent actionEvent) {
        ObservableList<Swap> allSwaps, selectedSwap;
        allSwaps=SwapTable.getItems();
        selectedSwap=SwapTable.getSelectionModel().getSelectedItems();
        selectedSwap.forEach(allSwaps::remove);
    }

    public void addToTable(ActionEvent actionEvent) {
        Swap newSwap=new Swap(timeF.getText(),vF.getText(),nF.getText(),sF.getText(),dF.getText());
        SwapTable.getItems().add(newSwap);
    }
}
