package com.ecabs.interview.service;

import com.ecabs.interview.dto.BookingDto;

public interface BookingService {

    BookingDto insert(BookingDto bookingDto);
    BookingDto update(BookingDto bookingDto);
    void delete(String id);
}
