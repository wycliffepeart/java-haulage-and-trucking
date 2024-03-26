package org.jht.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import org.jetbrains.annotations.NotNull;
import org.jht.component.SalaryTable;
import org.jht.dto.Salary;
import org.jht.dto.Staff;
import org.jht.service.SalaryService;
import org.jht.service.StaffService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SalaryTableController implements Initializable {

    @FXML
    public TableView<Salary> tableView;

    @FXML
    public ComboBox<String> fxUsersFilter;

    private final SalaryService service = new SalaryService();
    private final StaffService staffService = new StaffService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var salaryTable = new SalaryTable(tableView);

        this.staffService.getAll(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Staff>> call, @NotNull Response<List<Staff>> response) {
                if (response.body() != null) {
                    response.body().forEach(salary -> fxUsersFilter
                            .getItems()
                            .add(String.format(
                                    "%s: %s %s",
                                    salary.getTrn(),
                                    salary.getFirstName(),
                                    salary.getLastName()
                            )));
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Staff>> call, @NotNull Throwable throwable) {

            }
        });

        this.service.getAll(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Salary>> call, @NotNull Response<List<Salary>> response) {
                if (response.body() != null) {
                    salaryTable.initialize(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Salary>> call, @NotNull Throwable throwable) {
                System.out.println("Error");

                throwable.printStackTrace();
            }
        });
    }
}
