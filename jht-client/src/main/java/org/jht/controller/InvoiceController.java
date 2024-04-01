package org.jht.controller;

import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jht.component.CustomerComboBoxMapping;
import org.jht.component.InvoiceTable;
import org.jht.dto.Customer;
import org.jht.dto.Invoice;
import org.jht.service.InvoiceService;
import org.jht.support.Navigate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class InvoiceController implements Initializable {

    @FXML
    public TableView<Invoice> tableView;

    @FXML
    private DatePicker fxStartDatePicker;

    @FXML
    private DatePicker fxEndDatePicker;

    @FXML
    private ComboBox<Customer> fxCustomerComboBox;

    private Stage stage;

    @FXML
    private Text fxTextTotal;

    private InvoiceTable invoiceTable;

    private final InvoiceService invoiceService = new InvoiceService();

    protected static final Logger logger = LogManager.getLogger(InvoiceController.class);


    /**
     * This method is called when the controller is initialized and sets up the CustomerTable view.
     *
     * @param location  The location used to resolve relative paths for the root object, or {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        invoiceTable = new InvoiceTable(this.tableView);

        CustomerComboBoxMapping.map(fxCustomerComboBox);

        this.invoiceService.get(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Invoice>> call, @NotNull Response<List<Invoice>> response) {
                Platform.runLater(() -> {

                    assert response.body() != null;
                    fxTextTotal.setText(" $" +String.valueOf(response.body().stream().mapToDouble(Invoice::getTotal).sum()));
                    invoiceTable.initialize(response.body());
                });
            }

            @Override
            public void onFailure(@NotNull Call<List<Invoice>> call, @NotNull Throwable throwable) {

            }
        });

    }

    @FXML
    void fxOnClickGenerateReportBaseOnPeriod(MouseEvent event){

        var customerId = String.valueOf(this.fxCustomerComboBox.getValue().getId());
        var starDate = this.fxStartDatePicker.getValue().toString();
        var endDate = this.fxEndDatePicker.getValue().toString();

        logger.info("Click {} {}", starDate, endDate);

        var map = new HashMap<String, String>();
        map.put("startDate", starDate);
        map.put("endDate", endDate);
        map.put("customerId", customerId);

        this.invoiceService.filter(map, new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Invoice>> call, @NotNull Response<List<Invoice>> response) {
                Platform.runLater(() -> {
                    logger.info("Success: {}", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));

                    assert response.body() != null;
                    fxTextTotal.setText(" $" +String.valueOf(response.body().stream().mapToDouble(Invoice::getTotal).sum()));
                    invoiceTable.initialize(response.body());
                });
            }

            @Override
            public void onFailure(@NotNull Call<List<Invoice>> call, @NotNull Throwable throwable) {

            }
        });

        stage.close();
    }

    /**
     * Handles the event when the create customer button is clicked.
     *
     * @param event The mouse event that triggered the event.
     */
    @FXML
    void fxOnClickGenerateReport(MouseEvent event) {
        stage = Navigate.toWindow("Generate Report", "invoice_report_generator_form.fxml", this);
    }
}