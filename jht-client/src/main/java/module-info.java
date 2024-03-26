module org.jht {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires static lombok;
    requires org.apache.logging.log4j;

    opens org.jht to javafx.fxml, lombok;
    opens org.jht.controller to javafx.fxml;
    opens org.jht.component to javafx.fxml;
    exports org.jht;
}