package carrb.jewelry;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AuthorizationController {
    @FXML
    private Label welcomeText;
    @FXML private Button enterButton;
    @FXML private TextField loginField;
    @FXML private TextField passwordField;
    @FXML private Label warningLabel;
    private String authMethRes; // результат работы метода
    public static String login; // для хранения обработанного номера телефона

    @FXML
    void initialize(){

        enterButton.setOnAction(event -> { // нажатие пнопки "Войти"
            warningLabel.setText("");
                        if (!loginField.getText().equals("") & !passwordField.getText().equals("")) {
                                    try { // обращение к методу авторизации
                                        authMethRes = Authorization.authorization(loginField.getText());
                                        if (authMethRes.equals("incorrect login")){
                                            warningLabel.setText("Неверный логин!");
                                            loginField.setText("");
                                        } else {
                                            if (authMethRes.substring(authMethRes.indexOf("|") + 1)
                                                    .equals(passwordField.getText())){
                                                switch (authMethRes.substring(0, authMethRes.indexOf("|"))){
                                                    case "admin":
                                                        openAdminWindow();
                                                        ((Button)event.getSource()).getScene().getWindow().hide();
                                                        break;
                                                    case "employee":
                                                        openEmployeeWindow();
                                                        ((Button)event.getSource()).getScene().getWindow().hide();
                                                        break;
                                                }
                                            } else {
                                                passwordField.setText("");
                                                warningLabel.setText("Неверный пароль!");
                                            }
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                });
    }

    void openAdminWindow() throws Exception{
        AdminWindow adminWindow = new AdminWindow();
        adminWindow.showWindow();
    }

    void openEmployeeWindow() throws Exception{
        EmployeeWindow employeeWindow = new EmployeeWindow();
        employeeWindow.showWindow();
    }

}