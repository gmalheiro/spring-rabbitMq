package com.gmalheiro.java.demo_backend_api.consumer;

import com.gmalheiro.java.demo_backend_api.facade.PaymentFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class PaymentResponseErrorConsumer {
    @Autowired
    private PaymentFacade paymentFacade;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String queue = "payment-response-error-queue";
    @RabbitListener(queues = { queue })
    public void receive(@Payload Message message) {
        logger.info("api-dev message errorConsumer -> {}",message);
        System.out.println("Message " + message + "  " +  LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());
        paymentFacade.paymentError(payload);
    }
}
