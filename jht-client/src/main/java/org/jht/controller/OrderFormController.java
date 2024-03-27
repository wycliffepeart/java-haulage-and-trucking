package org.jht.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import org.jht.component.CustomerComboBoxMapping;
import org.jht.component.RouteComboBoxMapping;
import org.jht.component.StaffComboBoxMapping;
import org.jht.dto.Customer;
import org.jht.dto.Route;
import org.jht.dto.Staff;
import org.jht.support.Data;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    @FXML
    private ComboBox<Route> fxRouteComboBox;

    @FXML
    private ComboBox<Staff> fxAdminComboBox;

    @FXML
    private ComboBox<Staff> fxDriverComboBox;

    @FXML
    private ComboBox<Customer> fxCustomerComboBox;

    @FXML
    private ComboBox<String> fxSourceParish;

    @FXML
    private ComboBox<String> fxDestinationParish;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        RouteComboBoxMapping.map(fxRouteComboBox);
        StaffComboBoxMapping.map(fxAdminComboBox);
        StaffComboBoxMapping.map(fxDriverComboBox);
        CustomerComboBoxMapping.map(fxCustomerComboBox);

        fxSourceParish.getItems().addAll(Data.getParishes());
        fxDestinationParish.getItems().addAll(Data.getParishes());
    }
}
