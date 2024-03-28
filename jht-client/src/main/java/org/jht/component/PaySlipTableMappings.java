package org.jht.component;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.jht.dto.PaySlip;

import java.util.List;

public class PaySlipTableMappings {

    private final TableView<PaySlip> tableView;

    public PaySlipTableMappings(TableView<PaySlip> tableView) {
        this.tableView = tableView;
    }

    public void initialize(List<PaySlip> staffMappingList) {

        TableColumn<PaySlip, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));

        TableColumn<PaySlip, String> status = new TableColumn<>("Status");
        status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getStatus()));

        TableColumn<PaySlip, String> role = new TableColumn<>("Staff Role");
        role.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getRole().name()));

        TableColumn<PaySlip, String> firstName = new TableColumn<>("First Name");
        firstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getFirstName()));

        TableColumn<PaySlip, String> lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getLastName()));

        TableColumn<PaySlip, String> dateOfBirth = new TableColumn<>("Date of Birth");
        dateOfBirth.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getDob()));

        TableColumn<PaySlip, String> trn = new TableColumn<>("Tax Registration Number (TRN)");
        trn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getTrn()));

        TableColumn<PaySlip, String> salary = new TableColumn<>("Salary");
        salary.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSalary()).asString());

        TableColumn<PaySlip, String> startDate = new TableColumn<>("Start Date");
        startDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartDate().toString()));

        TableColumn<PaySlip, String> endDate = new TableColumn<>("End Date");
        endDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndDate().toString()));

        TableColumn<PaySlip, String> adminFirstName = new TableColumn<>("Admin First Name");
        adminFirstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdmin().getFirstName()));

        TableColumn<PaySlip, String> adminLastName = new TableColumn<>("Admin Last Name");
        adminLastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdmin().getLastName()));

        TableColumn<PaySlip, String> adminTrn = new TableColumn<>("Admin Tax Registration Number (TRN)");
        adminTrn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdmin().getTrn()));

        TableColumn<PaySlip, String> createdAt = new TableColumn<>("Created At");
        createdAt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCreatedAt().toString()));

        TableColumn<PaySlip, Button> deleteStaff = new TableColumn<>("Actions");
        deleteStaff.setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("Delete")));

        tableView.getColumns().addAll(
                idColumn,
                status,
                role,
                firstName,
                lastName,
                dateOfBirth,
                trn,
                salary,
                startDate,
                endDate,
                adminFirstName,
                adminLastName,
                adminTrn,
                createdAt,
                deleteStaff
        );

        ObservableList<PaySlip> data = FXCollections.observableArrayList(staffMappingList);

        tableView.setItems(data);
    }
}
