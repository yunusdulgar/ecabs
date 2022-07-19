package com.ecabs.interview.listener;

import com.ecabs.interview.dto.BookingDto;
import com.ecabs.interview.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Log
@RequiredArgsConstructor
public class BookingRequestListener {

    private final BookingService bookingService;

    @RabbitListener(queues = "${rabbit.data.queue.booking.add}")
    public void insertBooking(Message<BookingDto> message) {
        log.info("insertBooking message : " + message);
        BookingDto bookingDto = message.getPayload();
        bookingService.insert(bookingDto);
    }

    @RabbitListener(queues = "${rabbit.data.queue.booking.edit}")
    public void updateBooking(Message<BookingDto> message) {
        log.info("updateBooking message : " + message);
        BookingDto bookingDto = message.getPayload();
        bookingService.update(bookingDto);
    }

    @RabbitListener(queues = "${rabbit.data.queue.booking.delete}")
    public void deleteBooking(String bookingId) {
        log.info("deleteBooking bookingId : " + bookingId);
        bookingService.delete(bookingId);
    }

    @RabbitListener(queues = "${rabbit.data.queue.message.audit}")
    public void receiveMessage(Message<?> message) {
        log.info("receiveMessage : " + message);
    }

}
