module com.exam {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.data.jpa;
    requires lombok;
    requires jakarta.persistence;

    opens com.exam to javafx.fxml;
    exports com.exam;
    exports com.exam.model;
    opens com.exam.model to javafx.fxml;
}
