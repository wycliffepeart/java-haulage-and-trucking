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

    private final StaffComboBoxMapping staffComboBoxMapping = new StaffComboBoxMapping();

    protected static final Logger logger = LogManager.getLogger(PaySlipGeneratorFormController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.staffComboBoxMapping.mapStaff(fxStaffComboBox);
    }

    @FXML
    void fxOnClickGeneratePaySlip(MouseEvent event) {
        logger.info("LoG");

        var staff = fxStaffComboBox.getValue();
        var startDate = fxStartDatePicker.getValue();
        var endDate = fxEndDatePicker.getValue();

        System.out.println("Hello" + staff.getFirstName());
    }
}
