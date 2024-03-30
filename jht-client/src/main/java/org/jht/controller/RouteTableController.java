package org.jht.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;
import org.jht.component.RouteTable;
import org.jht.dto.Route;
import org.jht.service.RouteService;
import org.jht.support.Navigate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


/**
 * The RouteTableController class is responsible for controlling the route table view in the user interface.
 * It initializes the table view with data retrieved from the RouteService class.
 *
 * @implements Initialize
 */
public class RouteTableController implements Initializable {

    @FXML
    public TableView<Route> tableView;

    private final RouteService routeService = new RouteService();

    /**
     * Initializes the table view with data retrieved from a service.
     *
     * @param location  The location used to resolve relative paths for the root object, or {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if the root object was not localized.
     */
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

    /**
     * Handles the onClick event for creating a new route.
     *
     * @param event The MouseEvent that triggered the event.
     */
    @FXML
    void fxOnClickCreateRoute(MouseEvent event){
        Navigate.toWindow("Create Route", "route_form.fxml");
    }
}
