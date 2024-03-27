package org.jht.component;

import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
import org.jetbrains.annotations.NotNull;
import org.jht.dto.Customer;
import org.jht.service.CustomerService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.Objects;

public class CustomerComboBoxMapping {

    private static String format(Customer customer) {
        return String.format("%s | %s", customer.getId(), customer.getCompanyName());
    }

    public static void map(ComboBox<Customer> comboBox) {
        final CustomerService customerService = new CustomerService();

        customerService.get(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Customer>> call, @NotNull Response<List<Customer>> response) {
                if (response.body() != null) {
                    comboBox.getItems().addAll(response.body());

                    comboBox.setConverter(new StringConverter<>() {
                        @Override
                        public String toString(Customer customer) {
                            return format(customer);
                        }

                        @Override
                        public Customer fromString(String string) {
                            System.out.println(string);
                            return comboBox.getItems().filtered(staff -> Objects.equals(string, format(staff))).getFirst();
                        }
                    });
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Customer>> call, @NotNull Throwable throwable) {

            }
        });
    }
}
