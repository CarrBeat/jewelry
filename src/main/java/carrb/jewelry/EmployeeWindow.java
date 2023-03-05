package carrb.jewelry;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class EmployeeWindow {
    Stage stage = new Stage();

    public void showWindow() throws Exception{
        start(stage);
    }

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("employee.fxml")));
        primaryStage.setTitle("Кабинет продавца");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }
}
