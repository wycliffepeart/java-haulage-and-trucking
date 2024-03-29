package org.jht.service;

import org.jht.dto.User;
import org.jht.support.HttpClient;
import org.repository.AuthRepository;
import retrofit2.Callback;

public class UserService {

    public void auth(User user, Callback<User> callback) {
        HttpClient.use(AuthRepository.class).post(user).enqueue(callback);
    }
}
