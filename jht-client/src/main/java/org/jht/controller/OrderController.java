package org.jht.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.jht.component.OrderTable;
import org.jht.dto.Order;
import org.jht.service.OrderService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

    @FXML
    public TableView<Order> tableView;

    private final OrderService orderService = new OrderService();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var orderTable = new OrderTable(this.tableView);

        this.orderService.getAll(new Callback<>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                Platform.runLater(() -> orderTable.initialize(response.body()));
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable throwable) {

            }
        });
    }
}
