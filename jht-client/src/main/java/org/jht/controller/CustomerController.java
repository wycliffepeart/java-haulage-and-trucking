package org.jht.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.jht.component.CustomerTable;
import org.jht.dto.Customer;
import org.jht.service.CustomerService;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    private final CustomerService customerService = new CustomerService();

    @FXML
    public TableView<Customer> tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        var customerTable = new CustomerTable(this.tableView);

        customerTable.initialize(this.customerService.getAll());
    }
}