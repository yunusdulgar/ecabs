package com.ecabs.interview.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbit.data.exchange.message}")
    private String exchangeMessage;
    @Value("${rabbit.data.exchange.booking}")
    private String exchangeBooking;
    @Value("${rabbit.data.exchange.durable}")
    private Boolean exchangeDurable;
    @Value("${rabbit.data.exchange.autoDelete}")
    private Boolean exchangeAutoDelete;
    @Value("${rabbit.data.queue.booking.add}")
    private String queueBookingAdd;
    @Value("${rabbit.data.queue.booking.edit}")
    private String queueBookingEdit;
    @Value("${rabbit.data.queue.booking.delete}")
    private String queueBookingDelete;
    @Value("${rabbit.data.queue.message.audit}")
    private String queueMessageAudit;
    @Value("${rabbit.data.queue.booking.durable}")
    private Boolean queueBookingDurable;
    @Value("${rabbit.data.binding.all}")
    private String bindingAll;
    @Value("${rabbit.data.binding.booking.all}")
    private String bindingBookingAll;
    @Value("${rabbit.data.binding.booking.add}")
    private String bindingBookingAdd;
    @Value("${rabbit.data.binding.booking.edit}")
    private String bindingBookingEdit;
    @Value("${rabbit.data.binding.booking.delete}")
    private String bindingBookingDelete;

    @Bean
    public TopicExchange messageExchange() {
        return new TopicExchange(exchangeMessage, exchangeDurable, exchangeAutoDelete);
    }

    @Bean
    public TopicExchange bookingExchange() {
        return new TopicExchange(exchangeBooking, exchangeDurable, exchangeAutoDelete);
    }

    @Bean
    public Queue messageAuditQueue() {
        return new Queue(queueMessageAudit, queueBookingDurable);
    }

    @Bean
    public Queue bookingAddQueue() {
        return new Queue(queueBookingAdd, queueBookingDurable);
    }

    @Bean
    public Queue bookingEditQueue() {
        return new Queue(queueBookingEdit, queueBookingDurable);
    }

    @Bean
    public Queue bookingDeleteQueue() {
        return new Queue(queueBookingDelete, queueBookingDurable);
    }

    @Bean
    public Binding messageAuditBinding(final Queue messageAuditQueue, final TopicExchange messageExchange){
        return BindingBuilder.bind(messageAuditQueue)
                .to(messageExchange)
                .with(bindingAll);
    }

    @Bean
    public Binding bookingExchangeBinding(final TopicExchange bookingExchange, final TopicExchange messageExchange){
        return BindingBuilder.bind(bookingExchange)
                .to(messageExchange)
                .with(bindingBookingAll);
    }

    @Bean
    public Binding bookingAddBinding(final Queue bookingAddQueue, final TopicExchange bookingExchange){
        return BindingBuilder.bind(bookingAddQueue)
                .to(bookingExchange)
                .with(bindingBookingAdd);
    }

    @Bean
    public Binding bookingEditBinding(final Queue bookingEditQueue, final TopicExchange bookingExchange){
        return BindingBuilder.bind(bookingEditQueue)
                .to(bookingExchange)
                .with(bindingBookingEdit);
    }

    @Bean
    public Binding bookingDeleteBinding(final Queue bookingDeleteQueue, final TopicExchange bookingExchange){
        return BindingBuilder.bind(bookingDeleteQueue)
                .to(bookingExchange)
                .with(bindingBookingDelete);
    }
}
