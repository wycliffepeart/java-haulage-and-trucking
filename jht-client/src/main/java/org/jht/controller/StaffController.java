package org.jht.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.jht.component.StaffTable;
import org.jht.dto.Staff;
import org.jht.service.StaffService;
import org.jht.support.Navigate;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable {

    @FXML
    public TableView<Staff> tableView;

    private final StaffService service = new StaffService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        var stafftable = new StaffTable(this.tableView);

        stafftable.initialize(this.service.getAll());
    }

    @FXML
    void addStaffOnClickListener(MouseEvent event) {
        Navigate.toWindow("Add Staff", "staff_form.fxml");
    }
}
