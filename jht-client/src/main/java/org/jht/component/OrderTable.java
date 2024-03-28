package org.jht.component;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.jht.dto.Order;

import java.util.List;

public class OrderTable {

    private final TableView<Order> tableView;

    public OrderTable(TableView<Order> tableView) {
        this.tableView = tableView;
    }

    public void initialize(List<Order> staffMappingList) {

        TableColumn<Order, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));

        TableColumn<Order, String> companyName = new TableColumn<>("Company Name");
        companyName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getCompanyName()));

        TableColumn<Order, String> rate = new TableColumn<>("Rate");
        rate.setCellValueFactory(cellData -> new SimpleObjectProperty<Double>(cellData.getValue().getRoute().getRate()).asString());

        // Source Address
        TableColumn<Order, String> sourceAddressLineOne = new TableColumn<>("Source Address Line One");
        sourceAddressLineOne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSourceAddress().getLineOne()));

        TableColumn<Order, String> sourceAddressLineTwo = new TableColumn<>("Source Address Line Two");
        sourceAddressLineTwo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSourceAddress().getLineTwo()));

        TableColumn<Order, String> sourceAddressParish = new TableColumn<>("Source Address Parish");
        sourceAddressParish.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSourceAddress().getParish()));

        TableColumn<Order, String> sourceAddressPostOffice = new TableColumn<>("Source Address Post Office");
        sourceAddressPostOffice.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSourceAddress().getPostOffice()));

        // Destination
        TableColumn<Order, String> destinationAddressLineOne = new TableColumn<>("Destination Address Line One");
        destinationAddressLineOne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSourceAddress().getLineOne()));

        TableColumn<Order, String> destinationAddressLineTwo = new TableColumn<>("Destination Address Line Two");
        destinationAddressLineTwo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSourceAddress().getLineTwo()));

        TableColumn<Order, String> destinationAddressParish = new TableColumn<>("Destination Address Parish");
        destinationAddressParish.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSourceAddress().getParish()));

        TableColumn<Order, String> destinationAddressPostOffice = new TableColumn<>("Destination Address Post Office");
        destinationAddressPostOffice.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSourceAddress().getPostOffice()));

        TableColumn<Order, String> createdAt = new TableColumn<>("Created At");
        createdAt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCreatedAt()));

        TableColumn<Order, Button> deleteStaff = new TableColumn<>("Actions");
        deleteStaff.setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("Delete")));

        tableView.getColumns().addAll(
                idColumn,
                companyName,
                rate,
                sourceAddressLineOne,
                sourceAddressLineTwo,
                sourceAddressParish,
                sourceAddressPostOffice,
                destinationAddressLineOne,
                destinationAddressLineTwo,
                destinationAddressParish,
                destinationAddressPostOffice,
                createdAt,
                deleteStaff
        );

        ObservableList<Order> data = FXCollections.observableArrayList(staffMappingList);

        tableView.setItems(data);
    }
}
