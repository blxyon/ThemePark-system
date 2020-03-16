

import comms.RideTerminalBackend;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //TO OPEN ONE TERMINAL JUST UNCOMMENT ONE OF THE 4 BELLOW LINES RESPECTIVELY

        //init backend
        RideTerminalBackend backendInstance = RideTerminalBackend.getInstance();

        
        //FXMLLoader loader=new FXMLLoader(getClass().getResource("main/views/ninjago.fxml"));
        FXMLLoader loader=new FXMLLoader(getClass().getResource("main/views/destiny.fxml"));
        //FXMLLoader loader=new FXMLLoader(getClass().getResource("main/views/skyrider.fxml"));
        //FXMLLoader loader=new FXMLLoader(getClass().getResource("main/views/vikings.fxml"));

        Parent root=loader.load();

        
        primaryStage.setTitle("Terminal control");
        primaryStage.setScene(new Scene(root));
        controller c=(controller)(loader.getController());
        String tName=c.getTerminalName();
        backendInstance.setName(tName);
        Thread backendThread = new Thread(backendInstance);
        backendThread.start();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
