
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class controller {
    @FXML Button otherMessB;
    @FXML Text terminalNameL;

    public String getTerminalName()
    {
        try
        {
            System.out.println(terminalNameL.getText());
            return terminalNameL.getText();
        }catch (NullPointerException e) {
            e.printStackTrace();
            return "noName";

        }

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

}
