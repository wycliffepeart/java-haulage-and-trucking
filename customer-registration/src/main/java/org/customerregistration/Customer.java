package org.customerregistration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String registrationNumber;

    private String name;

    private String address;

    private int creditLimit;

    private long balance;

    private Date registrationData;

    public Customer(String registrationNumber, String name, String address, int creditLimit, long balance, Date registrationData) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.address = address;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.registrationData = registrationData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Date getRegistrationData() {
        return registrationData;
    }

    public void setRegistrationData(Date registrationData) {
        this.registrationData = registrationData;
    }
}
