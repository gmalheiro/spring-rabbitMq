package com.gmalheiro.java.demo_backend_worker.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentErrorProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String exchange = "payment-response-error-exchange";
    private final String routingKey = "payment-response-error-routing-key";

    public void generateResponse (String message){
        logger.info("worker-dev message errorProducer -> {}",message);
        amqpTemplate.convertAndSend(exchange,routingKey,message);
    }
}
