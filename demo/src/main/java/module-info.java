module com.borislavmm.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.borislavmm.demo to javafx.fxml;
    exports com.borislavmm.demo;
}