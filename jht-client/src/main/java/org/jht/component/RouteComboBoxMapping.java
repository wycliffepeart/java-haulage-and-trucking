package org.jht.component;

import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
import org.jetbrains.annotations.NotNull;
import org.jht.dto.Route;
import org.jht.service.RouteService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.Objects;

public class RouteComboBoxMapping {


    private static String format(Route route) {
        return String.format("%s | %s", route.getId(), route.getDescription());
    }

    public static void map(ComboBox<Route> comboBox) {
        final RouteService routeService = new RouteService();

        routeService.get(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<List<Route>> call, @NotNull Response<List<Route>> response) {
                if (response.body() != null) {
                    comboBox.getItems().addAll(response.body());

                    comboBox.setConverter(new StringConverter<>() {
                        @Override
                        public String toString(Route route) {
                            return format(route);
                        }

                        @Override
                        public Route fromString(String string) {
                            System.out.println(string);
                            return comboBox.getItems().filtered(staff -> Objects.equals(string, format(staff))).getFirst();
                        }
                    });
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Route>> call, @NotNull Throwable throwable) {

            }
        });
    }
}
