import comms.ManagerTerminalBackend;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainMenu.dbCreator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    	//ManagerTerminalBackend backendInstance = ManagerTerminalBackend.getInstance();
    	//Thread backendThread = new Thread(backendInstance);
    	//backendThread.start();
    	
        Parent root = FXMLLoader.load(getClass().getResource("LogIn/view/LogIn.fxml"));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        //dbCreator db = new dbCreator("tempdb");
        //db.createNewDatabase();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
