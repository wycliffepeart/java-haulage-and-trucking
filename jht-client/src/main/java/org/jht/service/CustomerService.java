package org.jht.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jht.dto.Customer;
import org.jht.support.HttpClient;
import org.repository.CustomerRepository;
import retrofit2.Callback;

import java.util.List;

/**
 * The CustomerService class provides methods for interacting with customer data.
 * It uses an HTTP client to communicate with a server and perform CRUD operations on customer objects.
 */
public class CustomerService {

    /**
     * The logger variable is used for logging messages within the CustomerService class.
     * It is an instance of the Logger class from the Log4j framework.
     * The logger is defined as protected and final, indicating that it cannot be modified or overridden by subclasses.
     * The logger is retrieved using the getLogger method from the LogManager class, with the CustomerService class as the logger name.
     *
     * Example usage:
     * logger.debug("Debug message"); // Logs a debug level message
     * logger.info("Info message");   // Logs an info level message
     * logger.warn("Warn message");   // Logs a warn level message
     * logger.error("Error message"); // Logs an error level message
     *
     * JavaDoc References:
     * - Logger: org.apache.logging.log4j.Logger
     * - LogManager: org.apache.logging.log4j.LogManager
     */
    protected static final Logger logger = LogManager.getLogger(CustomerService.class);

    /**
     * Retrieves all customers.
     *
     * @param callback the callback to be invoked when the request completes
     */
    public void get (Callback<List<Customer>> callback) {
        HttpClient.use(CustomerRepository.class).get().enqueue(callback);
    }

    /**
     * Sends a POST request to the server with the provided Customer object.
     *
     * @param customer the Customer object to be sent in the request
     * @param callback the callback to be invoked when the request completes
     */
    public void post(Customer customer, Callback<Customer> callback) {
        HttpClient.use(CustomerRepository.class).post(customer).enqueue(callback);
    }
}
