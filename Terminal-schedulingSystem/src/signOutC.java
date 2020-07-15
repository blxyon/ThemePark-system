import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class signOutC {

    @FXML
    Label label;
    @FXML
    Button signOutB;
    @FXML
    ListView list;
    public void setLabel(String s)
    {
        label.setText(s);
    }
    public void setListView(ListView listView)
    {
        list=listView;
    }
    public void signOut(javafx.event.ActionEvent actionEvent) {
        System.out.println(list.getSelectionModel().getSelectedItem());
        list.getItems().remove(list.getSelectionModel().getSelectedItem());
        Stage stage = (Stage) signOutB.getScene().getWindow();
        stage.close();
    }
}
