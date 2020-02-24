import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainMenu.dbCreator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu/view/menu.fxml"));
        primaryStage.setTitle("Main menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        dbCreator db = new dbCreator("C:/Users/willd/Desktop/database");
        db.createNewDatabase();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
