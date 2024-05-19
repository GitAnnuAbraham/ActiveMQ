package de.addesso.activemq.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentTransactionService {

    @Value("${queue.payment}")
    private String paymentQueue;

    @Value("${queue.order}")
    private String orderQueue;

    private JmsTemplate jmsTemplate;

    public PaymentTransactionService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = "${queue.order}")
    public void paymentQueueProcessor(String order) {
        System.out.println("Reading from order queue and processing order");
        if (isOrderPaymentReceived(order)) {
            jmsTemplate.convertAndSend(paymentQueue,"Payment confirmed for order: " + order);
        } else {
            jmsTemplate.convertAndSend(paymentQueue,"Payment failed for order: " + order);
        }
    }

    private boolean isOrderPaymentReceived(String order) {
        return true;
    }
}
