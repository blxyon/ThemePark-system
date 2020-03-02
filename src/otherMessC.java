import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class otherMessC {
    @FXML private Button send;

    private String terminalName;


    public void setTerminalName(String terminalName)
    {
        this.terminalName=terminalName;
    }
    public void send()
    {
        System.out.println("hi "+terminalName);

    }


}
