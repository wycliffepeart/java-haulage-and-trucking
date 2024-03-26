package org.jht.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.jht.component.OrderTable;
import org.jht.dto.Order;
import org.jht.service.OrderService;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

    @FXML
    public TableView<Order> tableView;

    private final OrderService orderService = new OrderService();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var orderTable = new OrderTable(this.tableView);

        orderTable.initialize(this.orderService.getAll());
    }
}
