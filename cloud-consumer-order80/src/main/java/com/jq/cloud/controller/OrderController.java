package com.jq.cloud.controller;

import com.jq.cloud.bean.CommonResult;
import com.jq.cloud.bean.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private final static String PAY_URL = "http://localhost:8001/";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
//        return restTemplate.getForObject(PAY_URL+"/payment/getPaymentById",CommonResult.class, id);
        return restTemplate.getForObject(PAY_URL+"payment/getPaymentById/"+id,CommonResult.class);
    }

    @PostMapping("/consumer/payment/addPayment")
    public CommonResult addPayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAY_URL+"/payment/addPayment",payment,CommonResult.class);
    }
}
