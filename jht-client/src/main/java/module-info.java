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
    requires retrofit2;
    requires com.google.gson;
    requires retrofit2.converter.gson;
    requires org.apache.logging.log4j;
    requires org.jetbrains.annotations;
    requires stomp.websocket;
    requires spring.messaging;
    requires spring.websocket;
    requires com.fasterxml.jackson.databind;

    opens org.jht to javafx.fxml, lombok;
    opens org.jht.dto to com.google.gson;
    opens org.jht.support to com.google.gson;
    opens org.jht.controller to javafx.fxml;
    opens org.jht.component to javafx.fxml;
    opens org.jht.websocket to com.fasterxml.jackson.databind;
    exports org.jht;
}