module MyContacts {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.xml;
    exports sample.datamodel;

    opens sample;
}