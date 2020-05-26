package FTD_Project;

import FTD_Project.Controller.KaartspelController;
import FTD_Project.Model.Kaartspel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        
        Kaartspel model = new Kaartspel();
        // FXML View
        FXMLLoader lader = new FXMLLoader(getClass().getResource("KaartspelFXMLView.fxml"));
        Parent root = lader.load();
        
        // KaartspelController
        KaartspelController controller = lader.getController();
        
        // hoofdvenster
        Scene scene = new Scene(root, 1300, 700);
        stage.getIcons().add(new Image("/images/iconFTD.png"));
        stage.setScene(scene);
        stage.setTitle("FTD!");
        stage.setResizable(false);        
        stage.show();
        }


    public static void main(String[] args) {
        launch(args);
    }
}
