module com.example.kik {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.kik to javafx.fxml;
    exports com.example.kik;
}