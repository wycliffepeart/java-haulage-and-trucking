package org.jht.component;

import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
import org.jetbrains.annotations.NotNull;
import org.jht.dto.Staff;
import org.jht.service.StaffService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.Objects;

public class StaffComboBoxMapping {


    private static String format(Staff staff) {
        return String.format("%s | %s | %s %s", staff.getTrn(), staff.getRole().name(), staff.getFirstName(), staff.getLastName());
    }

    public static void map(ComboBox<Staff> comboBox) {

        final StaffService staffService = new StaffService();

        staffService.get(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Staff>> call, @NotNull Response<List<Staff>> response) {
                if (response.body() != null) {
                    comboBox.getItems().addAll(response.body());

                    comboBox.setConverter(new StringConverter<>() {
                        @Override
                        public String toString(Staff staff) {
                            return format(staff);
                        }

                        @Override
                        public Staff fromString(String string) {
                            System.out.println(string);
                            return comboBox.getItems().filtered(staff -> Objects.equals(string, format(staff))).getFirst();
                        }
                    });
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Staff>> call, @NotNull Throwable throwable) {

            }
        });
    }
}
