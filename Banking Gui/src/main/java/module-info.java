module org.example.banking {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.opencsv;

    opens org.example.banking to javafx.fxml;
    exports org.example.banking;
}