package carrb.jewelry;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

// класс окна администратора
public class AdminWindow {
    Stage stage = new Stage();

    public void showWindow() throws Exception{
        start(stage);
    }

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin.fxml")));
        primaryStage.setTitle("Кабинет администратора");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }
}
