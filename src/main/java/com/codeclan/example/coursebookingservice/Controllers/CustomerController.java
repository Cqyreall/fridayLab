package com.codeclan.example.coursebookingservice.Controllers;

import com.codeclan.example.coursebookingservice.Models.Customer;
import com.codeclan.example.coursebookingservice.Repositories.CustomerRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> findCustomers(@RequestParam(name = "course", required = false) String course,
                                                        @RequestParam(name = "town", required = false) String town,
                                                        @RequestParam(name = "age", required = false) Integer age){

        if(age != null && town != null && course != null){
            return new ResponseEntity<>(customerRepository.findCustomersByTownAndBookingsCourseNameAndAgeGreaterThan(town, course, age
            ), HttpStatus.OK);
        }

        if(town != null && course != null){
            return new ResponseEntity<>(customerRepository.findCustomersByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, course), HttpStatus.OK);
        }

        if(course != null){
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
        }


        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
