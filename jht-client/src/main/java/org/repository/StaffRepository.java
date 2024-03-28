package org.repository;

import org.jht.dto.Staff;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * StaffRepository is an interface used to interact with the staff-related endpoints of the API.
 */
public interface StaffRepository {

    /**
     * This method communicates with the "staffs" GET endpoint of the API.
     * It gets a list of all staff objects present in the API database.
     *
     * @return Call<List<Staff>> This returns a Call object which can contain a list of Staff objects.
     */
    @GET("staffs")
    Call<List<Staff>> get();

    /**
     * This method communicates with the "staffs" POST endpoint of the API.
     * It posts (i.e., writes/inserts) a Staff object to the API database.
     *
     * @param staff This is the staff object that needs to be inserted in the API database.
     * @return Call<Staff> This returns a Call object which can contain the inserted Staff object.
     */
    @POST("staffs")
    Call<Staff> post(@Body Staff staff);

    /**
     * Deletes a staff object from the API database with the specified ID.
     *
     * @param id The ID of the staff object to delete.
     * @return A Call object which can contain the deleted Staff object.
     */
    @DELETE("staffs/{id}")
    Call<Boolean> delete(@Path("id") int id);
}