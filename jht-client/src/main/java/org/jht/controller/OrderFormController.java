package org.jht.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jht.component.CustomerComboBoxMapping;
import org.jht.component.RouteComboBoxMapping;
import org.jht.component.StaffComboBoxMapping;
import org.jht.dto.*;
import org.jht.support.Data;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    @FXML
    private ComboBox<Route> fxRouteComboBox;

    @FXML
    private ComboBox<Staff> fxAdminComboBox;

    @FXML
    private ComboBox<Staff> fxDriverComboBox;

    @FXML
    private ComboBox<Customer> fxCustomerComboBox;

    @FXML
    private ComboBox<String> fxSourceParish;

    @FXML
    private TextField fxSourceLineOneTextField;

    @FXML
    private TextField fxSourceLineTwoTextField;

    @FXML
    private TextField fxSourcePostOfficetextField;

    @FXML
    private TextField fxDestinationLineOneTextField;

    @FXML
    private TextField fxDestinationLineTwoTextField;

    @FXML
    private ComboBox<String> fxDestinationParish;

    @FXML
    private TextField fxDestinationPostOfficetextField;

    /**
     * The logger variable is used for logging messages within the CustomerService class.
     * It is an instance of the Logger class from the Log4j framework.
     * The logger is defined as protected and final, indicating that it cannot be modified or overridden by subclasses.
     * The logger is retrieved using the getLogger method from the LogManager class, with the CustomerService class as the logger name.
     * <p>
     * Example usage:
     * logger.debug("Debug message"); // Logs a debug level message
     * logger.info("Info message");   // Logs an info level message
     * logger.warn("Warn message");   // Logs a warn level message
     * logger.error("Error message"); // Logs an error level message
     * <p>
     * JavaDoc References:
     * - Logger: org.apache.logging.log4j.Logger
     * - LogManager: org.apache.logging.log4j.LogManager
     */
    protected static final Logger logger = LogManager.getLogger(OrderFormController.class);


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        RouteComboBoxMapping.map(fxRouteComboBox);
        StaffComboBoxMapping.map(fxAdminComboBox);
        StaffComboBoxMapping.map(fxDriverComboBox);
        CustomerComboBoxMapping.map(fxCustomerComboBox);

        fxSourceParish.getItems().addAll(Data.getParishes());
        fxDestinationParish.getItems().addAll(Data.getParishes());
    }

    @FXML
    void onClickCreateOrderListener(MouseEvent event) {
        var role = fxRouteComboBox.getValue();
        var customer = fxCustomerComboBox.getValue();
        var driver = fxDriverComboBox.getValue();
        var admin = fxAdminComboBox.getValue();

        // Source Address
        var sourceAddressLineOne = fxSourceLineOneTextField.getText();
        var sourceAddressLineTwo = fxSourceLineTwoTextField.getText();
        var sourceAddressParish = fxSourceParish.getValue();
        var sourceAddressPostOffice = fxSourcePostOfficetextField.getText();
        var sourceAddress = new Address()
                .setLineOne(sourceAddressLineOne)
                .setLineTwo(sourceAddressLineTwo)
                .setParish(sourceAddressParish)
                .setPostOffice(sourceAddressPostOffice)
                .setParish(sourceAddressParish);

        // Source Address
        var destinationAddressLineOne = fxDestinationLineOneTextField.getText();
        var destinationAddressLineTwo = fxDestinationLineTwoTextField.getText();
        var destinationAddressParish = fxDestinationParish.getValue();
        var destinationAddressPostOffice = fxDestinationPostOfficetextField.getText();

        var destinationAddress = new Address()
                .setLineOne(destinationAddressLineOne)
                .setLineTwo(destinationAddressLineTwo)
                .setParish(destinationAddressParish)
                .setPostOffice(destinationAddressPostOffice)
                .setParish(destinationAddressParish);

        var order = new CreateOrderDTO()
                .setRouteId(role.getId())
                .setCustomerId(customer.getId()).
                setDriverId(driver.getId())
                .setAdminId(admin.getId())
                .setSourceAddress(sourceAddress)
                .setDestinationAddress(destinationAddress);


        logger.info(order);

    }
}
