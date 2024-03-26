package org.jht.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.jht.support.Data;
import org.jht.support.Role;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffFormController implements Initializable {


    @FXML
    ComboBox<String> fxRole;

    @FXML
    ComboBox<String> fxParish;

    @FXML
    TextField fxFirstName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> items = fxRole.getItems();

        items.add(Role.STAFF.name());
        items.add(Role.ADMIN.name());

        ObservableList<String> jamaicaParishes = fxParish.getItems();
        jamaicaParishes.addAll(Data.getParishes());
    }
}
