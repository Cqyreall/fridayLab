package com.codeclan.example.coursebookingservice.Repositories;

import com.codeclan.example.coursebookingservice.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomersByBookingsCourseNameIgnoreCase(String name);

    List<Customer> findCustomersByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String name);

    List<Customer> findCustomersByTownAndBookingsCourseNameAndAgeGreaterThan(String town, String name, int age);
}
