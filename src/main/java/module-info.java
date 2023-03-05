module carrb.jewelry {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens carrb.jewelry to javafx.fxml;
    exports carrb.jewelry;
}