package carrb.jewelry;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.concurrent.ThreadLocalRandom;

public class AuthorizationController {
    @FXML
    private Label welcomeText;
    @FXML private Button refreshButton;
    @FXML private Label captLab1; // заголовки для кода (снизу тоже)
    @FXML private Label captLab2;
    @FXML private Label captLab3;
    @FXML private Label captLab4;
    @FXML private Label captLab5;
    @FXML private Label captLab6;
    private String captNum1, captNum2, captNum3, captNum4, captNum5, captNum6;
    private Boolean refreshAccess = true;  // доступ к обновлению капчи

    @FXML
    void initialize(){
        changeCapture();

        refreshButton.setOnAction(event -> { // при нажатии на кнопку обновления кода
            if(refreshAccess) {
                changeCapture();
                refreshAccess = false;
            }
        });
    }


//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }



    void changeCapture(){ // метод обновления кода
        refreshAccess = true;
        captNum1 = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        captNum2 = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        captNum3 = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        captNum4 = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        captNum5 = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        captNum6 = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));

        captLab1.setText(captNum1);
        captLab2.setText(captNum2);
        captLab3.setText(captNum3);
        captLab4.setText(captNum4);
        captLab5.setText(captNum5);
        captLab6.setText(captNum6);
    }

}