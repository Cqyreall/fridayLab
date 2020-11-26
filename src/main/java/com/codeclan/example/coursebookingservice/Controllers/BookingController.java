package com.codeclan.example.coursebookingservice.Controllers;

import com.codeclan.example.coursebookingservice.Models.Booking;
import com.codeclan.example.coursebookingservice.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> findBookings(@RequestParam(name = "date", required = false) String date){

        if(date != null){
            return new ResponseEntity<>(bookingRepository.findBookingsByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
}
