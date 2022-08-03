package com.system.payment.service.service.impl;

import com.system.payment.service.model.Payment;
import com.system.payment.service.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL ::: Received the payment {} ", payment);
    }
}
