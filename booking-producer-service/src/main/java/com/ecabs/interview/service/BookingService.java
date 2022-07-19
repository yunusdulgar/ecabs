package com.ecabs.interview.service;

import com.ecabs.interview.dto.BookingDto;

public interface BookingService {

    BookingDto get(String id);
    BookingDto insert(BookingDto bookingDto);
    BookingDto update(String id, BookingDto bookingDto);
    void delete(String id);
}
