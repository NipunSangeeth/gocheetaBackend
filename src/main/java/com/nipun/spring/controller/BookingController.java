package com.nipun.spring.controller;


import com.nipun.spring.dto.BookingDTO;
import com.nipun.spring.service.BookingService;
import com.nipun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin

public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/booking/save")
    public ResponseEntity<?> addBooking(@RequestBody BookingDTO dto) {
        bookingService.addBooking(dto);
        StandradResponse response = new StandradResponse(200, "Booking Successfully Created", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/booking/search/{booking_id}")
    public ResponseEntity<?> searchBookingDetail(@PathVariable String booking_id) {
        BookingDTO bookingDetailDTO = bookingService.searchBookingDetail(booking_id);
        return new ResponseEntity<>(new StandradResponse(200, "Success", bookingDetailDTO), HttpStatus.OK);
    }


    @GetMapping("/booking/view-all")
    public ResponseEntity<?> getallBookingList() {
        List<BookingDTO> allBookingList = bookingService.getallBookingList();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allBookingList), HttpStatus.OK);
    }

}
