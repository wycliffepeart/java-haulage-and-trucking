package org.jht.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;
import org.jht.component.StaffTable;
import org.jht.dto.Staff;
import org.jht.service.StaffService;
import org.jht.support.Navigate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


/**
 * The StaffTableController class controls the staff table view and its interactions.
 */
public class StaffTableController implements Initializable {

    @FXML
    public TableView<Staff> tableView;

    @FXML
    private Button fxAddStaffButton;

    private final StaffService service = new StaffService();

    /**
     * Initializes the StaffTableController class.
     *
     * @param location
     *              The location used to resolve relative paths for the root object, or {@code null} if the location is not known.
     * @param resources
     *              The resources used to localize the root object, or {@code null} if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        var stafftable = new StaffTable(this.tableView);

        this.service.get(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Staff>> call, @NotNull Response<List<Staff>> response) {
                Platform.runLater(() -> stafftable.initialize(response.body()));
            }

            @Override
            public void onFailure(@NotNull Call<List<Staff>> call, @NotNull Throwable throwable) {

            }
        });
    }

    /**
     * Event handler for the "Add Staff" button click.
     *
     * @param event The MouseEvent that triggered the event.
     */
    @FXML
    void addStaffOnClickListener(MouseEvent event) {
        Navigate.toWindow("Add Staff", "staff_form.fxml");
    }
}
