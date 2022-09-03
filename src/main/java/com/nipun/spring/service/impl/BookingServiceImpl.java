package com.nipun.spring.service.impl;


import com.nipun.spring.dto.BookingDTO;
import com.nipun.spring.entity.Booking;
import com.nipun.spring.repo.BookingRepo;
import com.nipun.spring.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional


public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addBooking(BookingDTO dto) {
        if (!repo.existsById(dto.getReservation_number())) {
            Booking c = mapper.map(dto, Booking.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Booking id already exist..!");
        }
    }

    public BookingDTO searchBookingDetail(String booking_id) {
        Optional<Booking> bookingDetail = repo.findById(booking_id);
        if (bookingDetail.isPresent()) {
            return mapper.map(bookingDetail.get(), BookingDTO.class);
        } else {
            throw new RuntimeException("No Booking for id: " + booking_id);
        }
    }

    @Override
    public List<BookingDTO> getallBookingList() {
        List<Booking> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<BookingDTO>>() {
        }.getType());
    }
}
