package com.codeclan.example.coursebookingservice.Repositories;

import com.codeclan.example.coursebookingservice.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCoursesByRating(double rating);

    List<Course> findCoursesByBookingsCustomerName(String name);
}
