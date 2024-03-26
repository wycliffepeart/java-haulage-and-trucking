package org.jht.component;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.jht.dto.Order;
import org.jht.dto.Salary;
import org.jht.dto.Staff;

import java.util.List;

public class SalaryTable {

    private final TableView<Salary> tableView;

    public SalaryTable(TableView<Salary> tableView) {
        this.tableView = tableView;
    }

    public void initialize(List<Salary> staffMappingList) {

        TableColumn<Salary, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));

        TableColumn<Salary, String> status = new TableColumn<>("Status");
        status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getStatus()));

        TableColumn<Salary, String> role = new TableColumn<>("Staff Role");
        role.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getRole().name()));

        TableColumn<Salary, String> firstName = new TableColumn<>("First Name");
        firstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getFirstName()));

        TableColumn<Salary, String> lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getLastName()));

        TableColumn<Salary, String> dateOfBirth = new TableColumn<>("Date of Birth");
        dateOfBirth.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getDob()));

        TableColumn<Salary, String> trn = new TableColumn<>("Tax Registration Number (TRN)");
        trn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaff().getTrn()));

        TableColumn<Salary, String> salary = new TableColumn<>("Salary");
        salary.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSalary()).asString());

        TableColumn<Salary, String> startDate = new TableColumn<>("Start Date");
        startDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartDate().toString()));

        TableColumn<Salary, String> endDate = new TableColumn<>("End Date");
        endDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndDate().toString()));

        TableColumn<Salary, String> adminFirstName = new TableColumn<>("Admin First Name");
        adminFirstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPreparedBy().getFirstName()));

        TableColumn<Salary, String> adminLastName = new TableColumn<>("Admin Last Name");
        adminLastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPreparedBy().getLastName()));

        TableColumn<Salary, String> adminTrn = new TableColumn<>("Admin Tax Registration Number (TRN)");
        adminTrn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPreparedBy().getTrn()));

        TableColumn<Salary, String> updatedAt = new TableColumn<>("Updated At");
        updatedAt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUpdatedAt().toString()));

        TableColumn<Salary, String> createdAt = new TableColumn<>("Created At");
        createdAt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCreatedAt().toString()));

        TableColumn<Salary, Button> viewOrderAction = new TableColumn<>("Actions");
        viewOrderAction.setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("View Orders")));

        TableColumn<Salary, Button> deleteStaff = new TableColumn<>("Actions");
        deleteStaff.setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("Delete Staff")));

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
                updatedAt,
                createdAt,
                viewOrderAction,
                deleteStaff
        );

        ObservableList<Salary> data = FXCollections.observableArrayList(staffMappingList);

        tableView.setItems(data);
    }
}
