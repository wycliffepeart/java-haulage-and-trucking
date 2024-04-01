package org.jht.component;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.jht.dto.Customer;
import org.jht.dto.Invoice;

import java.util.List;

public class InvoiceTable {

    private final TableView<Invoice> tableView;

    public InvoiceTable(TableView<Invoice> tableView) {
        this.tableView = tableView;
    }

    public void initialize(List<Invoice> staffMappingList) {

        TableColumn<Invoice, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCustomer().getId()));

        TableColumn<Invoice, String> total = new TableColumn<>("Total");
        total.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTotal()).asString());

        TableColumn<Invoice, String> status = new TableColumn<>("Status");
        status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getStatus()));

        TableColumn<Invoice, String> firstName = new TableColumn<>("Company Name");
        firstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getCompanyName()));

        TableColumn<Invoice, String> lastName = new TableColumn<>("Contact Person");
        lastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getContactPerson()));

        TableColumn<Invoice, String> contactNumber = new TableColumn<>("Contact Number");
        contactNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getContact().getNumber()));

        TableColumn<Invoice, String> contactEmail = new TableColumn<>("Contact Email");
        contactEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getContact().getEmail()));

        TableColumn<Invoice, String> addressLineOne = new TableColumn<>("Address Line One");
        addressLineOne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getAddress().getLineOne()));

        TableColumn<Invoice, String> addressLineTwo = new TableColumn<>("Address Line Two");
        addressLineTwo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getAddress().getLineTwo()));

        TableColumn<Invoice, String> addressParish = new TableColumn<>("Address Parish");
        addressParish.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getAddress().getParish()));

        TableColumn<Invoice, String> addressPostOffice = new TableColumn<>("Address Post Office");
        addressPostOffice.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getAddress().getPostOffice()));

        TableColumn<Invoice, String> createdAt = new TableColumn<>("Created At");
        createdAt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCreatedAt()));

        TableColumn<Invoice, Button> deleteStaff = new TableColumn<>("Actions");
        deleteStaff.setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("Delete")));

        tableView.getColumns().addAll(
                idColumn,
                total,
                status,
                firstName,
                lastName,
                contactNumber,
                contactEmail,
                addressLineOne,
                addressLineTwo,
                addressParish,
                addressPostOffice,
                createdAt,
                deleteStaff
        );

        ObservableList<Invoice> data = FXCollections.observableArrayList(staffMappingList);

        tableView.setItems(data);
    }
}
