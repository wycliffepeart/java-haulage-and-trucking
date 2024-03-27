package org.jht.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jht.component.StaffComboBoxMapping;
import org.jht.dto.Staff;

import java.net.URL;
import java.util.ResourceBundle;


public class PaySlipGeneratorFormController implements Initializable {

    @FXML
    private ComboBox<Staff> fxStaffComboBox;

    @FXML
    private DatePicker fxStartDatePicker;

    @FXML
    private DatePicker fxEndDatePicker;

    protected static final Logger logger = LogManager.getLogger(PaySlipGeneratorFormController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StaffComboBoxMapping.map(fxStaffComboBox);
    }

    @FXML
    void fxOnClickGeneratePaySlip(MouseEvent event) {

        var staff = fxStaffComboBox.getValue();
        var startDate = fxStartDatePicker.getValue();
        var endDate = fxEndDatePicker.getValue();

        logger.info("{} {} {}", staff, startDate, endDate);
    }
}
