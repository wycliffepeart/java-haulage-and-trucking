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


/**
 * The OrderController class is responsible for managing the order view and user interactions.
 */
public class OrderTableController implements Initializable {

    @FXML
    public TableView<Order> tableView;

    private final OrderService orderService = new OrderService();

    protected static final Logger logger = LogManager.getLogger(OrderTableController.class);

    /**
     * Initializes the OrderController by populating the tableView with data from the order service.
     *
     * @param location The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resources The resources used to localize the root object, or null if the root object was not localized.
     */
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

    /**
     * Handles the click event for the "Add Order" button.
     *
     * This method is called when the user clicks the "Add Order" button. It navigates the user to the "Add Order" window by calling the Navigate.toWindow() method.
     *
     * @param mouseEvent The MouseEvent that triggered the event.
     */
    @FXML
    void onClickAddOrder(MouseEvent mouseEvent){
        Navigate.toWindow("Add Order","order_form.fxml");
    }
}
