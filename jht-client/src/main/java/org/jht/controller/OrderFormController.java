package org.jht.controller;

import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jht.component.CustomerComboBoxMapping;
import org.jht.component.RouteComboBoxMapping;
import org.jht.component.StaffComboBoxMapping;
import org.jht.dto.*;
import org.jht.service.OrderService;
import org.jht.support.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * The OrderFormController class controls the order form view.
 * It allows users to create a new order by filling out the form fields and submitting the order.
 */
public class OrderFormController implements Initializable {

    @FXML
    private Node fxRoot;

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


    private final OrderService orderService = new OrderService();

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

    /**
     * Initializes the OrderFormController with the specified URL location and ResourceBundle resources.
     *
     * @param location - The location used to resolve relative paths for the root object, or {@code null} if the location is not known.
     * @param resources - The resources used to localize the root object, or {@code null} if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        RouteComboBoxMapping.map(fxRouteComboBox);
        StaffComboBoxMapping.map(fxAdminComboBox);
        StaffComboBoxMapping.map(fxDriverComboBox);
        CustomerComboBoxMapping.map(fxCustomerComboBox);

        fxSourceParish.getItems().addAll(Data.getParishes());
        fxDestinationParish.getItems().addAll(Data.getParishes());
    }

    /**
     * Handles the onClick event for the "Create Order" button.
     *
     * @param event The MouseEvent that triggered the event.
     */
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

        var order = new OrderRequestBody()
                .setRouteId(role.getId())
                .setCustomerId(customer.getId()).
                setDriverId(driver.getId())
                .setAdminId(admin.getId())
                .setSourceAddress(sourceAddress)
                .setDestinationAddress(destinationAddress);


        logger.info("Create Order {}", new GsonBuilder().setPrettyPrinting().create().toJson(order));

        this.orderService.post(order, new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<Order> call, @NotNull Response<Order> response) {
                logger.info("Status Code: {}", response.code());
                logger.info("Success: {}", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
                Platform.runLater(() -> ((Stage) fxRoot.getScene().getWindow()).close());
            }

            @Override
            public void onFailure(@NotNull Call<Order> call, @NotNull Throwable throwable) {
                logger.info("Fail: {}", throwable.getMessage());
            }
        });

    }
}
