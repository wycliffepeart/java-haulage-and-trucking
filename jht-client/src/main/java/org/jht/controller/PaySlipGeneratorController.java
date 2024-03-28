package org.jht.controller;

import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jht.component.StaffComboBoxMapping;
import org.jht.dto.GeneratePaySlipBody;
import org.jht.dto.PaySlip;
import org.jht.dto.Staff;
import org.jht.service.PaySlipService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class PaySlipGeneratorController implements Initializable {

    @FXML
    private Node fxRoot;

    @FXML
    private ComboBox<Staff> fxAdminComboBox;

    @FXML
    private ComboBox<Staff> fxStaffComboBox;

    @FXML
    private DatePicker fxStartDatePicker;

    @FXML
    private DatePicker fxEndDatePicker;

    private final PaySlipService paySlipService = new PaySlipService();

    protected static final Logger logger = LogManager.getLogger(PaySlipGeneratorController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StaffComboBoxMapping.map(fxAdminComboBox);
        StaffComboBoxMapping.map(fxStaffComboBox);
    }

    @FXML
    void fxOnClickGeneratePaySlip(MouseEvent event) {

        var admin = fxAdminComboBox.getValue();
        var staff = fxStaffComboBox.getValue();
        var startDate = fxStartDatePicker.getValue();
        var endDate = fxEndDatePicker.getValue();

        var body = new GeneratePaySlipBody()
                .setAdminId(admin.getId())
                .setStaffId(staff.getId())
                .setStartDate(startDate.toString())
                .setEndDate(endDate.toString());

        logger.info("Data to send: {}", new GsonBuilder().setPrettyPrinting().create().toJson(body));

        paySlipService.post(body, new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<PaySlip> call, @NotNull Response<PaySlip> response) {
                logger.info("Status Code: {}", response.code());
                logger.info("Success: {}", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
                Platform.runLater(() -> ((Stage) fxRoot.getScene().getWindow()).close());
            }

            @Override
            public void onFailure(@NotNull Call<PaySlip> call, @NotNull Throwable throwable) {
                logger.info("Error: {}", throwable.getMessage());
            }
        });
    }
}
