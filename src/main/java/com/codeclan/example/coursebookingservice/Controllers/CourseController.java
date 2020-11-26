package com.codeclan.example.coursebookingservice.Controllers;


import com.codeclan.example.coursebookingservice.Models.Course;
import com.codeclan.example.coursebookingservice.Models.Customer;
import com.codeclan.example.coursebookingservice.Repositories.CourseRepository;
import com.codeclan.example.coursebookingservice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

   @Autowired
   CourseRepository courseRepository;

   @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> findCourses(@RequestParam(name = "rating", required = false) Double rating,
                                                    @RequestParam(name = "customerName", required = false) String customerName ){

      if(rating != null){
         return new ResponseEntity<>(courseRepository.findCoursesByRating(rating), HttpStatus.OK);
      }

      if(customerName !=null){
          return new ResponseEntity<>(courseRepository.findCoursesByBookingsCustomerName(customerName), HttpStatus.OK);
      }
       return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
   }
}
