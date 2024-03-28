package org.jht.component;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.jht.dto.Route;

import java.util.List;

public class RouteTable {

    private final TableView<Route> tableView;

    public RouteTable(TableView<Route> tableView) {
        this.tableView = tableView;
    }

    public void initialize(List<Route> routes) {

        TableColumn<Route, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));

        TableColumn<Route, String> description = new TableColumn<>("Description");
        description.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));

        TableColumn<Route, String> route = new TableColumn<>("Route");
        route.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRoute()));

        TableColumn<Route, String> rate = new TableColumn<>("Rate");
        rate.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getRate()).asString());

        TableColumn<Route, String> distance = new TableColumn<>("Distance");
        distance.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDistance()).asString());

        TableColumn<Route, String> updatedAt = new TableColumn<>("Updated At");
        updatedAt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUpdatedAt()));

        TableColumn<Route, String> createdAt = new TableColumn<>("Created At");
        createdAt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCreatedAt()));

        TableColumn<Route, Button> deleteActions = new TableColumn<>("Delete Actions");
        deleteActions.setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("Delete")));

        tableView.getColumns().addAll(
                idColumn,
                route,
                distance,
                rate,
                description,
                updatedAt,
                createdAt,
                deleteActions
        );

        ObservableList<Route> data = FXCollections.observableArrayList(routes);

        tableView.setItems(data);
    }
}
