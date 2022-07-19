package com.ecabs.interview.service;

import com.ecabs.interview.dto.BookingDto;
import com.ecabs.interview.model.Booking;
import com.ecabs.interview.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public BookingDto insert(BookingDto bookingDto) {
        return modelMapper.map(bookingRepository.save(bookingRepository.save(modelMapper.map(bookingDto, Booking.class))), BookingDto.class);
    }

    @Override
    @Transactional
    public BookingDto update(BookingDto bookingDto) {
        Assert.isNull(bookingDto.getId(), "Id cannot be null");
        Optional<Booking> booking = bookingRepository.findById(bookingDto.getId());
        Booking bookingToUpdate = booking.map(it -> {
            it.setPassengerName(bookingDto.getPassengerName());
            it.setPassengerContactNumber(bookingDto.getPassengerContactNumber());
            it.setLastModifiedOn(LocalDateTime.now());
            return it;
        }).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(bookingRepository.save(bookingToUpdate), BookingDto.class);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        bookingRepository.delete(booking);
    }
}
