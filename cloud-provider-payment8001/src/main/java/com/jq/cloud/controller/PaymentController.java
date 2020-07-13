package com.jq.cloud.controller;

import com.jq.cloud.bean.CommonResult;
import com.jq.cloud.bean.Payment;
import com.jq.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment/getPaymentById/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("1212我来试一下热部署1231312");
        return new CommonResult(200, "请求成功",payment);
    }


    @GetMapping("/payment/getPaymentById2/{id}")
    @ResponseBody
    public Payment getPaymentById2(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }
}
