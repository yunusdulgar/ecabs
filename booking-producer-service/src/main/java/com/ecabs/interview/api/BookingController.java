package com.ecabs.interview.api;

import com.ecabs.interview.dto.BookingDto;
import com.ecabs.interview.service.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("booking")
@RequiredArgsConstructor
@Api(value = "Booking Documentation")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    @ApiOperation(value = "Insert new booking", notes = "create new object")
    public ResponseEntity<BookingDto> insert(@RequestBody @Valid BookingDto bookingDto) {
        return ResponseEntity.ok(bookingService.insert(bookingDto));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get booking", notes = "get booking by id")
    public ResponseEntity<BookingDto> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(bookingService.get(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update booking", notes = "update booking by id")
    public ResponseEntity<BookingDto> update(
            @PathVariable("id") String id,
            @RequestBody @Valid BookingDto bookingDto
    ) {
        try {
            bookingService.update(id, bookingDto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete booking", notes = "delete booking by id")
    public ResponseEntity<BookingDto> delete(@PathVariable("id") String id) {
        try {
            bookingService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().build();
    }
}
