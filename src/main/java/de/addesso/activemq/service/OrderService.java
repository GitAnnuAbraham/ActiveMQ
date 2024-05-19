package de.addesso.activemq.service;

import jakarta.jms.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final JmsTemplate jmsTemplate;

    @Value("${queue.order}")
    private String orderQueue;

    public OrderService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendOrder(String order) {
        jmsTemplate.convertAndSend(orderQueue, order);
    }
}
