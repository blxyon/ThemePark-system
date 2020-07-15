import comms.RideTerminalBackend;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class otherMessC {
    @FXML private Button send;
    @FXML private TextField errorMess;
    private String terminalName;

    public void setTerminalName(String terminalName)
    {
        this.terminalName=terminalName;
    }
    
    public void send()
    {
        if(errorMess.getText()!=null && !errorMess.getText().equals("")) {
            System.out.println(errorMess.getText() + terminalName);
            RideTerminalBackend backendInstance = RideTerminalBackend.getInstance();
            backendInstance.sendAlert(errorMess.getText());
        }

    }

    
}
