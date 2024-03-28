package org.jht.service;

import org.jht.dto.GeneratePaySlipBody;
import org.jht.dto.PaySlip;
import org.jht.support.HttpClient;
import org.repository.PaySlipRepository;
import retrofit2.Callback;

import java.io.IOException;
import java.util.List;

/**
 * A service class for managing pay slips.
 */
public class PaySlipService {

    /**
     * Fetches all pay slips.
     *
     * @param callback The callback to be invoked when the operation completes.
     */
    public void getAll(Callback<List<PaySlip>> callback) {
        HttpClient.use(PaySlipRepository.class).get().enqueue(callback);
    }

    /**
     * Posts the given pay slip to the server.
     *
     * @param paySlip  The pay slip to be posted.
     * @param callback The callback to be invoked when the operation completes.
     */
    public void post(GeneratePaySlipBody paySlip, Callback<PaySlip> callback) {
        HttpClient.use(PaySlipRepository.class).post(paySlip).enqueue(callback);
    }
}
