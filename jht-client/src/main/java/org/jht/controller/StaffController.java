package org.jht.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.jht.component.StaffTable;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        var stafftable = new StaffTable(this.tableView);

        stafftable.initialize(Collections.nCopies(100, new Staff(
                1,
                "Active",
                Role.ADMIN,
                "Wycliffe",
                "Peart",
                "01/01/2024",
                "123456789",
                "John",
                "Doe",
                "234-434-4323",
                "01/01/2024",
                "01/01/2024",
                new Contact(1, "345-545-5432", "y=mail@gmail.com"),
                new Address(1, "Digicel Group Limited", "14 Ocean Boulevard Kingston Jamaica", "Kingston", "Kingston P.O")
        )));
    }


}
