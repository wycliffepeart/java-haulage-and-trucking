package org.jht.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.jetbrains.annotations.NotNull;
import org.jht.component.RouteTable;
import org.jht.dto.Route;
import org.jht.service.RouteService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RouteTableController implements Initializable {

    @FXML
    public TableView<Route> tableView;

    private final RouteService routeService = new RouteService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        var routeTable = new RouteTable(tableView);

        this.routeService.get(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Route>> call, @NotNull Response<List<Route>> response) {
                Platform.runLater(() -> routeTable.initialize(response.body()));
            }

            @Override
            public void onFailure(@NotNull Call<List<Route>> call, @NotNull Throwable throwable) {

            }
        });
    }
}
