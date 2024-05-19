package de.addesso.activemq.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentHistoryService {

    @Value("${queue.payment}")
    private String paymentQueue;

    @JmsListener(destination = "${queue.payment}")
    public void logPaymentQueue(String payementInfo) {
        System.out.println(payementInfo);
    }

}
