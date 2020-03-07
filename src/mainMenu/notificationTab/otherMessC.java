package mainMenu.notificationTab;

import comms.RideTerminalBackend;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class otherMessC {
    @FXML private Button send;
    @FXML private TextField errorMess;

    public void send()
    {
        System.out.println(errorMess.getText());
        //RideTerminalBackend backendInstance = RideTerminalBackend.getInstance();
        //backendInstance.sendAlert(errorMess.getText());
    }


}
