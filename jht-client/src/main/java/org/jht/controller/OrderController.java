package org.jht.controller;

import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jht.component.OrderTable;
import org.jht.dto.Order;
import org.jht.service.OrderService;
import org.jht.support.Navigate;
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

    protected static final Logger logger = LogManager.getLogger(OrderController.class);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var orderTable = new OrderTable(this.tableView);

        this.orderService.get(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Order>> call, @NotNull Response<List<Order>> response) {
                logger.info("Success: {}", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
                Platform.runLater(() -> orderTable.initialize(response.body()));
            }

            @Override
            public void onFailure(@NotNull Call<List<Order>> call, @NotNull Throwable throwable) {
                logger.info("Fail Error: {}", throwable.getMessage());
            }
        });
    }

    @FXML
    void onClickAddOrder(MouseEvent mouseEvent){
        Navigate.toWindow("Add Order","order_form.fxml");
    }
}
