package com.gmalheiro.java.demo_backend_worker.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentSuccessProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String exchange = "payment-response-success-exchange";
    private final String routingKey = "payment-response-success-routing-key";

    public void generateResponse (String message){
        logger.info("worker-dev message successProducer -> {}",message);
        amqpTemplate.convertAndSend(exchange,routingKey,message);
    }

}
