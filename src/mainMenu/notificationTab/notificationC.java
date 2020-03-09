package mainMenu.notificationTab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class notificationC {
    @FXML private Button send;
    @FXML private TextField errorMess;

    public void send() {
        System.out.println(errorMess.getText());
        //RideTerminalBackend backendInstance = RideTerminalBackend.getInstance();
        //backendInstance.sendAlert(errorMess.getText());

        }
    }
