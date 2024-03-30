package org.jht.controller;

import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jht.dto.Route;
import org.jht.service.RouteService;
import org.jht.support.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * RouteFormController is a controller class that manages the functionality of a route form.
 * It is responsible for initializing the form, handling user input, and interacting with the RouteService.
 */
public class RouteFormController implements Initializable {

    @FXML
    private VBox fxRoot;

    @FXML
    private ComboBox<String> fxRoute;

    @FXML
    private TextField fxDistance;

    @FXML
    private TextField fxRate;

    @FXML
    private TextArea fxDescription;

    private final RouteService routeService = new RouteService();

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
    protected static final Logger logger = LogManager.getLogger(RouteFormController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fxRoute.getItems().addAll(Data.getAllCombination());
    }

    /**
     * Handles the event of creating a new route when the user clicks the Create Route button.
     *
     * @param event the MouseEvent that triggered the event
     */
    @FXML
    void fxOnClickCreateRoute(MouseEvent event) {

        var route = new Route()
                .setRoute(fxRoute.getValue())
                .setRate(Double.parseDouble(fxRate.getText()))
                .setDescription(fxDescription.getText())
                .setDistance(Integer.parseInt(fxDistance.getText()));


        this.routeService.post(route, new Callback<Route>() {
            @Override
            public void onResponse(@NotNull Call<Route> call, @NotNull Response<Route> response) {
                logger.info("Success: {}", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
                Platform.runLater(() -> ((Stage) fxRoot.getScene().getWindow()).close());
            }

            @Override
            public void onFailure(@NotNull Call<Route> call, @NotNull Throwable throwable) {

            }
        });
    }
}
