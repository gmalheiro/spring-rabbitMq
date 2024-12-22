package com.gmalheiro.java.demo_backend_worker.consumer;

import com.gmalheiro.java.demo_backend_worker.producer.PaymentErrorProducer;
import com.gmalheiro.java.demo_backend_worker.producer.PaymentSuccessProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentRequestConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PaymentErrorProducer errorProducer;

    @Autowired
    private PaymentSuccessProducer successProducer;

    @RabbitListener(queues = { "payment-request-queue" })
    public void receiveMessage (@Payload Message message) {
        logger.info("worker-dev message -> {}",message);
        if (new Random().nextBoolean()) {
            successProducer.generateResponse("Payment sucess!!! "+message);
        }else{
            errorProducer.generateResponse("Payment error!!! "+message);
        }
    }
}
