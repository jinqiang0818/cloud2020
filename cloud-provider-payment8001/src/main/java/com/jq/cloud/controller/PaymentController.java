package com.jq.cloud.controller;

import com.jq.cloud.bean.CommonResult;
import com.jq.cloud.bean.Payment;
import com.jq.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("1212我来试一下热部署1231312");
        return new CommonResult(200, "请求成功",payment);
    }


    @PostMapping("/payment/addPayment")
    public CommonResult addPayment(@RequestBody Payment payment) {
        Long id = paymentService.addPayment(payment);
        return new CommonResult(200,"请求成功",id);
    }

    @PostMapping(value = "/payment/getPaymentById2",consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    public Payment getPaymentById2(@RequestBody Payment paymentDto) {
        Payment payment = paymentService.getPaymentById(paymentDto.getId());
        log.info("1212我来试一下热部署1231312");
        return payment;
    }

}
