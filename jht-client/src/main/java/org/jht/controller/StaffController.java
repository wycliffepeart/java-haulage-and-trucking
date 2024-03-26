package org.jht.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.jht.component.StaffTable;
import org.jht.service.StaffService;
import org.jht.support.Role;
import org.jht.dto.Address;
import org.jht.dto.Contact;
import org.jht.dto.Staff;

import java.net.URL;
import java.util.Collections;
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


}
