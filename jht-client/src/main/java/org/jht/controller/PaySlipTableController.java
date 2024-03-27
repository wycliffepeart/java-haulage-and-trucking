package org.jht.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;
import org.jht.component.PaySlipTableMappings;
import org.jht.component.StaffComboBoxMapping;
import org.jht.dto.PaySlip;
import org.jht.dto.Staff;
import org.jht.service.PaySlipService;
import org.jht.service.StaffService;
import org.jht.support.Navigate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PaySlipTableController implements Initializable {

    @FXML
    public TableView<PaySlip> tableView;

    @FXML
    public ComboBox<Staff> fxUsersFilter;

    private final PaySlipService service = new PaySlipService();
    private final StaffComboBoxMapping staffComboBoxMapping = new StaffComboBoxMapping();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var salaryTable = new PaySlipTableMappings(tableView);

        this.staffComboBoxMapping.mapStaff(fxUsersFilter);

        this.service.getAll(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<PaySlip>> call, @NotNull Response<List<PaySlip>> response) {
                if (response.body() != null) {
                    Platform.runLater(() -> salaryTable.initialize(response.body()));
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<PaySlip>> call, @NotNull Throwable throwable) {
                System.out.println("Error");

                throwable.printStackTrace();
            }
        });
    }

    @FXML
    void onClickGeneratePaySlip(MouseEvent event){
        Navigate.toWindow("Generate Pay Slip","pay_slip_generator_form.fxml");
    }
}
