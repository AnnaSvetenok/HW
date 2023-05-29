module com.trainjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.trainjavafx to javafx.fxml;
    exports com.trainjavafx;
}
