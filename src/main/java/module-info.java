module com.mycompany.bmicalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.bmicalculator to javafx.fxml;
    exports com.mycompany.bmicalculator;
}
