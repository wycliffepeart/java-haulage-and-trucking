package org.jht.controller;

import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jht.dto.Address;
import org.jht.dto.Contact;
import org.jht.dto.Customer;
import org.jht.service.CustomerService;
import org.jht.support.Data;
import org.jht.support.Status;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * The StaffFormController class is responsible for handling the UI events and actions
 * related to the staff form. It implements the Initialize interface, which allows
 * it to initialize the form when it is loaded.
 */
public class CustomerFormController implements Initializable {

    @FXML
    VBox fxRoot;

    @FXML
    ComboBox<String> fxStatus;

    @FXML
    TextField fxCompanyName;

    @FXML
    TextField fxContactNumber;

    @FXML
    TextField fxContactEmail;

    @FXML
    TextField fxAddressLineOne;

    @FXML
    TextField fxAddressLineTwo;

    @FXML
    ComboBox<String> fxAddressParish;

    @FXML
    TextField fxAddressPostOffice;

    @FXML
    TextField fxNextOfKimFirstName;

    @FXML
    TextField fxNextOfKinLastName;

    @FXML
    TextField fxNextOfKinContactNumber;

    private final CustomerService customerService = new CustomerService();

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
    protected static final Logger logger = LogManager.getLogger(CustomerFormController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fxStatus.getItems().add(Status.ACTIVE.name());
        fxStatus.getItems().add(Status.INACTIVE.name());

        fxAddressParish.getItems().addAll(Data.getParishes());
    }

    /**
     * Handles the onClick event for the Create button.
     *
     * @param event The MouseEvent that triggered the event
     */
    @FXML
    void onClickCreateCustomer(MouseEvent event) {

        var customer = new Customer()
                .setStatus(Objects.equals(fxStatus.getValue(), Status.ACTIVE.name()) ? Status.ACTIVE.name() : Status.INACTIVE.name())
                .setCompanyName(fxCompanyName.getText())
                .setNextOfKinFirstName(fxNextOfKimFirstName.getText())
                .setNextOfKinLastName(fxNextOfKinLastName.getText())
                .setNextOfKinContactNumber(fxNextOfKinContactNumber.getText());

        var address = new Address()
                .setLineOne(fxAddressLineOne.getText())
                .setLineTwo(fxAddressLineTwo.getText())
                .setParish(fxAddressParish.getValue())
                .setPostOffice(fxAddressPostOffice.getText());

        var contact = new Contact()
                .setNumber(fxContactNumber.getText())
                .setEmail(fxContactEmail.getText());

        customer.setAddress(address);
        customer.setContact(contact);

        logger.info("Create Customer {}", new GsonBuilder().setPrettyPrinting().create().toJson(customer));

        this.customerService.post(customer, new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<Customer> call, @NotNull Response<Customer> response) {
                logger.info("Success: {}", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
                Platform.runLater(() -> ((Stage) fxRoot.getScene().getWindow()).close());
            }

            @Override
            public void onFailure(@NotNull Call<Customer> call, @NotNull Throwable throwable) {
                logger.info("Fail: {}", throwable.getMessage());
            }
        });
    }
}
