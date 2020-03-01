package LogIn;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class logInC {

    @FXML
    TextField userF;
    @FXML
    PasswordField passF;
    @FXML
    Button loginB;


    public void logIn()
    {
        Stage stage = (Stage) passF.getScene().getWindow();
        stage.close();
        FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("mainMenu/view/Menu.fxml"));
        Parent root;
        try {
            root = loader.load();
            //MenuController mC=loader.getController();
            //mC.setCreds(user, pass);
            //mC.setDBC(dbc);

            Stage menuStage = new Stage();
            menuStage.setTitle("Menu");
            menuStage.setScene(new Scene(root));
            menuStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //FXMLLoader.load(getClass().getClassLoader().getResource("Menu/Menu.fxml"));

    }
}
