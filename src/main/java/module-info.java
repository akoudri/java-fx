module com.akfc.training.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    //requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires jep;

    opens com.akfc.training.gui to javafx.fxml;
    opens com.akfc.training.gui.examples to javafx.fxml;
    exports com.akfc.training.gui;
    exports com.akfc.training.gui.examples;
}