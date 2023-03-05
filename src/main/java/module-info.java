module carrb.jewelry {
    requires javafx.controls;
    requires javafx.fxml;


    opens carrb.jewelry to javafx.fxml;
    exports carrb.jewelry;
}