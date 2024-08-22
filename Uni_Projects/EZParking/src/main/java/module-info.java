module com.example.ezparking {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.ezparking to javafx.fxml;
    exports com.example.ezparking;
}