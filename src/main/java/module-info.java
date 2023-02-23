module com.mycompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany to javafx.fxml;
    opens com.mycompany.controllers to javafx.fxml;
    opens com.mycompany.domain to javafx.base;
    
    exports com.mycompany;
    exports com.mycompany.controllers;
}
