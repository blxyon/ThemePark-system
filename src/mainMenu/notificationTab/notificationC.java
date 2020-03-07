package mainMenu.notificationTab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class notificationC {
    @FXML
    Button otherMessB;
    public void otherPop(javafx.event.ActionEvent actionEvent)
    {
        FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("mainMenu/view/otherMess.fxml"));
        Stage swapStage=new Stage();
        swapStage.initModality(Modality.WINDOW_MODAL);
        swapStage.initOwner(otherMessB.getScene().getWindow());

        Parent root;
        try {
            root = loader.load();
            otherMessC mC=loader.getController();
            //mC.setTerminalName(getTerminalName());

            swapStage.setTitle("OTHER MESSAGES");
            swapStage.setScene(new Scene(root));
            swapStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

}
