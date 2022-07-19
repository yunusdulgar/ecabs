package com.ecabs.interview.service;

import com.ecabs.interview.dto.BookingDto;
import com.ecabs.interview.model.Booking;
import com.ecabs.interview.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbit.data.route.booking.add}")
    private String bookingAddRoutingKey;

    @Value("${rabbit.data.route.booking.edit}")
    private String bookingEditRoutingKey;

    @Value("${rabbit.data.route.booking.delete}")
    private String bookingDeleteRoutingKey;

    @Override
    public BookingDto get(String id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(booking, BookingDto.class);
    }

    @Override
    @Transactional
    public BookingDto insert(BookingDto bookingDto) {
        String bookingId = UUID.randomUUID().toString();
        bookingDto.setId(bookingId);
        bookingDto.setCreatedOn(LocalDateTime.now());
        sendToMessage(bookingAddRoutingKey, bookingDto);
        return bookingDto;
    }

    @Override
    @Transactional
    public BookingDto update(String id, BookingDto bookingDto) {
        Assert.isNull(id, "Id cannot be null");
        sendToMessage(bookingEditRoutingKey, bookingDto);
        return bookingDto;
    }

    @Override
    @Transactional
    public void delete(String id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        sendToMessage(bookingDeleteRoutingKey, booking.getId());
    }

    private void sendToMessage(String routingKey, Object payload) {
        rabbitTemplate.convertAndSend("exchange.message", routingKey, payload);
    }
}
