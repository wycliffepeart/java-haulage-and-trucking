package org.jht.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;
import org.jht.component.CustomerTable;
import org.jht.dto.Customer;
import org.jht.service.CustomerService;
import org.jht.support.Navigate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    @FXML
    public TableView<Customer> tableView;

    private final CustomerService customerService = new CustomerService();

    /**
     * This method is called when the controller is initialized and sets up the CustomerTable view.
     *
     * @param location The location used to resolve relative paths for the root object, or {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        var customerTable = new CustomerTable(this.tableView);

        this.customerService.get(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Customer>> call, @NotNull Response<List<Customer>> response) {
                Platform.runLater(() -> customerTable.initialize(response.body()));
            }

            @Override
            public void onFailure(@NotNull Call<List<Customer>> call, @NotNull Throwable throwable) {

            }
        });

    }

    /**
     * Handles the event when the create customer button is clicked.
     *
     * @param event The mouse event that triggered the event.
     */
    @FXML
    void onClickCreateCustomer(MouseEvent event){
        Navigate.toWindow("Create Customer", "customer_form.fxml");
    }
}