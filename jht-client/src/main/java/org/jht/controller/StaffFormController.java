package org.jht.controller;

import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jht.dto.Address;
import org.jht.dto.Contact;
import org.jht.dto.Staff;
import org.jht.service.StaffService;
import org.jht.support.Data;
import org.jht.support.Role;
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
public class StaffFormController implements Initializable {

    @FXML
    VBox fxRoot;

    @FXML
    ComboBox<String> fxStatus;

    @FXML
    ComboBox<String> fxRole;

    @FXML
    TextField fxFirstName;

    @FXML
    TextField fxLastName;

    @FXML
    TextField fxTrn;

    @FXML
    DatePicker fxDateOfBirth;

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

    private final StaffService staffService = new StaffService();

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
    protected static final Logger logger = LogManager.getLogger(StaffFormController.class);

    /**
     *
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Add Rules
        fxRole.getItems().add(Role.STAFF.name());
        fxRole.getItems().add(Role.ADMIN.name());

        // Add Status
        fxStatus.getItems().add(Status.ACTIVE.name());
        fxStatus.getItems().add(Status.INACTIVE.name());

        // Add Parishes
        fxAddressParish.getItems().addAll(Data.getParishes());
    }

    /**
     * Handles the onClick event for the Create button.
     *
     * @param event The MouseEvent that triggered the event
     */
    @FXML
    void onClickCreate(MouseEvent event){

        var staff = new Staff()
                .setStatus(fxStatus.getValue())
                .setRole(Objects.equals(fxRole.getValue(), Role.STAFF.name()) ? Role.STAFF : Role.ADMIN)
                .setFirstName(fxFirstName.getText())
                .setLastName(fxLastName.getText())
                .setDob(fxDateOfBirth.getValue().toString())
                .setTrn(fxTrn.getText())
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

        staff.setAddress(address);
        staff.setContact(contact);

        logger.info("Create Staff {}", new GsonBuilder().setPrettyPrinting().create().toJson(staff));

        this.staffService.post(staff, new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<Staff> call, @NotNull Response<Staff> response) {
                logger.info("Success: {}", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
                Platform.runLater(() -> ((Stage) fxRoot.getScene().getWindow()).close());
            }

            @Override
            public void onFailure(@NotNull Call<Staff> call, @NotNull Throwable throwable) {
                logger.info("Fail: {}", throwable.getMessage());
            }
        });
    }
}
