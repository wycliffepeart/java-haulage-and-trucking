package org.jht.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.jetbrains.annotations.NotNull;
import org.jht.component.CustomerTable;
import org.jht.dto.Customer;
import org.jht.service.CustomerService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    private final CustomerService customerService = new CustomerService();

    @FXML
    public TableView<Customer> tableView;

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
}