module com.sea.fileseacherexercise {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sea.fileseacherexercise to javafx.fxml;
    exports com.sea.fileseacherexercise;
}