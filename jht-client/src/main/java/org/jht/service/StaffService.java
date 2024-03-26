package org.jht.service;

import org.jht.dto.Staff;
import org.jht.support.HttpClient;
import org.repository.StaffRepository;

import java.io.IOException;
import java.util.List;

public class StaffService {

    public List<Staff> getAll() {
        try {
            return HttpClient.use(StaffRepository.class).staffList().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
