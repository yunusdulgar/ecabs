package com.ecabs.interview.service;

import com.ecabs.interview.dto.BookingDto;
import com.ecabs.interview.model.Booking;
import com.ecabs.interview.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {

    @InjectMocks
    private BookingServiceImpl service;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private BookingRepository bookingRepository;

    @Test
    public void testSuccessGetReturnBooking() {
        String bookingID = "123";
        Booking booking = new Booking();
        booking.setId(bookingID);
        when(bookingRepository.findById(bookingID)).thenReturn(Optional.of(booking));
        when(modelMapper.map(booking, BookingDto.class)).thenReturn(new ModelMapper().map(booking, BookingDto.class));
        BookingDto bookingDto = service.get(bookingID);
        assertEquals(bookingID, bookingDto.getId());
    }

    @Test
    public void testThrowsIllegalArgumentExceptionGetReturnBooking() {
        String bookingID = "123";
        Booking booking = new Booking();
        booking.setId(bookingID);
        when(bookingRepository.findById(bookingID)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> service.get(bookingID));
    }


}
