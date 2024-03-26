package org.jht.component;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.jht.dto.Customer;

import java.util.List;

public class CustomerTable {

    private final TableView<Customer> tableView;

    public CustomerTable(TableView<Customer> tableView) {
        this.tableView = tableView;
    }

    public void initialize(List<Customer> staffMappingList) {

        TableColumn<Customer, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));

        TableColumn<Customer, String> status = new TableColumn<>("Status");
        status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));

        TableColumn<Customer, String> firstName = new TableColumn<>("Company Name");
        firstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCompanyName()));

        TableColumn<Customer, String> lastName = new TableColumn<>("Contact Person");
        lastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContactPerson()));

        TableColumn<Customer, String> contactNumber = new TableColumn<>("Contact Number");
        contactNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContact().getNumber()));

        TableColumn<Customer, String> contactEmail = new TableColumn<>("Contact Email");
        contactEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContact().getEmail()));

        TableColumn<Customer, String> addressLineOne = new TableColumn<>("Address Line One");
        addressLineOne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getLineOne()));

        TableColumn<Customer, String> addressLineTwo = new TableColumn<>("Address Line Two");
        addressLineTwo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getLineTwo()));

        TableColumn<Customer, String> addressParish = new TableColumn<>("Address Parish");
        addressParish.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getParish()));

        TableColumn<Customer, String> addressPostOffice = new TableColumn<>("Address Post Office");
        addressPostOffice.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getPostOffice()));

        TableColumn<Customer, String> updatedAt = new TableColumn<>("Updated At");
        updatedAt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUpdatedAt()));

        TableColumn<Customer, String> createdAt = new TableColumn<>("Created At");
        createdAt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCreatedAt()));

        TableColumn<Customer, Button> viewOrderAction = new TableColumn<>("Actions");
        viewOrderAction.setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("View Orders")));

        TableColumn<Customer, Button> deleteStaff = new TableColumn<>("Actions");
        deleteStaff.setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("Delete Staff")));

        tableView.getColumns().addAll(
                idColumn,
                status,
                firstName,
                lastName,
                contactNumber,
                contactEmail,
                addressLineOne,
                addressLineTwo,
                addressParish,
                addressPostOffice,
                updatedAt,
                createdAt,
                viewOrderAction,
                deleteStaff
        );

        ObservableList<Customer> data = FXCollections.observableArrayList(staffMappingList);

        tableView.setItems(data);
    }
}
