import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class logInC {

    @FXML
    TextField userF;
    @FXML
    PasswordField passF;
    @FXML
    Button loginB;
    @FXML
    ListView list;

    public void setList(ListView list)
    {
        this.list=list;
    }

    public void logIn()
    {
        if(userF.getText()!=null && !userF.getText().equals("")) {
            Stage stage = (Stage) passF.getScene().getWindow();
            stage.close();
            //FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("mainMenu/view/menu.fxml"));
            list.getItems().add(userF.getText());
        }

    }
}
