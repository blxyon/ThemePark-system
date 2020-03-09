
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import comms.RideTerminalBackend;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class controller implements Initializable {
    @FXML Button otherMessB;
    @FXML Text terminalNameL;


//get all the buttons/tables from all windows here
    
    RideTerminalBackend backendInstance;

    @FXML private TableView<Staff> OperatorTable;
    @FXML private TableColumn<Staff, String> OCategory;
    @FXML private TableColumn<Staff, String> OName;
    @FXML private TableColumn<Staff, String> OStartT;
    @FXML private TableColumn<Staff, String> OEndT;
    @FXML private TableView<Staff> AttendantPTable;
    @FXML private TableColumn<Staff, String> APCategory;
    @FXML private TableColumn<Staff, String> APName;
    @FXML private TableColumn<Staff, String> APStartT;
    @FXML private TableColumn<Staff, String> APEndT;
    @FXML private TableView<Staff> AttendantSTable;
    @FXML private TableColumn<Staff, String> ASCategory;
    @FXML private TableColumn<Staff, String> ASName;
    @FXML private TableColumn<Staff, String> ASStartT;
    @FXML private TableColumn<Staff, String> ASEndT;
    @FXML private TableView<Staff> ServiceTable;
    @FXML private TableColumn<Staff, String> SCategory;
    @FXML private TableColumn<Staff, String> SName;
    @FXML private TableColumn<Staff, String> SStartT;
    @FXML private TableColumn<Staff, String> SEndT;


    @FXML private Button signInB;
    @FXML private Button signOutB;
    @FXML private ListView staffLoggedList;


    Integer indexStaffArr=0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //initialization
        backendInstance = RideTerminalBackend.getInstance();
        System.out.println("initializing");

        OCategory.setCellValueFactory(new PropertyValueFactory<Staff, String>("Category"));
        OName.setCellValueFactory(new PropertyValueFactory<Staff, String>("Name"));
        OStartT.setCellValueFactory(new PropertyValueFactory<Staff, String>("StartT"));
        OEndT.setCellValueFactory(new PropertyValueFactory<Staff, String>("EndT"));

        APCategory.setCellValueFactory(new PropertyValueFactory<Staff, String>("Category"));
        APName.setCellValueFactory(new PropertyValueFactory<Staff, String>("Name"));
        APStartT.setCellValueFactory(new PropertyValueFactory<Staff, String>("StartT"));
        APEndT.setCellValueFactory(new PropertyValueFactory<Staff, String>("EndT"));

        ASCategory.setCellValueFactory(new PropertyValueFactory<Staff, String>("Category"));
        ASName.setCellValueFactory(new PropertyValueFactory<Staff, String>("Name"));
        ASStartT.setCellValueFactory(new PropertyValueFactory<Staff, String>("StartT"));
        ASEndT.setCellValueFactory(new PropertyValueFactory<Staff, String>("EndT"));

        SCategory.setCellValueFactory(new PropertyValueFactory<Staff, String>("Category"));
        SName.setCellValueFactory(new PropertyValueFactory<Staff, String>("Name"));
        SStartT.setCellValueFactory(new PropertyValueFactory<Staff, String>("StartT"));
        SEndT.setCellValueFactory(new PropertyValueFactory<Staff, String>("EndT"));

        ObservableList dataO=getInitialTableDataO();
        ObservableList dataAP=getInitialTableDataAP();
        ObservableList dataAS=getInitialTableDataAS();
        ObservableList dataS=getInitialTableDataS();

        OperatorTable.setItems(dataO);
        AttendantPTable.setItems(dataAP);
        AttendantSTable.setItems(dataAS);
        ServiceTable.setItems(dataS);

        OperatorTable.setEditable(true);
        OCategory.setCellFactory(TextFieldTableCell.forTableColumn());
        OName.setCellFactory(TextFieldTableCell.forTableColumn());
        OStartT.setCellFactory(TextFieldTableCell.forTableColumn());
        OEndT.setCellFactory(TextFieldTableCell.forTableColumn());

        AttendantPTable.setEditable(true);
        APCategory.setCellFactory(TextFieldTableCell.forTableColumn());
        APName.setCellFactory(TextFieldTableCell.forTableColumn());
        APStartT.setCellFactory(TextFieldTableCell.forTableColumn());
        APEndT.setCellFactory(TextFieldTableCell.forTableColumn());

        AttendantSTable.setEditable(true);
        ASCategory.setCellFactory(TextFieldTableCell.forTableColumn());
        ASName.setCellFactory(TextFieldTableCell.forTableColumn());
        ASStartT.setCellFactory(TextFieldTableCell.forTableColumn());
        ASEndT.setCellFactory(TextFieldTableCell.forTableColumn());

        ServiceTable.setEditable(true);
        SCategory.setCellFactory(TextFieldTableCell.forTableColumn());
        SName.setCellFactory(TextFieldTableCell.forTableColumn());
        SStartT.setCellFactory(TextFieldTableCell.forTableColumn());
        SEndT.setCellFactory(TextFieldTableCell.forTableColumn());
    }


    public String getTerminalName()
    {
        try
        {
            return terminalNameL.getText();
        }catch (NullPointerException e) {
            e.printStackTrace();
            return "noName"; }
    }
    public void callBreak(){
    	backendInstance.sendAlert("break");
    }
    
    public void callFire(){
    	backendInstance.sendAlert("fire");
    }
    
    public void callInjury(){
    	backendInstance.sendAlert("injury");
    }
    
    public void callSec(){
    	backendInstance.sendAlert("security");
    }
    
    public void callMissing(){
    	backendInstance.sendAlert("missing");
    }

    public void otherPop()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("main/views/otherMess.fxml"));
        Stage swapStage=new Stage();
        swapStage.initModality(Modality.WINDOW_MODAL);
        swapStage.initOwner(otherMessB.getScene().getWindow());

        Parent root;
        try {
            root = loader.load();
            otherMessC mC=loader.getController();
            mC.setTerminalName(getTerminalName());

            swapStage.setTitle("OTHER MESSAGES");
            swapStage.setScene(new Scene(root));
            swapStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }

    }


    public ObservableList getInitialTableDataO() {

        List list = new ArrayList();
        Staff p=new Staff("asf","hannan","9","10","Viking's River Splash");
        Staff p2=new Staff("asf","Will","9","10","Ninjago");
        Staff[] arr={p,p2};
        for(int i=0;i<arr.length;i++) {
            if ((arr[i].getRide()).equals(getTerminalName())) {
                list.add(arr[i]);
            }
        }

        ObservableList data = FXCollections.observableList(list);

        return data;
    }
    public ObservableList getInitialTableDataAP() {

        List list = new ArrayList();
        Staff p=new Staff("asf","hannan2222","9","10","Viking's River Splash");
        Staff p2=new Staff("asf","Will2222222","9","10","Ninjago");
        Staff[] arr={p,p2};
        for(int i=0;i<arr.length;i++) {
            if ((arr[i].getRide()).equals(getTerminalName())) {
                list.add(arr[i]);
            }
        }
        ObservableList data = FXCollections.observableList(list);

        return data;
    }
    public ObservableList getInitialTableDataAS() {

        List list = new ArrayList();
        Staff p=new Staff("asf","hannan3333333","9","10","Viking's River Splash");
        Staff p2=new Staff("asf","Will3333333333","9","10","Ninjago");
        Staff[] arr={p,p2};
        for(int i=0;i<arr.length;i++) {
            if ((arr[i].getRide()).equals(getTerminalName())) {
                list.add(arr[i]);
            }
        }

        ObservableList data = FXCollections.observableList(list);

        return data;
    }
    public ObservableList getInitialTableDataS() {

        List list = new ArrayList();
        Staff p=new Staff("asf","hannan33333344444","9","10","Viking's River Splash");
        Staff p2=new Staff("asf","Will4444444","9","10","Ninjago");
        Staff[] arr={p,p2};

        for(int i=0;i<arr.length;i++) {
            if ((arr[i].getRide()).equals(getTerminalName())) {
                list.add(arr[i]);
            }
        }
        ObservableList data = FXCollections.observableList(list);

        return data;
    }


    public void signOut(javafx.event.ActionEvent actionEvent) {
        if(staffLoggedList.getSelectionModel().getSelectedItem()!=null) {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("main/views/SignOut.fxml"));
            Stage swapStage = new Stage();
            swapStage.initModality(Modality.WINDOW_MODAL);
            swapStage.initOwner(signOutB.getScene().getWindow());

            Parent root;
            try {
                root = loader.load();
                signOutC sC = loader.getController();
                sC.setListView(staffLoggedList);
                sC.setLabel("Please enter the Pin for : "+staffLoggedList.getSelectionModel().getSelectedItem());

                swapStage.setTitle("Staff Sign OUT");
                swapStage.setScene(new Scene(root));
                swapStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void signIn(ActionEvent actionEvent) {
        FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("main/views/LogIn.fxml"));
        Stage swapStage=new Stage();
        swapStage.initModality(Modality.WINDOW_MODAL);
        swapStage.initOwner(signInB.getScene().getWindow());

        Parent root;
        try {
            root = loader.load();
            logInC lC=loader.getController();
            lC.setList(staffLoggedList);

            swapStage.setTitle("Staff Sign IN");
            swapStage.setScene(new Scene(root));
            swapStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
