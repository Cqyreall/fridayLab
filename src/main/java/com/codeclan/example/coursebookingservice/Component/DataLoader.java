package com.codeclan.example.coursebookingservice.Component;


import com.codeclan.example.coursebookingservice.Models.Booking;
import com.codeclan.example.coursebookingservice.Models.Course;
import com.codeclan.example.coursebookingservice.Models.Customer;
import com.codeclan.example.coursebookingservice.Repositories.BookingRepository;
import com.codeclan.example.coursebookingservice.Repositories.CourseRepository;
import com.codeclan.example.coursebookingservice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Customer lewis = new Customer("Lewis", "Glasgow", 22);
        customerRepository.save(lewis);
        Course course1 = new Course("PSD", "Glasgow", 4.5);
        courseRepository.save(course1);
        Booking booking1 = new Booking("26/11/2020", course1, lewis);
        bookingRepository.save(booking1);

        lewis.addBooking(booking1);
        customerRepository.save(lewis);

        Customer cyril = new Customer("Cyril", "Edinburgh", 20);
        customerRepository.save(cyril);

        Course course2 = new Course("Data Analysis", "Edinburgh", 4.0);
        courseRepository.save(course2);

        Booking booking2 = new Booking("29/11/2020", course2, cyril);
        bookingRepository.save(booking2);

        cyril.addBooking(booking2);
        customerRepository.save(cyril);

        Course course3 = new Course("Artificial Intelligence", "Edinburgh", 4.9);
        courseRepository.save(course3);

        Booking booking3 = new Booking("29/11/2020", course2, cyril);
        bookingRepository.save(booking3);

        cyril.addBooking(booking3);
        customerRepository.save(cyril);






    }

}
