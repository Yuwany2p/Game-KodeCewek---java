module com.example.kodecewek {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.kodecewek to javafx.fxml;
    exports com.example.kodecewek;
}