package org.jht.server.support;

import com.github.javafaker.Faker;
import org.jht.server.entity.*;
import org.jht.server.repository.*;
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
    private final SalaryRepository salaryRepository;
    private final RouteRepository routeRepository;

    public Seeder(CustomerRepository customerRepository, StaffRepository staffRepository, OrderRepository orderRepository, SalaryRepository salaryRepository, RouteRepository routeRepository) {
        this.customerRepository = customerRepository;
        this.staffRepository = staffRepository;
        this.orderRepository = orderRepository;
        this.salaryRepository = salaryRepository;
        this.routeRepository = routeRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");

        this.customerRepository.saveAll(seedCustomer());
        this.staffRepository.saveAll(getStaffFakeList());
        this.orderRepository.saveAll(getFakeOrderEntities());
        this.salaryRepository.saveAll(getFakeSalaryList());
        this.routeRepository.saveAll(getFakeRouteList());
    }

    public List<Customer> seedCustomer() {

        return Stream.generate(this::getCustomer).limit(50).collect(Collectors.toList());
    }

    public List<Staff> getStaffFakeList() {
        return Stream.generate(this::getStaff).limit(50).collect(Collectors.toList());
    }

    public List<Salary> getFakeSalaryList() {
        return Stream.generate(this::getSalary).limit(50).collect(Collectors.toList());
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

    public List<Route> getFakeRouteList(){
        return Stream.generate(this::getRoute).limit(50).collect(Collectors.toList());
    }

    public Route getRoute() {
        return new Route()
                .setRate(faker.number().randomDouble(2, 100, 1000))
                .setDescription(faker.address().fullAddress())
                .setDistance(faker.number().numberBetween(1, 10))
                .setSourceParish(faker.country().capital())
                .setDestinationParish(faker.country().capital());
    }

    public Salary getSalary() {
        return new Salary()
                .setSalary(faker.number().randomDouble(2, 100000, 100000))
                .setId(faker.number().randomDigit())
                .setStaff(getStaff())
                .setPreparedBy(getStaff())
                .setEndDate(new Date())
                .setStartDate(new Date())
                .setUpdatedAt(faker.date().birthday())
                .setCreatedAt(faker.date().birthday());
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
