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
import org.jht.support.Navigate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The controller class for the PaySlipTable view.
 * It manages the display and interaction of the TableView and ComboBox.
 *
 * @implements Initializable
 */
public class PaySlipTableController implements Initializable {

    @FXML
    public TableView<PaySlip> tableView;

    @FXML
    public ComboBox<Staff> fxUsersFilter;

    private final PaySlipService service = new PaySlipService();

    /**
     * Initializes the PaySlipTableController by setting up the necessary dependencies and retrieving data.
     *
     * @param location The location used to resolve relative paths for the root object, or {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var salaryTable = new PaySlipTableMappings(tableView);

        StaffComboBoxMapping.map(fxUsersFilter);

        this.service.getAll(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<PaySlip>> call, @NotNull Response<List<PaySlip>> response) {
                if (response.body() != null) {
                    Platform.runLater(() -> salaryTable.initialize(response.body()));
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<PaySlip>> call, @NotNull Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    /**
     * Performs the action of generating a pay slip.
     *
     * @param event The mouse event that triggered the method.
     */
    @FXML
    void onClickGeneratePaySlip(MouseEvent event) {
        Navigate.toWindow("Generate Pay Slip", "pay_slip_generator_form.fxml");
    }
}
