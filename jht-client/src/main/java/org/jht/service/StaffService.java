package org.jht.service;

import org.jht.dto.Staff;
import org.jht.support.HttpClient;
import org.repository.StaffRepository;
import retrofit2.Callback;

import java.util.List;

/**
 * The StaffService class provides methods for managing staff members.
 */
public class StaffService {

    /**
     * Retrieves all staff members from the server.
     *
     * @param callback The callback function to handle the response.
     */
    public void get(Callback<List<Staff>> callback) {
        HttpClient.use(StaffRepository.class).get().enqueue(callback);
    }

    /**
     * Performs a POST request to create a new staff member.
     *
     * @param staff    The staff member to be created.
     * @param callback The callback function to handle the response.
     */
    public void post(Staff staff, Callback<Staff> callback) {
        HttpClient.use(StaffRepository.class).post(staff).enqueue(callback);
    }

    /**
     * Deletes a staff member from the API database with the specified ID.
     *
     * @param staff    The staff member to delete.
     * @param callback The callback function to handle the response. The callback receives a boolean indicating whether the deletion was successful or not.
     */
    public void delete(Staff staff, Callback<Boolean> callback) {
        HttpClient.use(StaffRepository.class).delete(staff.getId()).enqueue(callback);
    }

}
