package org.jht.server.support;

import com.github.javafaker.Faker;
import org.jht.server.entity.*;
import org.jht.server.repository.CustomerRepository;
import org.jht.server.repository.OrderRepository;
import org.jht.server.repository.StaffRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Seeder {

    final Faker faker = new Faker();

    private final CustomerRepository customerRepository;
    private final StaffRepository staffRepository;
    private final OrderRepository orderRepository;

    public Seeder(CustomerRepository customerRepository, StaffRepository staffRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.staffRepository = staffRepository;
        this.orderRepository = orderRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");

        this.customerRepository.saveAll(seedCustomer());
        this.staffRepository.saveAll(getStaffFakeList());
        this.orderRepository.saveAll(getFakeOrderEntities());
    }

    public List<Customer> seedCustomer() {

        return Stream.generate(this::getCustomer).limit(50).collect(Collectors.toList());
    }

    public List<Staff> getStaffFakeList() {
        return Stream.generate(this::getStaff).limit(50).collect(Collectors.toList());
    }

    public List<OrderEntity> getFakeOrderEntities() {
        return Stream.generate(() -> new OrderEntity()
                .setInvoiceNumber(String.valueOf(faker.number().randomNumber(9, true)))
                .setRate(faker.number().randomDouble(2, 10, 100))
                .setAdmin(getStaff())
                .setDriver(getStaff())
                .setCustomer(getCustomer())
                .setSourceAddress(getAddress())
                .setDestinationAddress(getAddress())
        ).limit(50).collect(Collectors.toList());
    }

    public Customer getCustomer() {
        return new Customer()
                .setStatus("Active")
                .setCompanyName(faker.company().name())
                .setContactPerson(faker.name().name())
                .setAddress(getAddress())
                .setContact(getContact())
                .setCreatedAt(new Date())
                .setUpdatedAt(new Date());
    }

    public Staff getStaff() {
        return new Staff()
                .setRole(Role.STAFF)
                .setTrn(String.valueOf(faker.number().numberBetween(111111111, 999999999)))
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setDob(new Date())
                .setStatus("Active")
                .setAddress(getAddress())
                .setContact(getContact())
                .setNextOfKinFirstName(faker.name().firstName())
                .setNextOfKinLastName(faker.name().lastName())
                .setNextOfKinContactNumber(faker.phoneNumber().phoneNumber());
    }

    public Contact getContact() {
        return new Contact()
                .setNumber(faker.phoneNumber().phoneNumber())
                .setEmail(faker.internet().emailAddress());
    }

    public Address getAddress() {
        return new Address()
                .setLineTwo(faker.address().fullAddress())
                .setLineTwo(faker.address().fullAddress())
                .setParish(faker.address().city())
                .setPostOffice(faker.address().state());
    }
}