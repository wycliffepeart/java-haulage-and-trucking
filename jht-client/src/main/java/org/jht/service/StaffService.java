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

}
