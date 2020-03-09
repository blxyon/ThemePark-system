package mainMenu.notificationTab;

import comms.ManagerTerminalBackend;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class notificationC {
    @FXML private Button send;
    @FXML private TextField errorMess;

    public void send() {
        System.out.println(errorMess.getText());
        
      
        ManagerTerminalBackend backendInstance = ManagerTerminalBackend.getInstance();
        backendInstance.sendAlert(errorMess.getText());

        }
    }
