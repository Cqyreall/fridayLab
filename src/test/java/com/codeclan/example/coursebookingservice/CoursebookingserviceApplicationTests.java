package com.codeclan.example.coursebookingservice;

import com.codeclan.example.coursebookingservice.Models.Booking;
import com.codeclan.example.coursebookingservice.Models.Course;
import com.codeclan.example.coursebookingservice.Models.Customer;
import com.codeclan.example.coursebookingservice.Repositories.BookingRepository;
import com.codeclan.example.coursebookingservice.Repositories.CourseRepository;
import com.codeclan.example.coursebookingservice.Repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoursebookingserviceApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void canSaveCourse(){
//		Course newCourse = new Course("PSD", "Glasgow", 4.5);
//		courseRepository.save(newCourse);
//		assertEquals(1, courseRepository.findAll().size());
//	}

	@Test
	public void canSaveBookingAndCourseAndCustomer(){

		Customer newCustomer = new Customer("Lewis", "Glasgow", 22);
		customerRepository.save(newCustomer);

		Customer customer1 = new Customer("Craig", "Glasgow", 19);
		customerRepository.save(customer1);

		Course newCourse = new Course("PSD", "Glasgow", 4.5);
		courseRepository.save(newCourse);
		Booking newBooking = new Booking("26/11/2020", newCourse, newCustomer);
		bookingRepository.save(newBooking);

		Booking booking2 = new Booking("26/11/2020", newCourse, customer1);
		bookingRepository.save(booking2);

		customer1.addBooking(booking2);
		customerRepository.save(customer1);
		newCustomer.addBooking(newBooking);
		customerRepository.save(newCustomer);

		List<Customer> foundCustomer = customerRepository.findCustomersByTownAndBookingsCourseNameAndAgeGreaterThan("Glasgow",
				"PSD", 20);
//
		assertEquals(2, foundCustomer.size());

//		assertEquals(1, );
//		assertEquals(1, courseRepository.findAll().size());
//		assertEquals(1, customerRepository.findAll().size());
//		assertEquals(1, newCustomer.getBookings().size());


	}



}
