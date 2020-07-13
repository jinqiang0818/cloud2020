package com.jq.cloud.service.impl;

import com.jq.cloud.bean.Payment;
import com.jq.cloud.dao.PaymentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jq.cloud.service.PaymentService;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(Long id) {
        log.info("我来打印一下看看");
//        return new Payment(1000L,"我是ljq");

        return paymentDao.getPaymentById(id);
    }

    @Override
    public Long addPayment(Payment payment) {
        paymentDao.addPayment(payment);
        return payment.getId();
    }
}
