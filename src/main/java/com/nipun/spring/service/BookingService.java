package com.nipun.spring.service;

import com.nipun.spring.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    void addBooking(BookingDTO dto);
    BookingDTO searchBookingDetail (String driver_id);
    List<BookingDTO> getallBookingList();

}
