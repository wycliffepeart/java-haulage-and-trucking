package org.jht.component;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.jht.dto.Route;
import org.jht.dto.Staff;
import org.jht.service.StaffService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class StaffTable {

    public static ObservableList<Staff> data;

    private final TableView<Staff> tableView;

    private final StaffService service = new StaffService();

    public StaffTable(TableView<Staff> tableView) {
        this.tableView = tableView;
    }

    public void initialize(List<Staff> staffList) {

        TableColumn<Staff, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));

        TableColumn<Staff, String> status = new TableColumn<>("Status");
        status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));

        TableColumn<Staff, String> role = new TableColumn<>("Role");
        role.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRole().name()));

        TableColumn<Staff, String> firstName = new TableColumn<>("First Name");
        firstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));

        TableColumn<Staff, String> lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));

        TableColumn<Staff, String> dateOfBirth = new TableColumn<>("Date of Birth");
        dateOfBirth.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDob()));

        TableColumn<Staff, String> trn = new TableColumn<>("Tax Registration Number (TRN)");
        trn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrn()));

        TableColumn<Staff, String> nextOfKinFirstName = new TableColumn<>("Next Of Kin First Name");
        nextOfKinFirstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNextOfKinFirstName()));

        TableColumn<Staff, String> nextOfKinLastName = new TableColumn<>("Next Of Kin Last Name");
        nextOfKinLastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNextOfKinLastName()));

        TableColumn<Staff, String> nextOfKinContactNumber = new TableColumn<>("Next Of Kin Contact Number");
        nextOfKinContactNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNextOfKinContactNumber()));

        TableColumn<Staff, String> contactNumber = new TableColumn<>("Contact Number");
        contactNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContact().getNumber()));

        TableColumn<Staff, String> contactEmail = new TableColumn<>("Contact Email");
        contactEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContact().getEmail()));

        TableColumn<Staff, String> addressLineOne = new TableColumn<>("Address Line One");
        addressLineOne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getLineOne()));

        TableColumn<Staff, String> addressLineTwo = new TableColumn<>("Address Line Two");
        addressLineTwo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getLineTwo()));

        TableColumn<Staff, String> addressParish = new TableColumn<>("Address Parish");
        addressParish.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getParish()));

        TableColumn<Staff, String> addressPostOffice = new TableColumn<>("Address Post Office");
        addressPostOffice.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getPostOffice()));

        TableColumn<Staff, String> createdAt = new TableColumn<>("Created At");
        createdAt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCreatedAt()));

        TableColumn<Staff, Button> viewOrderAction = new TableColumn<>("Actions");
        viewOrderAction.setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("View Orders")));

        TableColumn<Staff, Button> deleteStaff = new TableColumn<>("Actions");
        deleteStaff.setCellValueFactory(cellData -> {
            var button = new Button("Delete");
            button.setOnMouseClicked(event -> service.delete(cellData.getValue(), new Callback<>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    tableView.getItems().remove(cellData.getValue());
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable throwable) {

                }
            }));
           return new SimpleObjectProperty<>(button);
        });

        tableView.getColumns().addAll(
                idColumn,
                status,
                role,
                firstName,
                lastName,
                dateOfBirth,
                trn,
                contactNumber,
                contactEmail,
                addressLineOne,
                addressLineTwo,
                addressParish,
                addressPostOffice,
                nextOfKinFirstName,
                nextOfKinLastName,
                nextOfKinContactNumber,
                createdAt,
                deleteStaff
        );

        data = FXCollections.observableArrayList(staffList);

        tableView.setItems(data);
    }
}
