package carrb.jewelry;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Authorization extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Authorization.class.getResource("authorize.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 350);
        stage.setTitle("Авторизация");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static String authorization(String inLogin) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        // метод авторизации (В БД)
        Class.forName(Common.driverUrl).getDeclaredConstructor().newInstance();
        String password;
        String role;
        try (Connection connection = DriverManager.getConnection(Common.serverUrl)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT password, role FROM authData where login = '"
                    + inLogin + "'");
            resultSet.next();
            password = resultSet.getString(1);
            role = resultSet.getString(2);
            return (role + "|" + password);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return "incorrect login";
        }
    }
}